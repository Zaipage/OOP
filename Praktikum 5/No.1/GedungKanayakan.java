import java.util.List;
import java.util.ArrayList;

public final class GedungKanayakan implements Asrama {
    // List<Mahasiswa> penghuni;
    // Integer kapasitas;
    List<Mahasiswa> penghuni;
    Integer kapasitas;

    /*
     * TODO: Implementasikan constructor kelas GedungKanayakan
     * penghuni diinisialisasi dengan ArrayList baru
     * kapasitas diinisialisasi sesuai parameter
     */
    public GedungKanayakan(Integer kapasitas) {
        this.penghuni = new ArrayList<>();
        this.kapasitas = kapasitas;

    }

    /*
     * TODO: Implementasikan method infoAsrama
     * Tampilkan "Asrama Gedung Kanayakan dengan kapasitas <kapasitas>"
    */
    public void infoAsrama() {
        //TODO: answer here
        System.out.println("Asrama Gedung Kanayakan dengan kapasitas " + kapasitas);
    }

    /*
     * TODO: Implementasikan method daftarAsrama
     * Asrama Kanayakan hanya untuk mahasiswa domestik WANITA
     *
     * Jika kapasitas asrama penuh, tampilkan "Asrama Gedung Kanayakan sudah penuh"
     * Jika mahasiswa sudah terdaftar di asrama lain (assigned), tampilkan "Mahasiswa sudah terdaftar di asrama lain"
     * Jika mahasiswa asing, tampilkan "Mahasiswa asing tidak boleh mendaftar di asrama ini"
     * Jika mahasiswa domestik PRIA, tampilkan "Asrama Gedung Kanayakan hanya untuk mahasiswa perempuan"
     * Jika mahasiswa domestik WANITA dan asrama belum penuh, tambahkan mhs ke penghuni,
     * tampilkan "Mahasiswa <username> diterima di asrama Gedung Kanayakan"
     * Lalu set asrama mahasiswa ke asrama ini
     */
    public void daftarAsrama(Mahasiswa mhs) {
        // TODO: answer here
        if (penghuni.size() >= kapasitas){
            System.out.println("Asrama Gedung Kanayakan sudah penuh");
            return;
        }
        
        if (mhs.isAssigned()){
            System.out.println("Mahasiswa sudah terdaftar di asrama lain");
            return;
        }
        
        if (mhs instanceof MahasiswaAsing){
            System.out.println("Mahasiswa asing tidak boleh mendaftar di asrama ini");
            return;
        }
        
        if (mhs instanceof MahasiswaDomestik){
            MahasiswaDomestik mhsdomestik = (MahasiswaDomestik) mhs; // pakai casting karena method gender cuma ada di class mahasiswa domestik ga ada di kelas mahasiswa biasa
            if (mhsdomestik.getGender() == Gender.PRIA){
                System.out.println("Asrama Gedung Kanayakan hanya untuk mahasiswa perempuan");
                return;
            }
            penghuni.add(mhs);
            System.out.println("Mahasiswa " + mhs.getUsername() + " diterima di asrama Gedung Kanayakan");
            mhs.setAsrama(this);
            mhs.setAssigned(false);
        }
          
    }
}
