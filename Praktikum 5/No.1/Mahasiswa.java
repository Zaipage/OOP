public abstract class Mahasiswa implements User {    
    // static Integer mahasiswaCounter = 0;
    // private String userId; // format "1"+5 digit angka (100001, 100002, dst)
    // private String username;
    // private String password;
    // private boolean assigned; // true jika sudah diverifikasi pendaftaran asramanya oleh pengelola
    // private Asrama asrama;
    static Integer mahasiswaCounter = 0;
    private String userId;
    private String username;
    private String password;
    private boolean assigned;
    private Asrama asrama;


    /*
     * TODO: Implementasikan constructor kelas Mahasiswa
     * userId di-generate otomatis dengan format "1"+5 digit angka (100001, 100002, dst)
     * username dan password diinisialisasi dengan null
     * assigned diinisialisasi dengan false
     * mahasiswaCounter diincrement setiap ada objek Mahasiswa baru
    */
    Mahasiswa(){
        // TODO: answer here
        this.userId = String.format("1%05d", ++mahasiswaCounter); // formatnya akan bertambah berdasar nomor urut mahasiswa yaitu mahasiswaCounter
        this.username = null;
        this.password = null;
        this.assigned = false;
        this.asrama = null;

    }

    /*
     * TODO: Implementasikan method isRegistered
     * mengembalikan true jika username dan password tidak null
     * mengembalikan false jika username atau password null
     */
    public boolean isRegistered() {
        // TODO: answer here
        return username != null && password != null;
    }

    /*
     * TODO: Implementasikan method register
     * Jika sudah terdaftar, tampilkan "User dengan username <username> sudah terdaftar"
     * Jika belum terdaftar, lakukan pendaftaran dengan mengisi username dan password
     * Setelah berhasil mendaftar, tampilkan "User berhasil terdaftar"
     */
    public void register(String username, String password) {
        // TODO: answer here
        if (isRegistered()){
            System.out.println("User dengan username " + this.username + " sudah terdaftar");
        } else {
            this.username = username;
            this.password = password;
            System.out.println("User berhasil terdaftar");
        }
    }

    /*
     * TODO: Implementasikan method login
     * Jika belum terdaftar, tampilkan "User belum terdaftar"
     * Jika username dan password sesuai, tampilkan "Login berhasil" dan perkenalkan diri
     * Jika tidak sesuai, tampilkan "Login gagal"
     * perkenalkan diri dilakukan dengan memanggil method perkenalkan()
    */
    public void login(String username, String password) {
        // TODO: answer here
        if (!isRegistered()){
            System.out.println("User belum terdaftar");
        } else {
            if (this.username.equals(username) && this.password.equals(password)){
                System.out.println("Login berhasil");
                perkenalkan();
            } else {
                System.out.println("Login gagal");
            }
        }
            
    }

    /*
     * TODO: Implementasikan method login
     * Jika belum terdaftar, tampilkan "User belum terdaftar"
     * Jika ssoSlug sesuai dengan expectedSlug (this.userId + "-" + this.username), 
     * tampilkan "Login berhasil" dan perkenalkan diri
     * Jika tidak sesuai, tampilkan "Login gagal"
     * perkenalkan diri dilakukan dengan memanggil method perkenalkan()
    */
    public void login(String ssoSlug) {
        // TODO: answer here
        if (!isRegistered()){
            System.out.println("User belum terdaftar");
        } else {
            String expectedSlug = this.userId + "-" + this.username; //inisialisasi expectednya dulu biar bisa dipake di if-else equals, karena dia belum di inisialisasi dimana-mana
            if (ssoSlug.equals(expectedSlug)){
                System.out.println("Login berhasil");
                perkenalkan();
            } else {
                System.out.println("Login gagal");
            }
        }
    }


    
    /*
     * TODO: Implementasikan method getter untuk atribut asrama
     * getAsramaInfo
     * Jika asrama tidak null, panggil method infoAsrama pada objek asrama dan kembalikan true
     * Jika asrama null, tampilkan "Mahasiswa belum mendaftar asrama" dan kembalikan false
     */
    public boolean getAsramaInfo() {
        // TODO: answer here
        if (asrama == null){
            System.out.println("Mahasiswa belum mendaftar asrama");
            return false;
        } else {
            asrama.infoAsrama(); // gak pakai "super." karena mahasiswa tidak extend asrama
            // pakai "asrama." karena infoAsrama bukan milik kelas mahasiswa melainkan punya kelas asrama jadi harus di aksesn lewat objek asrama
            return true;
        }
        
    }

    /* 
     * daftarAsrama method yang akan diimplementasikan di subclass
     */
    abstract public void daftarAsrama(Asrama asrama);

    /*
     * TODO: Implementasikan method setter dan getter untuk atribut asrama, assigned, username, userId
     */

    public void setAsrama (Asrama asrama){
        this.asrama = asrama;
    }

    public Asrama getAsrama(){
        return asrama;
    }

    public void setAssigned(boolean assigned){
        this.assigned = assigned;
    }

    public boolean isAssigned(){
        return assigned;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    public String getUserId(){
        return userId;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }




}

