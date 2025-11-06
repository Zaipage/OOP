public class BankSystem {
    private BankAccount[] accounts;
    private int count;

    /* TODO : Lengkapi konstruktor BankSystem(int capacity)
       Konstruktor ini membuat sistem bank yang dapat menampung sejumlah akun.
       - capacity menentukan banyaknya akun maksimum.
       - Inisialisasi array accounts dengan ukuran capacity.
       Tidak ada nilai kembalian. */
    public BankSystem(int capacity) {
        // Type your code
        accounts = new BankAccount[capacity];
        count = 0;
    }

    /* TODO : Lengkapi method addAccount(BankAccount account)
       Menambahkan akun ke sistem.
       - Jika sudah penuh, lempar IllegalStateException.
       - Jika akun null, lempar NullPointerException.
       Tidak ada nilai kembalian. */
    public void addAccount(BankAccount account) {
        // Type your code
        if (count >= accounts.length){
            throw new IllegalStateException("Sistem bank sudah penuh");
        }

        if (account == null){
            throw new NullPointerException("Akun tidak boleh kosong");
        }

        accounts[count++] = account;
        // dalam array count tu jumlah akun saat ini
    }

    /* TODO : Lengkapi method findAccount(String owner)
       Mencari akun berdasarkan nama pemilik.
       - Jika tidak ditemukan, return null.
       Return: objek BankAccount atau null jika tidak ada. */
    public BankAccount findAccount(String owner) {
        // Type your code
        for (int i = 0; i < count; i++){
            if (accounts[i].getOwner().equals(owner)){
                return accounts[i];
            }
        }
        return null;
    }

    /* TODO : Lengkapi method displayAll()
       Menampilkan semua akun yang ada di sistem.
       Format:
       Daftar Akun:
       - <nama> - Saldo: Rp<saldo>
       Jika belum ada akun, tampilkan pesan "(tidak ada akun)". */
    public void displayAll() {
        // Type your code
        System.out.println("Daftar Akun:");
        if (count == 0){
            System.out.println("(tidak ada akun)");
        } else {
            for (int i = 0; i < count; i++){
                System.out.println("- " + accounts[i].toString());
            }
        }
    }
}
