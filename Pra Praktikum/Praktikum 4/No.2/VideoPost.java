/**
 * VideoPost.java
 * 
 * Kelas VideoPost merupakan kelas turunan dari Post dan mengimplementasikan Engageable serta Shareable
 */
public class VideoPost extends Post implements Engageable, Shareable {

    private int views;
    private int durationSec;
    private boolean useAI;
  
    /**
     * Membuat objek VideoPost baru.
     * Menginisialisasi author, caption, durasi video, dan status penggunaan AI.
     * Views awal bernilai 0.
     *
     * @param author     nama pembuat postingan
     * @param caption    teks caption
     * @param durationSec durasi video dalam detik
     * @param useAI      apakah menggunakan AI
     */
    public VideoPost(String author, String caption, int durationSec, boolean useAI) {
        super(author, caption);
        this.views = 0;
        this.durationSec = durationSec;
        this.useAI = useAI;
    }
  
    /**
     * Menambah jumlah views sebesar 1.
     */
    public void view() {
      views++;
        
    }
  
    /**
     * Mengambil jumlah views pada video.
     *
     * @return jumlah views
     */
    public int getViews() {
      return views;
        
    }
  
    /**
     * Mengambil durasi video dalam detik.
     *
     * @return durasi video
     */
    public int getDurationSec() {
      return durationSec;
        
    }
  
    /**
     * Mengecek apakah video menggunakan AI.
     *
     * @return true jika menggunakan AI, false jika tidak
     */
    public boolean isUseAI() {
      return useAI;
        
    }

    /**
     * Menghitung skor engagement total untuk postingan video.
     * Perhitungan: baseScore ditambah 0.5 kali views, ditambah durationSec / 30, dikurangi 10 jika useAI
     * HINT: Jangan lupa untuk menggunakan casting
     * 
     * @return skor total engagement
     */
    private int totalScore() {
      int totalScore = baseScore();
      totalScore += (int) (0.5 * views) + (durationSec / 30);
      if (useAI){
        totalScore -= 10;
      }
      return totalScore;
        
    }
  
    /**
     * Membandingkan engagement (totalScore) antara postingan video ini dengan video lain.
     * 
     * @param other video lain yang akan dibandingkan
     * @return -1 jika lebih rendah, 0 jika sama, 1 jika lebih tinggi
     */
    @Override
    public int compareEngagement(Engageable other) {
      VideoPost videoLain = (VideoPost) other;

      if(this.totalScore() < videoLain.totalScore()){
        return -1;
      } else if (this.totalScore() == videoLain.totalScore()){
        return 0;
      } else {
        return 1;
      }
        
    }
  
    /**
     * Membagikan video ke target tertentu.
     * Menampilkan pesan "Video by @[author] shared to [target]".
     * Setelah itu, share dari Post tersebut juga akan bertambah satu.
     *
     * @param target tujuan share (user tertentu)
     */
    @Override
    public void shareTo(String target) {
        System.out.println("Video by @" + getAuthor() + " shared to " + target);
        super.share();
    }
  }
  