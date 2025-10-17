import java.util.List;
import java.util.ArrayList;

public final class GedungInternasional implements Asrama {
    // List<Mahasiswa> penghuni;
    // Integer kapasitas;
    List<Mahasiswa> penghuni;
    Integer kapasitas;

    /*
     * TODO: Implementasikan constructor kelas GedungInternasional
     * penghuni diinisialisasi dengan ArrayList baru
     * kapasitas diinisialisasi sesuai parameter
     */
    public GedungInternasional(Integer kapasitas) {
        //TODO: answer here
        this.penghuni = new ArrayList<>();
        this.kapasitas = kapasitas;
    }

    /*
     * TODO: Implementasikan method infoAsrama
     * Tampilkan "Asrama Gedung Internasional dengan kapasitas <kapasitas>"
     */
    public void infoAsrama() {
        //TODO: answer here
        System.out.println("Asrama Gedung Internasional dengan kapasitas " + kapasitas);
    }

    /*
     * TODO: Implementasikan method daftarAsrama
     * Jika kapasitas sudah penuh, tampilkan "Asrama Gedung Internasional sudah penuh
     * Jika mahasiswa sudah terdaftar di asrama lain (assigned), tampilkan "Mahasiswa sudah terdaftar di asrama lain"
     * Jika mahasiswa domestik, tampilkan "Mahasiswa domestik tidak boleh mendaftar di asrama ini"
     * Jika mahasiswa asing dan asrama belum penuh, tambahkan mhs ke penghuni,
     * tampilkan "Mahasiswa <username> diterima di asrama Gedung Internasional"
     * Lalu set asrama mahasiswa ke asrama ini
     */
    public void daftarAsrama(Mahasiswa mhs) {
        //TODO: answer here
        //pakai parameter mhs utk akses2 di method ini karna "(Mahasiswa mhs)"
        if (penghuni.size() >= kapasitas){ // kapasitas penuh -> jumlah penghuni >= jumlah kapasitas
            System.out.println("Asrama Gedung Internasional sudah penuh");
            return;
        }
        
        if (mhs.isAssigned()){ //pakenya getAssigned bukan isAssigned karena di kelas mahasiswa adanya method getAssigned
            System.out.println("Mahasiswa sudah terdaftar di asrama lain");
            return;
        }
        
        if (mhs instanceof MahasiswaDomestik){ // instanceof == "objek ini bagian dari kelas ini ya?"
            System.out.println("Mahasiswa domestik tidak boleh mendaftar di asrama ini");
            return;
        }

        if (mhs instanceof MahasiswaAsing){
            // gak cek kapasitas lagi karena kalo dia lanjut nyampe sini ya tandanya kapasitasnya belum penuh
            penghuni.add(mhs);
            System.out.println("Mahasiswa " + mhs.getUsername() + " diterima di asrama Gedung Internasional"); // didepan getter kita pakai parameter methodnya + "."
            mhs.setAsrama(this);
            mhs.setAssigned(false);
        }
          
    }
}
