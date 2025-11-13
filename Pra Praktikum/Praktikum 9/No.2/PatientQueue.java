import java.util.LinkedList;
import java.util.Queue;

public class PatientQueue {
    private Queue<Patient> queue = new LinkedList<>();

    /* TODO : Lengkapi method addPatient(Patient p)
       Menambahkan pasien ke dalam antrian.
       Menggunakan Queue karena sistem pelayanan bersifat FIFO (First In First Out).
       - Parameter: p = pasien baru
       Tidak ada nilai kembalian (void). */
    public void addPatient(Patient p) {
        // Type your code
        queue.add(p);
    }

    /* TODO : Lengkapi method serveNext()
       Mengeluarkan pasien pertama dari antrian.
       - Jika antrian kosong, return null.
       - Jika tidak kosong, hapus dan kembalikan elemen pertama.
       Alasan menggunakan Queue: efisien untuk operasi penghapusan elemen pertama (O(1)).
       Return: Patient yang dilayani. */
    public Patient serveNext() {
        // Type your code
        // queue.poll()
        if(queue.isEmpty()){
            return null;
        }

        return queue.remove();
    }

    /* TODO : Lengkapi method peekNext()
       Melihat pasien terdepan TANPA menghapus dari antrian.
       - Jika kosong, return null.
       Return: Patient paling depan.
       Alasan: memeriksa siapa yang akan dilayani berikutnya tanpa mengubah antrian. */
    public Patient peekNext() {
        // Type your code
        if(queue.isEmpty()){
            return null;
        }
        return queue.peek();
    }

    /* TODO : Lengkapi method displayQueue()
       Menampilkan seluruh pasien dalam antrian.
       Format (Jika kosong):
       Current Queue:
       - (empty)
       Format (Jika tidak kosong):
       Current Queue:
       - <nama> (<umur>) [Critical]
       Gunakan perulangan for-each.
       Tidak ada nilai kembalian. */
    public void displayQueue() {
        // Type your code
        System.out.println("Current Queue:");
        if(isEmpty()){
            System.out.println("- (empty)");
            return;
        }

        for(Patient p : queue){
            System.out.println("- " + p.toString());
        }
    }

    /* TODO : Lengkapi method isEmpty()
       Mengecek apakah antrian kosong.
       Return true jika kosong, false jika tidak. */
    public boolean isEmpty() {
        // Type your code
        return queue.isEmpty();
    }
}
