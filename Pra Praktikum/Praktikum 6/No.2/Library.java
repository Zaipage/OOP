import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    // Todo: Buat atribut name (String) dan sections (List<Section>)
    private String name;
    private List<Section> sections;

    public Library(String name) {
        // Todo: Implementasi konstruktor dengan inisialisasi atribut name dengan parameter name
        // dan inisialisasi sections sebagai ArrayList kosong
        this.name = name;
        this.sections = new ArrayList<>();
    }

    // Todo: Implementasi method addSection yang menerima parameter Section
    public void addSection(Section section){
        // Method ini menambahkan section ke list sections
        sections.add(section);
        // Tampilkan pesan: "Section '[nama section]' added to [nama library]"
        System.out.println("Section '" + section.getSectionName() + "' added to " + name); // di bawah ada class Section utk dipakai getSectionName
    }

    // Todo: Implementasi method findBook yang menerima parameter String title
    public void findBook(String title){
        boolean found = false;
        for (Section section : sections){ // ambil setiap section yang ada di library
            for (Section.Book book : section.getBooks()){ // untuk setiap buku di section ini. Pakai "Section." karena buku dari kelas Section
            // pake section.getbooks() karena section itu objek dari kelas book terus sebelumnya tu Section section : sections
            // kalo ga pakai "section." nanti bingung mau ambil buku dari mana, udah gitu kalo mau ambil buku harus make fungsi getter
                // Method ini mencari buku berdasarkan judul di semua section
                if (book.getTitle().equalsIgnoreCase(title)){
                    // Jika ditemukan, tampilkan:
                    // - "Found "[title]" in [nama section] section"
                    // - Detail buku menggunakan getDetails()
                    // Jika tidak ditemukan, tampilkan: "Book "[title]" not found in library"
                    System.out.println("Found \"" + title + "\" in " + section.getSectionName() + " section"); // sebenernya ga perlu book.getTitle karena di loppnya udah jelas section.book "book"
                    System.out.println(book.getDetails());
                    found = true;
                    break;
                } 

            }
        }
        if(!found){
            System.out.println("Book \"" + title + "\" not found in library"); // pakai title aja karena ga di dalam loop yg menyatakan book
        }
    }
    

    // Todo: Implementasi method displayAllBooks tanpa parameter
    // Method ini menampilkan semua buku di semua section
    public void displayAllBooks(){
        for (Section section : sections){
            section.displayBooks();
        }
    }

    // Todo: Implementasi getter getName() yang mengembalikan name
    public String getName(){
        return name;
    }

    // Todo: Implementasi getter getSections() yang mengembalikan sections
    public List<Section> getSections(){
        return Collections.unmodifiableList(sections);
    }

    // Static Nested Class - Section
    public static class Section {
        // Todo: Buat atribut sectionName (String) dan books (List<Book>)
        private String sectionName;
        private List<Book> books;

        public Section(String sectionName) {
            // Todo: Implementasi konstruktor
            // Inisialisasi sectionName dengan parameter
            this.sectionName = sectionName;
            // Inisialisasi books sebagai ArrayList kosong
            this.books = new ArrayList<>();
        }

        // Todo: Implementasi method addBook yang menerima parameter Book
        // Method ini menambahkan book ke list books
        // Tampilkan pesan: "Book "[judul buku]" added to [nama section] section"
        public void addBook(Book book){
            books.add(book);
            System.out.println("Book \"" + book.getTitle() + "\" added to " + sectionName + " section");

        }

        // Todo: Implementasi method removeBook yang menerima parameter String title
        // Method ini menghapus buku berdasarkan judul dari list books
        // Gunakan looping untuk mencari buku dengan judul yang sesuai (case-insensitive)
        // Jika ditemukan:
        // - Hapus buku dari list
        // - Tampilkan: "Book "[title]" removed from [nama section] section"
        // Jika tidak ditemukan:
        // - Tampilkan: "Book "[title]" not found in [nama section] section"
        public void removeBook(String title){
            for (int i = 0; i < books.size(); i++){
                if (books.get(i).getTitle().equalsIgnoreCase(title)){ // pake get(i) karena kita mau hapus buku pada indeks tertentu
                    books.remove(books.get(i));
                    System.out.println("Book \"" + title + "\" removed from " + sectionName + " section"); // make title aja krna parameternya itu & udah tersimpen di get(i).getTitle()
                } else {
                    System.out.println("Book \"" + title + "\" not found in " + sectionName + " section");

                }
            }
            
        }

        // Todo: Implementasi method displayBooks tanpa parameter
        // Jika books kosong, tampilkan: "No books in this section"
        // Jika ada buku, tampilkan detail setiap buku
        public void displayBooks(){
            if(books.isEmpty()){
                System.out.println("No books in this section");
            } else {
                for (Book book : books){
                    System.out.println(book.getDetails()); // gabisa langsung "books." karena books itu list, trus gabisa "book." tanpa loop karena book nya belum jadi variabel kecuali bukunya cuma 1. 
                    // tapi karena dia list otomatis buku lebih dari 1 jadi harus looping dlu
                }
            }
        }

        // Todo: Implementasi getter getSectionName() yang mengembalikan sectionName
        public String getSectionName(){
            return sectionName;
        }

        // Todo: Implementasi getter getBooks() yang mengembalikan books
        public List<Book> getBooks(){
            return Collections.unmodifiableList(books);
        }

        // Non-static Inner Class - Book
        public class Book {
            // Todo: Buat atribut:
            // - title (String)
            private String title;
            // - author (String)
            private String author;
            // - isAvailable (boolean)
            private boolean isAvailable;
            // - borrowedBy (String)
            private String borrowedBy;

            public Book(String title, String author) {
                // Todo: Implementasi konstruktor
                this.title = title;
                // Inisialisasi title dan author dengan parameter
                this.author = author;
                // Set isAvailable = true
                this.isAvailable = true;
                // Set borrowedBy = null
                this.borrowedBy = null;

            }

            // Todo: Implementasi method borrowBook yang menerima parameter String memberName
            // Jika buku sudah dipinjam (!isAvailable):
            // - Tampilkan: "Error: Book "[title]" is already borrowed by [borrowedBy]"
            // Jika tersedia:
            // - Set isAvailable = false
            // - Set borrowedBy = memberName
            // - Tampilkan: "Book "[title]" is now borrowed by [memberName]"
            public void borrowBook(String memberName){
                if (!isAvailable){
                    System.out.println("Error: Book \"" + title + "\" is already borrowed by " + borrowedBy);
                } else {
                    isAvailable = false; // karena kalo available berarti dipinjam makanya dia jadi false karena dipinjam
                    borrowedBy = memberName;
                    System.out.println("Book \"" + title + "\" is now borrowed by " + memberName);
                }
            }

            // Todo: Implementasi method returnBook tanpa parameter
            // Jika buku sedang tidak dipinjam (isAvailable):
            // - Tampilkan: "Error: Book "[title]" is not currently borrowed"
            // Jika sedang dipinjam:
            // - Tampilkan: "Book "[title]" returned by [borrowedBy]"
            // - Set isAvailable = true
            // - Set borrowedBy = null
            public void returnBook(){
                if (isAvailable){
                    System.out.println("Error: Book \"" + title + "\" is not currently borrowed");
                } else {
                    System.out.println("Book \"" + title + "\" returned by " + borrowedBy);
                    isAvailable = true;
                    borrowedBy = null;
                }
            }

            // Todo: Implementasi method getDetails() yang mengembalikan String
            // Buat variabel status:
            // - Jika isAvailable = true, status = "Available"
            // - Jika isAvailable = false, status = "Borrowed by [borrowedBy]"
            // Return format: "Book "[title]" by [author] [[status]] - Section: [sectionName]"
            // Note: Book dapat mengakses sectionName dari enclosing class Section
            public String getDetails(){
                String status; // buat variabelnya dulu biar bisa dipake
                if (isAvailable){
                    status = "Available";
                } else {
                    status = "Borrowed by " + borrowedBy;
                }
                return "Book \"" + title + "\" by " + author + " [" + status + "] - Section: " + sectionName; // langsung sectionName karena book itu innerclass Section jadi bisa akses field Section yaitu sectionName

            }

            // Todo: Implementasi getter getTitle() yang mengembalikan title
            public String getTitle(){
                return title;
            }

            // Todo: Implementasi getter getAuthor() yang mengembalikan author
            public String getAuthor(){
                return author;
            }

            // Todo: Implementasi getter isAvailable() yang mengembalikan isAvailable
            public boolean isAvailable(){ // kalo boolean ga perlu make get lagi
                return isAvailable;
            }
        }
    }

    public static class Member {
        // Todo: Buat atribut:
        // - name (String)
        private String name;
        // - borrowedBooks (List<Section.Book>)
        private List<Section.Book> borrowedBooks;
        // - maxBorrowLimit (int)
        private int maxBorrowLimit;

        public Member(String name, int maxBorrowLimit) {
            // Todo: Implementasi konstruktor
            // Inisialisasi name dan maxBorrowLimit dengan parameter
            this.name = name;
            this.maxBorrowLimit = maxBorrowLimit;
            // Inisialisasi borrowedBooks sebagai ArrayList kosong
            this.borrowedBooks = new ArrayList<>();
        }

        // Todo: Implementasi method canBorrow() yang mengembalikan boolean
        // Return true jika jumlah borrowedBooks < maxBorrowLimit
        // Return false jika sudah mencapai limit
        public boolean canBorrow(){
            return borrowedBooks.size() < maxBorrowLimit;
        }

        // Todo: Implementasi method borrowBook yang menerima parameter Section.Book book
        // Jika member tidak bisa meminjam lagi (!canBorrow()):
        // - Tampilkan: "Error: [name] has reached the borrow limit of [maxBorrowLimit] books"
        // Jika buku tidak tersedia (!book.isAvailable()):
        // - Tampilkan: "Error: Book "[judul buku]" is not available"
        // Jika bisa meminjam:
        // - Panggil book.borrowBook(name)
        // - Tambahkan book ke borrowedBooks
        public void borrowBook(Section.Book book){
            if (!canBorrow()){
                System.out.println("Error: " + name + " has reached the borrow limit of " + maxBorrowLimit + " books");
                return;
            }
            
            if (!book.isAvailable()){ // pake "books." karena member itu sejajar sama Section alias dia bukan innerclass Book dan bukan innerclass Section
            // isAvailable nya getter karena dia method di class Book
                System.out.println("Error: Book \"" + book.getTitle() + "\" is not available");
                return;
            } 
            book.borrowBook(name); // "super." cuma dipake kalo extends
            borrowedBooks.add(book);
            
        }
        

        // Todo: Implementasi method returnBook yang menerima parameter Section.Book book
        // Jika book ada di borrowedBooks:
        // - Panggil book.returnBook()
        // - Hapus book dari borrowedBooks
        // Jika book tidak ada di borrowedBooks:
        // - Tampilkan: "Error: [name] has not borrowed "[judul buku]""
        public void returnBook(Section.Book book){
            if (borrowedBooks.contains(book)){ // list itu bisa cek isi ada atau engga make contains
                book.returnBook();
                borrowedBooks.remove(book); // kalau mau add atau hapus tempat yg nampungnya itu di depan alias "tempatlist.remove/add()"
            } else {
                System.out.println("Error: " + name + " has not borrowed \"" + book.getTitle() + "\"");
            }
        }

        // Todo: Implementasi method displayBorrowedBooks tanpa parameter
        // Tampilkan: "[name]'s Borrowed Books ([jumlah borrowed]/[maxBorrowLimit]):"
        // Jika borrowedBooks kosong:
        // - Tampilkan: "No books currently borrowed"
        // Jika ada buku yang dipinjam:
        // - Untuk setiap buku, tampilkan: "  - [title] by [author]"
        public void displayBorrowedBooks(){
            System.out.println(name + "'s Borrowed Books (" + borrowedBooks.size() + "/" + maxBorrowLimit + "):");
            if (borrowedBooks.isEmpty()){
                System.out.println("No books currently borrowed");
            } else {
                for (Section.Book book : borrowedBooks){ // untuk setiap buku dari buku yg dipinjam. Pakai "Section." karena Book itu innerclass dari Section jadi kalo class lain yg merupakan outer mau akses harus melalui Section
                    System.out.println("  - " + book.getTitle() + " by " + book.getAuthor());
                }
            }
        }
    }
}