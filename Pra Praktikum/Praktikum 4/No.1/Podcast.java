/**
 * Class Podcast - Template
 *
 * Kelas ini merepresentasikan podcast yang dapat diputar dan diunduh.
 */

public class Podcast implements Playable, Downloadable {
    // TODO: Buat field-field yang diperlukan:
    // - String title (judul podcast)
    // - int duration (durasi dalam detik)
    // - String host (nama host podcast)
    // - int episodeNumber (nomor episode)
    // - boolean isPlaying (status pemutaran)
    // - int downloadProgress (progress download 0-100)
    // - long fileSize (ukuran file dalam bytes)
    private String title;
    private int duration;
    private String host;
    private int episodeNumber;
    private boolean isPlaying;
    private int downloadProgress;
    private long fileSize;

    // TODO: Buat constructor yang menerima title, duration, host, dan episodeNumber
    /**
     * Constructor untuk membuat objek Podcast
     * Inisialisasi semua field dan atur isPlaying = false, downloadProgress = 0
     * Hitung fileSize: (duration/60) * 1024 * 1024 bytes (1MB per menit)
     * Jika episodeNumber > 100, kalikan fileSize dengan 1.5
     * @param title judul podcast
     * @param duration durasi podcast dalam detik
     * @param host nama host podcast
     * @param episodeNumber nomor episode
     */
    public Podcast (String title, int duration, String host, int episodeNumber){
        this.title = title;
        this.duration = duration;
        this.host = host;
        this.episodeNumber = episodeNumber;
        this.isPlaying = false;
        this.downloadProgress = 0;

        this.fileSize = ((long)duration/60) * 1024 * 1024;

        if (episodeNumber > 100){
            this.fileSize = (long) (fileSize * 1.5);
        }
    }

    // TODO: Implementasikan semua method dari interface Playable

    /**
     * Memulai pemutaran podcast
     * Tampilkan: "Memutar podcast: [title] - Episode [episodeNumber] by [host]"
     * Ubah isPlaying menjadi true
     */
    @Override
    public void play() {
        System.out.println("Memutar podcast: " + title + " - Episode " + episodeNumber + " by " + host);
        isPlaying = true;
    }

    /**
     * Menghentikan sementara pemutaran podcast
     * Tampilkan: "Podcast [title] dijeda"
     * Ubah isPlaying menjadi false
     */
    @Override
    public void pause() {
        System.out.println("Podcast " + title + " dijeda");
        isPlaying = false;
    }

    /**
     * Menghentikan sepenuhnya pemutaran podcast
     * Tampilkan: "Podcast [title] dihentikan"
     * Ubah isPlaying menjadi false
     */
    @Override
    public void stop() {
        System.out.println("Podcast " + title + " dihentikan");
        isPlaying = false;
    }

    /**
     * Mendapatkan durasi podcast dalam detik
     * @return durasi podcast
     */
    @Override
    public int getDuration() {
        return duration;
    }

    /**
     * Mendapatkan judul podcast
     * @return judul podcast
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * Mengecek apakah podcast sedang diputar
     * @return true jika sedang diputar, false jika tidak
     */
    @Override
    public boolean isPlaying() {
        return isPlaying;
    }

    // TODO: Implementasikan semua method dari interface Downloadable

    /**
     * Memulai proses download podcast
     * Tampilkan: "Memulai download podcast: [title] Episode [episodeNumber]"
     * Set downloadProgress = 0
     * @return selalu return true
     */
    @Override
    public boolean startDownload() {
        System.out.println("Memulai download podcast: " + title + " Episode " + episodeNumber);
        downloadProgress = 0;
        return true;
    }

    /**
     * Mendapatkan progress download podcast
     * Progress akan bertambah 10% setiap kali method dipanggil (lebih cepat dari movie)
     * @return persentase progress (0-100)
     */
    @Override
    public int getDownloadProgress() {
        downloadProgress += 10;
        if (downloadProgress > 100){
            downloadProgress = 100;
        }
        return downloadProgress;
    }

    /**
     * Membatalkan proses download podcast
     * Set downloadProgress = 0
     * Tampilkan: "Download podcast [title] dibatalkan"
     */
    @Override
    public void cancelDownload() {
        downloadProgress = 0;
        System.out.println("Download podcast " + title + " dibatalkan");
    }

    /**
     * Mendapatkan ukuran file podcast
     * Dihitung berdasarkan durasi (1MB per menit), 1.5x lebih besar jika episode > 100
     * @return ukuran file dalam bytes
     */
    @Override
    public long getFileSize() {
        return fileSize;
    }

    /**
     * Mengecek apakah download podcast sudah selesai
     * @return true jika progress >= 100%, false jika belum
     */
    @Override
    public boolean isDownloadComplete() {
       return downloadProgress >= 100;
    }

    /**
     * Mendapatkan path lokasi download podcast
     * Ganti spasi dalam title dengan underscore
     * @return path dengan format "/downloads/podcasts/[title_tanpa_spasi]_ep[episodeNumber].mp3"
     */
    @Override
    public String getDownloadPath() {
        String safeTitle = title.replace(" ", "_");
        return "/downloads/podcasts/" + safeTitle + "_ep" + episodeNumber + ".mp3";
    }

    // TODO: Buat method tambahan getHost() dan getEpisodeNumber()
    /**
     * Mendapatkan nama host podcast
     * @return nama host
     */
    public String getHost() {
        return host;
    }

    /**
     * Mendapatkan nomor episode podcast
     * @return nomor episode
     */
    public int getEpisodeNumber() {
        return episodeNumber;
    }
}