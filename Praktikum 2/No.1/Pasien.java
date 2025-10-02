public class Pasien {
    private static int nomorUrut = 1;

    private String nomorPasien;
    private DataPribadi dataPribadi;
    private String keluhan;
    private String tingkatUrgent;
    private Dokter dokterPemeriksa;
    private double biaya;
    private boolean sudahSelesai;

    // TODO 1: Buat constructor yang menerima DataPribadi, keluhan, dan tingkatUrgent
    public Pasien(DataPribadi dataPribadi, String keluhan, String tingkatUrgent) {
        // TODO 1a: Generate nomorPasien menggunakan format "P0001", "P0002", dst.
        nomorPasien = String.format("P%04d",nomorUrut);
        // Petunjuk: Gunakan String.format("%04d", nomorUrut) untuk angka 4 digit dengan leading zeros

        // TODO 1b: Tambahkan nomorUrut untuk pasien berikutnya
        nomorUrut++;
        // TODO 1c: Inisialisasi semua variabel instance
        this.dataPribadi = dataPribadi;
        this.keluhan = keluhan;
        this.tingkatUrgent = tingkatUrgent;
        // Set dokterPemeriksa ke null, biaya ke 0.0, sudahSelesai ke false
        dokterPemeriksa = null;
        biaya = 0.0;
        sudahSelesai = false;
    }

    // TODO 2: Buat method assignDokter() yang menerima object Dokter
    public boolean assignDokter(Dokter dokter) {
        // TODO 2a: Periksa apakah dokter dapat menangani tingkat urgensi pasien ini
        // Aturan:
        // - Pasien "Berat" hanya bisa ke dokter "Jantung" atau "Anak"
        // - Pasien "Sedang" tidak boleh ke dokter "Umum"
        // - Pasien "Ringan" bisa ke dokter mana saja
        // Return false jika aturan dilanggar
        boolean check = false;
        switch (tingkatUrgent) {
            case "Berat":
                check = dokter.getSpesialisasi().equals("Jantung") || dokter.getSpesialisasi().equals("Anak");break;
            case "Sedang":
                check = !dokter.getSpesialisasi().equals("Umum");break;
            case "Ringan":
                check = true;break;
            default: 
                check = false;
        }

        if(!check){
            return false;
        }
        if(!dokter.tambahPasien()){
            return false;
        }

        double multiplier = 1.0;
        switch (tingkatUrgent) {
            case "Berat": multiplier = 2.0; break;
            case "Sedang": multiplier = 1.5; break;
            case "Ringan": multiplier = 1.0; break;
        }
        biaya = multiplier * dokter.getTarif();
        // TODO 2b: Hitung biaya berdasarkan tingkatUrgent
        // Multipliers: "Ringan" = 1.0, "Sedang" = 1.5, "Berat" = 2.0
        // Formula: biaya = dokter.getTarif() * multiplier


        // TODO 2c: Assign dokter dan tambahkan pasien ke hitungan dokter
        // Set dokterPemeriksa dan panggil dokter.tambahPasien()
        dokterPemeriksa = dokter;

        // Return true jika berhasil
        return true;
    }

    // TODO 3: Buat method resetAssignment()
    // Reset dokterPemeriksa ke null dan biaya ke 0
    public void resetAssignment() {
        
        dokterPemeriksa = null;
        biaya = 0.0;
    }

    // TODO 4: Override method toString()
    // Format: "nomorPasien - nama (tingkatUrgent) - Biaya: RpX,XXX"
    // Petunjuk: Gunakan String.format("%,.0f", biaya) untuk format mata uang dengan koma
    @Override
    public String toString() {
        return String.format("%s - %s (%s) - Biaya: Rp%,.0f", nomorPasien, dataPribadi.getNama(), tingkatUrgent, biaya);
    }

    // TODO 5: Buat method getter untuk semua atribut yang diperlukan
    public Dokter getDokterPemeriksa() {
        return dokterPemeriksa;
    }

    public double getBiaya() {
        return biaya;
    }

    public String getTingkatUrgent() {
        return tingkatUrgent;
    }

    public DataPribadi getDataPribadi() {
        return dataPribadi;
    }
}