/**
 * Class Movie - Template
 *
 * Kelas ini merepresentasikan film yang tersedia di platform streaming.
 * Film dapat diputar dan juga dapat diunduh untuk ditonton offline.
 */

public class Movie implements Playable, Downloadable {
    // TODO: Buat field-field yang diperlukan:
    // - String title (judul film)
    // - int duration (durasi dalam detik)
    // - long fileSize (ukuran file dalam bytes)
    // - String genre (genre film)
    // - boolean isPlaying (status pemutaran)
    // - int downloadProgress (progress download 0-100)
    private String title;
    private int duration;
    private long fileSize;
    private String genre;
    private boolean isPlaying;
    private int downloadProgress;

    // TODO: Buat constructor yang menerima title, duration, fileSize, dan genre
    /**
     * Constructor untuk membuat objek Movie
     * Inisialisasi semua field dan atur isPlaying = false, downloadProgress = 0
     * Jika genre adalah "Premium", kalikan fileSize dengan 2
     * @param title judul film
     * @param duration durasi film dalam detik
     * @param fileSize ukuran file dasar dalam bytes
     * @param genre genre film ("Premium" akan menggandakan ukuran file)
     */
    public Movie(String title, int duration, long fileSize, String genre){
        this.title = title;
        this.duration = duration;
        this.genre = genre;
        this.isPlaying = false;
        this.downloadProgress = 0;

        if ("Premium".equalsIgnoreCase(genre)){
            this.fileSize = fileSize * 2;
        } else {
            this.fileSize = fileSize;
        }
    }

    // TODO: Implementasikan semua method dari interface Playable

    /**
     * Memulai pemutaran film
     * Tampilkan: "Memutar film: [title]"
     * Ubah isPlaying menjadi true
     */
    @Override
    public void play() {
        System.out.println("Memutar film: " + title);
        isPlaying = true;
    }

    /**
     * Menghentikan sementara pemutaran film
     * Tampilkan: "Film [title] dijeda"
     * Ubah isPlaying menjadi false
     */
    @Override
    public void pause() {
        System.out.println("Film " + title + " dijeda");
        isPlaying = false;
    }

    /**
     * Menghentikan sepenuhnya pemutaran film
     * Tampilkan: "Film [title] dihentikan"
     * Ubah isPlaying menjadi false
     */
    @Override
    public void stop() {
        System.out.println("Film " + title + " dihentikan");
        isPlaying = false;
    }

    /**
     * Mendapatkan durasi film dalam detik
     * @return durasi film
     */
    @Override
    public int getDuration() {
        return duration;
    }

    /**
     * Mendapatkan judul film
     * @return judul film
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * Mengecek apakah film sedang diputar
     * @return true jika sedang diputar, false jika tidak
     */
    @Override
    public boolean isPlaying() {
        return isPlaying;
    }

    // TODO: Implementasikan semua method dari interface Downloadable

    /**
     * Memulai proses download film
     * Tampilkan: "Memulai download film: [title]"
     * Set downloadProgress = 0
     * @return selalu return true
     */
    @Override
    public boolean startDownload() {
        System.out.println("Memulai download film: " + title);
        downloadProgress = 0;
        return true;
    }

    /**
     * Mendapatkan progress download film
     * Progress akan bertambah 5% setiap kali method dipanggil
     * @return persentase progress (0-100)
     */
    @Override
    public int getDownloadProgress() {
        if (downloadProgress < 100){
            downloadProgress += 5;
            if (downloadProgress > 100){
                downloadProgress = 100;
            }
        }
        return downloadProgress;
    }

    /**
     * Membatalkan proses download film
     * Set downloadProgress = 0
     * Tampilkan: "Download film [title] dibatalkan"
     */
    @Override
    public void cancelDownload() {
        downloadProgress = 0;
        System.out.println("Download film " + title + " dibatalkan");
    }

    /**
     * Mendapatkan ukuran file film
     * Ukuran akan 2x lebih besar jika genre adalah "Premium"
     * @return ukuran file dalam bytes
     */
    @Override
    public long getFileSize() {
        return fileSize;
    }

    /**
     * Mengecek apakah download film sudah selesai
     * @return true jika progress >= 100%, false jika belum
     */
    @Override
    public boolean isDownloadComplete() {
        return downloadProgress >= 100;
    }

    /**
     * Mendapatkan path lokasi download film
     * Ganti spasi dalam title dengan underscore
     * @return path dengan format "/downloads/movies/[title_tanpa_spasi].mp4"
     */
    @Override
    public String getDownloadPath() {
        String safeTitle = title.replace(" ", "_");
        return "/downloads/movies/" + safeTitle + ".mp4";
    }

    // TODO: Buat method tambahan getGenre() untuk mendapatkan genre film
    /**
     * Mendapatkan genre film
     * @return genre film
     */
    public String getGenre() {
        return genre;
    }
}