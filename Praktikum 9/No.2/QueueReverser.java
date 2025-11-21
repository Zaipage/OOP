import java.util.Queue;
import java.util.Stack;

/*
 * Kelas QueueReverser
 * Deskripsi:
 * Kelas ini berisi tiga method statis untuk membalik (reverse) elemen-elemen 
 * di dalam sebuah Queue menggunakan struktur data Stack dari Java Collections.
 * 
 * Method yang harus diimplementasikan:
 * 1. reverseAll()            -> membalik seluruh elemen queue
 * 2. reverseFirstKElements() -> membalik K elemen pertama dari queue
 * 3. reverseLastKElements()  -> membalik K elemen terakhir dari queue
 * 
 * HINT: Berikut penjelasan method yang mungkin bisa kamu gunakan untuk membantu implementasi:
 * - queue.offer()     -> menambahkan elemen ke belakang queue (seperti enqueue)
 * - queue.poll()      -> menghapus dan mengembalikan elemen depan queue (seperti dequeue)
 * - queue.isEmpty()   -> mengecek apakah queue kosong
 * - queue.size()      -> mengecek ukuran queue
 * - queue.peek()      -> mengembalikan elemen depan queue tanpa menghapusnya
 * - queue.clear()     -> menghapus semua elemen dari queue
 * 
 * - stack.push()      -> menambahkan elemen ke atas stack
 * - stack.pop()       -> menghapus dan mengembalikan elemen atas stack
 * - stack.isEmpty()   -> mengecek apakah stack kosong
 * - stack.size()      -> mengecek ukuran stack
 * - stack.peek()      -> mengembalikan elemen atas stack tanpa menghapusnya
 * - stack.clear()     -> menghapus semua elemen dari stack
 */
public class QueueReverser {
    /*
     * Method reverseAll()
     * -------------------
     * Fungsi: Membalik seluruh isi Queue menggunakan Stack.
     * 
     * Contoh:
     * Queue awal  : [10, 20, 30, 40, 50]
     * Queue akhir : [50, 40, 30, 20, 10]
     */
    public static <T> void reverseAll(Queue<T> queue) {
        // TODO: Lengkapi code di sini
        Stack<T> stack = new Stack<>(); // bikin stack baru buat nampung elemen
        
        while (!queue.isEmpty()) { // selama queue masih ada isinya
            stack.push(queue.poll()); // ambil dari depan queue, masukin ke stack
        }
        
        while (!stack.isEmpty()) { // selama stack masih ada isinya
            queue.offer(stack.pop()); // ambil dari atas stack, masukin ke belakang queue
        }
    }

    /*
     * Method reverseFirstKElements()
     * ------------------------------
     * Fungsi: Membalik K elemen pertama dari Queue menggunakan bantuan Stack.
     * 
     * Contoh:
     * Queue awal  : [10, 20, 30, 40, 50], k = 2
     * Queue akhir : [20, 10, 30, 40, 50] (2 elemen pertama dibalik)
     * 
     * NOTE: Jika k kurang dari atau sama dengan 0 atau k lebih besar dari ukuran queue atau queue kosong, maka tidak ada yang dibalik.
     */
    public static <T> void reverseFirstKElements(Queue<T> queue, int k) {
        // TODO: Lengkapi code di sini
        if (k <= 0 || k > queue.size() || queue.isEmpty()) { // validasi: cek k valid atau ngga
            return; // kalo ngga valid, langsung keluar aja
        }
        
        Stack<T> stack = new Stack<>(); // bikin stack buat nampung k elemen pertama
        
        for (int i = 0; i < k; i++) { // loop sebanyak k kali
            stack.push(queue.poll()); // ambil dari depan queue, masukin ke stack
        }
        
        while (!stack.isEmpty()) { // selama stack masih ada isinya
            queue.offer(stack.pop()); // ambil dari stack, masukin ke belakang queue
        }
        
        int remaining = queue.size() - k; // hitung sisa elemen yang belum dibalik
        for (int i = 0; i < remaining; i++) { // loop sebanyak sisa elemen
            queue.offer(queue.poll()); // pindahin elemen dari depan ke belakang biar urutannya bener
        }
    }

    /*
     * Method reverseLastKElements()
     * -----------------------------
     * Fungsi: Membalik K elemen terakhir dari Queue menggunakan bantuan Stack.
     * 
     * Contoh:
     * Queue awal  : [10, 20, 30, 40, 50], k = 2
     * Queue akhir : [10, 20, 30, 50, 40] (2 elemen terakhir dibalik)
     * 
     * NOTE: Jika k kurang dari atau sama dengan 0 atau k lebih besar dari ukuran queue atau queue kosong, maka tidak ada yang dibalik.
     */
    public static <T> void reverseLastKElements(Queue<T> queue, int k) {
        // TODO: Lengkapi code di sini
        if (k <= 0 || k > queue.size() || queue.isEmpty()) { // validasi: cek k valid atau ngga
            return; // kalo ngga valid, langsung keluar aja
        }
        
        Stack<T> stack = new Stack<>(); // bikin stack buat nampung k elemen terakhir
        int size = queue.size(); // simpan ukuran queue
        int frontElements = size - k; // hitung berapa elemen yang di depan (yang ga dibalik)
        
        for (int i = 0; i < frontElements; i++) { // loop untuk pindahin elemen depan
            queue.offer(queue.poll()); // ambil dari depan, taro ke belakang (biar k elemen terakhir jadi di depan)
        }
        
        for (int i = 0; i < k; i++) { // loop sebanyak k kali
            stack.push(queue.poll()); // ambil k elemen (yang tadinya di belakang, sekarang di depan), masukin ke stack
        }
        
        while (!stack.isEmpty()) { // selama stack masih ada isinya
            queue.offer(stack.pop()); // ambil dari stack, masukin ke belakang queue (ini yang kebalik)
        }
    }
}