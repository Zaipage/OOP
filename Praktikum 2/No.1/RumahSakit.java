public class RumahSakit {
    private static RumahSakit instance = null;
    private String namaRS;
    private double totalPendapatan;

    // TODO 1: Buat private constructor (syarat Singleton pattern)
    // Constructor harus menerima parameter namaRS dan inisialisasi variabel
    private RumahSakit(String namaRS) {
        this.namaRS = namaRS;
        totalPendapatan = 0;
        // instance = RumahSakit.getInstance(namaRS);
    }

    // TODO 2: Buat static method getInstance() (Singleton pattern)
    // Jika instance null, buat RumahSakit baru, jika tidak return instance yang ada
    public static RumahSakit getInstance(String namaRS) {
        if(instance == null){
            instance  = new RumahSakit(namaRS);
        }
        return instance;
    }

    // TODO 3: Buat method prosesPemeriksaan()
    // Method ini menerima Pasien dan array Dokter
    // Harus menemukan dokter terbaik yang tersedia untuk pasien
    // PENJELASAN: Dokter "terbaik" = dokter yang bisa menangani pasien DAN memiliki jumlah pasien paling sedikit
    public boolean prosesPemeriksaan(Pasien pasien, Dokter[] daftarDokter) {
        // TODO 3a: Inisialisasi variabel untuk melacak dokter terbaik
        // Anda membutuhkan: dokterTerpilih (Dokter, awalnya null) dan minPasien (int, awalnya 999)
        // minPasien digunakan untuk tracking dokter dengan pasien paling sedikit
        Dokter dokterTerpilih = null;
        int minPasien = 999;


        // TODO 3b: Loop melalui semua dokter di daftarDokter
        // Untuk setiap dokter, periksa apakah mereka bertugas dan punya ruang (< 3 pasien)
        for(Dokter d : daftarDokter){
            if(d.isSedangBertugas() && d.getJumlahPasien() < Dokter.getMaxPasien() ){
                if (pasien.assignDokter(d)) {
                    if (d.getJumlahPasien() < minPasien) {
                        dokterTerpilih = d;
                        minPasien = d.getJumlahPasien();
                    }
                    //undo temp
                    d.decrementPasien();
                    pasien.resetAssignment();
                }
             }
        }
        // TODO 3c: Untuk dokter yang cocok, tes apakah mereka bisa menangani pasien ini
        // Gunakan pasien.assignDokter(dokter) untuk tes kompatibilitas
        // Jika berhasil, periksa apakah dokter ini punya pasien lebih sedikit dari yang terbaik saat ini
        // Strategi: pilih dokter dengan beban kerja paling ringan (load balancing)
        // Ingat untuk reset assignment setelah testing: dokter.decrementPasien() dan pasien.resetAssignment()


        // TODO 3d: Setelah menemukan dokter terbaik, assign pasien
        // Panggil pasien.assignDokter(dokterTerpilih)
        // Tambahkan biaya pasien ke totalPendapatan
        // Print pesan sukses: "Berhasil: [nama pasien] ditangani [nama dokter]"

        if(dokterTerpilih != null && pasien.assignDokter(dokterTerpilih)){
            totalPendapatan += pasien.getBiaya();
            System.out.println(String.format("Berhasil: %s ditangani %s", pasien.getDataPribadi().getNama(), dokterTerpilih.getDataPribadi().getNama()));
            return true;
        }else{
            System.out.println("Error: Tidak ada dokter yang tersedia untuk pasien ini");
            return false;
        }

        // TODO 3e: Return true jika berhasil, false jika tidak ada dokter yang cocok
        // Jika tidak ada dokter, print: "Error: Tidak ada dokter yang tersedia untuk pasien ini"
    }

    // TODO 4: Buat method getter
    public String getNamaRS() {
        return namaRS;
    }

    public double getTotalPendapatan() {
        return totalPendapatan;

    }
}