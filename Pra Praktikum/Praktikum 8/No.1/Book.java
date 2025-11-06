/* TODO: Lengkapi class Book dengan validasi ISBN dan exception handling

   Fields:
   - title (String)
   - author (String)
   - isbn (String): ISBN-10 atau ISBN-13
   - publicationYear (int)
   - copies (int): total copies
   - availableCopies (int): copies yang tersedia

   Constructor:
   - Book(String title, String author, String isbn, int publicationYear, int copies)
     throws InvalidBookException

     Validasi (throw InvalidBookException dengan bookTitle, invalidField, dan optional invalidValue):
     1. title tidak boleh null/kosong (trim)
     2. author tidak boleh null/kosong (trim)
     3. author harus minimal 2 kata (pisahkan dengan split("\\s+"))
     4. publicationYear harus antara 1000 dan tahun sekarang (gunakan java.time.Year.now().getValue())
     5. copies tidak boleh negatif
     6. ISBN harus valid (panggil isValidISBN)

     Jika semua valid:
     - Set semua fields (trim untuk String)
     - Set availableCopies = copies

   Private Helper Methods untuk ISBN Validation:

   - boolean isValidISBN(String isbn)
     * Return false jika isbn null
     * Remove hyphens dan spaces: cleanISBN = isbn.replaceAll("[\\s-]", "")
     * Jika length 10: return isValidISBN10(cleanISBN)
     * Jika length 13: return isValidISBN13(cleanISBN)
     * Otherwise: return false

   - boolean isValidISBN10(String isbn)
     * ISBN-10 checksum algorithm:
       - Sum = (digit1 * 10) + (digit2 * 9) + ... + (digit9 * 2) + check_digit
       - Check digit bisa 'X' (nilai 10) atau digit 0-9
       - Valid jika Sum % 11 == 0
     * Gunakan try-catch untuk handle exceptions, return false jika error

   - boolean isValidISBN13(String isbn)
     * ISBN-13 checksum algorithm:
       - Sum = digit1 + (digit2 * 3) + digit3 + (digit4 * 3) + ... + digit13
       - Digit ganjil (index 0,2,4...) dikali 1, digit genap (index 1,3,5...) dikali 3
       - Valid jika Sum % 10 == 0
     * Gunakan try-catch, return false jika error

   Public Methods:

   - getters untuk semua fields (getTitle, getAuthor, getIsbn, getPublicationYear, getCopies, getAvailableCopies)

   - void borrowBook() throws BookNotAvailableException
     * Jika availableCopies <= 0: throw BookNotAvailableException dengan detail (title, requestedCopies=1, availableCopies)
     * Kurangi availableCopies

   - void returnBook() throws InvalidBookException
     * Jika availableCopies >= copies: throw InvalidBookException
     * Tambah availableCopies

   - toString(): return format string
     * Format EXACT (abaikan simbol <>): "<title> by <author> (<year>) [ISBN: <isbn>] - Available: <avail>/<total>"
     * <title> = judul buku
     * <author> = nama penulis
     * <year> = tahun publikasi
     * <isbn> = ISBN (dengan hyphens/spaces seperti input asli)
     * <avail> = availableCopies
     * <total> = copies
     * Contoh: "Clean Code by Robert Martin (2008) [ISBN: 0-13-235088-2] - Available: 3/5"
     * Contoh: "Design Patterns by Gang of Four (1994) [ISBN: 978-0-201-63361-0] - Available: 2/2"
*/

public class Book {
    // TODO: Declare fields
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;
    private int copies;
    private int availableCopies;

    // TODO: Implement constructor dengan validasi lengkap
    public Book(String title, String author, String isbn, int publicationYear, int copies) throws InvalidBookException {
      // basically throws InvalidBookException itu kaya bilang: "hati-hati, kalau error atau datanya kosong aku kasih InvalidBookException ya! siap-siap"
      if (title == null || title.trim().isEmpty()){
        throw new InvalidBookException("", "Unknown", "title");
      }

      if (author == null || author.trim().isEmpty()){
        throw new InvalidBookException("Author cannot be null", title.trim(), "author");
      }

      String[] authorName = author.trim().split("\\s+");
      // trim() untuk hapus spasi di awal dan akhir
      // split(regex) itu untuk mecah string jdi array berasar suatu pola
      // "split("\\s+")" artinya pisahkan teks(nama author) berdasarkan satu atau lebih spasi/tab
      // cth: "J.K. Rowling".split("\\s+"); -> hasil: ["J.K.", "Rowling"] -> jadi tercatat kalau author itu terdiri dari 2 kata
      if (authorName.length < 2){
        // karena udah disimpan informasi jumlah katanya di array
        // maka disini langsung validasi melalui length
        // karena sekarang walau misal "J.K. Rowling" itu 1 inputan tpi dia dipecah jadi 2 jumlah array
        throw new InvalidBookException("", title.trim(), "author", author.trim());
        // maka kalau kurang dari 2 dia error
      }

      int currentYear = java.time.Year.now().getValue();
      if (publicationYear < 1000 || publicationYear > currentYear){
        throw new InvalidBookException("", title.trim(), "publicationYear", String.valueOf(publicationYear));
        // pake String.valueOf utk publicatonYear karena tahun itu int, cuma di method class sebelah diminta constructornya bentuknya string
      }

      if (copies < 0){
        throw new InvalidBookException("", title.trim(), "copies", String.valueOf(copies));
      }

      if (!isValidISBN(isbn)){
        // cek apakah nilai isbn valid atau tidak berdasarkan method tsb
        // jadi isbn itu hrus ditulis sebagai nilai yg dikirim ke method
        throw new InvalidBookException("", title.trim(), "isbn", isbn);
      }

      this.title = title.trim();
      this.author = author.trim();
      this.isbn = isbn;
      this.publicationYear = publicationYear;
      this.copies = copies;
      this.availableCopies = copies;

    }

    // TODO: Implement private helper methods untuk ISBN validation
    public boolean isValidISBN(String isbn){
      if (isbn == null){
        return false;
      }

      String cleanISBN = isbn.replaceAll("[\\s-]", "");

      if (cleanISBN.length() == 10){
        return isValidISBN10(cleanISBN);
      } else if (cleanISBN.length() == 13){
        return isValidISBN13(cleanISBN);
      }
      return false;
    }

    private boolean isValidISBN10(String isbn){
      try { // pakai try agar kalau ada huruf dan simbol aneh dan error yaudah lgsg salah ga
        if (isbn == null || isbn.length() != 10){ // kalau isbn nya null atau panjang karakternya gak 10 lgsg invalid
          return false;
        }

        int sum = 0; // untuk nyimpan total sementara dari angka di isbn
        for (int i = 0; i < 9; i++){ // cuma sampe 9 karena angka ke-10 itu check digit jadi di cek terpisah
          int digit = Character.getNumericValue(isbn.charAt(i));
          // ubah huruf ke i jadi angka: '1' -> 1 dsb
          // ambil karakter ke-i dari isbn
          if (digit < 0 || digit > 9){
            // kalau karakter bukan angka (0 - 9) isbn ga valid
            return false; 
          }
          sum += digit * (10 - i);
          // kalau i = 0 -> dikali 10 karna 10 - 0 = 10 dan digit = 1, maka sum += 1 x 10
          // kalau i = 1 -> dikali 9 karna 10 - 1 = 9 dan digit = 2, maka sum += 2 x 9
          // dst
        }

        // mulai cek digit ke-10
        // hanya digit terakhir yg boleh 0-9 atau X 
        char lastChar = isbn.charAt(9);
        // lastChar -> ambil karakter i = 9 alias digit ke 10
        int checkDigit;
        // deklarasi variabel checkDigit yg akan nyimpan nilai angka dari digit terakhir
        if (lastChar == 'X' || lastChar == 'x'){
          // harus X atau x baru bisa jadi digit ke 10
          checkDigit = 10; // nilai x itu menggantikan angka 10
        } else {
          checkDigit = Character.getNumericValue(lastChar);
          // check dari lastChar dia x bukan?
          // kalau bukan x atau X, berarti harus check dia masih angka valid bukan
          if (checkDigit < 0 || checkDigit > 9){
            // kalau digit terakhir bukan angka valid maka false
            return false;
          }
        }
        sum += checkDigit; // sum yang sebelumnya ditambah sama checkDigit

        return sum % 11 == 0;
        // kalau bisa di mod 11 dan hasilnya 0, maka dia valid

      } catch (Exception e){
        // tangkap error kalau tiba2 di tengah2 ada error
        return false;
        // langsung buat jadi false aja klo ada biar ga crash
      }


    }

    private boolean isValidISBN13(String isbn){
      try {
        if (isbn == null || isbn.length() != 13){
          return false;
        }

        int sum = 0;
        for (int i = 0; i < 13; i++){ // karena dia ga ada check digit makanya iterasi sampe 13x
          int digit = Character.getNumericValue(isbn.charAt(i));
          if (digit < 0 || digit > 9){
            return false;
          }
          if (i % 2 == 0){
            // kalau i = genap (di normal ganjil) maka di modulo hasilnya akan 0
            // i = 2 (di normal = 3) -> 2 % 2 == 0 
            sum += digit;
            // maka di tambah biasa
          } else {
            sum += digit * 3;
            // tapi kalau i = genap (di normal genap) maka di modulo hasilnya gak == 0
            // maka dari itu dikali 3
            // basically kalau jumlah digit ganjil dia rumusnya x + 3x + x dst
            // beda sama 12 digit yg rumusnya: 3x + x + 3x dst
            // bobot check digit itu sebaiknya 1
            // yah basically ikutin to do ajasi wkwkwkwk
          }
        }
        return sum % 10 == 0;
      } catch (Exception e){
        return false;
      }
    }

    // TODO: Implement getters
    public String getTitle(){
      return title;
    }

    public String getAuthor(){
      return author;
    }

    public String getIsbn(){
      return isbn;
    }

    public int getPublicationYear(){
      return publicationYear;
    }

    public int getCopies(){
      return copies;
    }

    public int getAvailableCopies(){
      return availableCopies;
    }

    // TODO: Implement borrowBook()
    public void borrowBook() throws BookNotAvailableException {
      if (availableCopies <= 0){
        throw new BookNotAvailableException("", title, 1, availableCopies);
      }
      availableCopies--;
    }

    // TODO: Implement returnBook()
    public void returnBook() throws InvalidBookException {
      if (availableCopies >= copies){
        throw new InvalidBookException("", title, "availableCopies");
      }
      availableCopies++;
    }

    // TODO: Implement toString()
    @Override
    public String toString(){
      return title + " by " + author + " (" + publicationYear + ") [ISBN: " + isbn + "] - Available: " + availableCopies + "/" + copies;
    }
}
