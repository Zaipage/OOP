public class WorkerThread extends Thread {
    private final RequestQueue queue;
    private final int id;

    /*
     * Konstruktor kelas yang menerima RequestQueue dan id worker
     * inisiasi queue dengan parameter q
     * inisiasi id dengan parameter id
     */
    //Type your code here
    public WorkerThread(RequestQueue queue, int id) {
        this.queue = queue;
        this.id = id;
    }

    /*
     * Implementasikan method run() yang akan terus-menerus mengambil request dari queue
     * menggunakan method dequeue dan memprosesnya.
     * Cetak "Worker-<id> memproses request #<request_id>" setiap kali memproses request.
     * Sleep thread selama 80ms setiap kali memproses request.
     * 
     * Hint: 
     *  - Gunakan isInterrupted() untuk pengecekan interupsi
     *  - Tangani InterruptedException dengan blok try-catch (catch kosong)
     */
    // Type your code here
    public void run() {
        try {
            while (!isInterrupted()) {
                System.out.println("Worker-" + id + " memproses request #" + queue.dequeue());
                Thread.sleep(80);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
