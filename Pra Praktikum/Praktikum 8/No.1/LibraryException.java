/* TODO: Lengkapi class LibraryException
   Ini adalah base class untuk semua exception di sistem perpustakaan.

   Fields yang dibutuhkan:
   - errorCode (String): Kode error untuk mengidentifikasi jenis error
   - timestamp (long): Waktu ketika exception terjadi

   Constructors yang dibutuhkan:
   1. LibraryException(String message)
   2. LibraryException(String message, Throwable cause) - untuk exception chaining
   3. LibraryException(String message, String errorCode)
   4. LibraryException(String message, String errorCode, Throwable cause)

   Methods yang dibutuhkan:
   - getErrorCode(): mengembalikan error code
   - getTimestamp(): mengembalikan timestamp
   - getMessage(): override untuk menambahkan error code ke message

   Hint: Gunakan System.currentTimeMillis() untuk timestamp
*/

    // TODO: Lengkapi methods
public class LibraryException extends Exception {
    // TODO: Tambahkan fields
    private String errorCode;
    private long timestamp;

    // TODO: Lengkapi constructors
    public LibraryException(String message){
        super(message);
        this.timestamp = System.currentTimeMillis();
    }

    public LibraryException(String message, Throwable cause){
        super(message, cause);
        this.timestamp = System.currentTimeMillis();
    }

    public LibraryException(String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
        this.timestamp = System.currentTimeMillis();
    }

    public LibraryException(String message, String errorCode, Throwable cause){
        super(message, cause);
        this.errorCode = errorCode;
        this.timestamp = System.currentTimeMillis();
    }

    public String getErrorCode(){
        return errorCode;
    }

    public long getTimestamp(){
        return timestamp;
    }

    @Override
    public String getMessage(){
        if (errorCode != null){
            return String.format("[%s] %s", errorCode, super.getMessage());
        }
        return super.getMessage();
        // format ga ada spesifikasi jdi yg penting yaudah isi aja hehe
    }
}
