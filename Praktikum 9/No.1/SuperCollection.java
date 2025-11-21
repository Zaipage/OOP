import java.util.*;

public class SuperCollection {
    private List<Integer> collection;

    // TODO: Buat constructor yang menerima List<Integer> sebagai parameter
    public SuperCollection(List<Integer> collection){
        // Inisialisasi atribut collection dengan parameter yang diterima
        this.collection = collection;
    } 
    
    // TODO: Buat method partitionByCondition(int threshold)
    public List<List<Integer>> partitionByCondition(int threshold) {
        List<Integer> lessOrEqual = new ArrayList<>(); // buat list untuk element yang <= threshold
        List<Integer> greater = new ArrayList<>(); // Buat list untuk element yang > threshold
        
        // Pisahkan collection menjadi dua grup: element <= threshold dan element > threshold
        // Return List<List<Integer>> dimana:
        // - Index 0 berisi element <= threshold
        // - Index 1 berisi element > threshold
        //
        // HINT:
        // - Perlu membuat struktur data untuk menampung dua kelompok element
        // - Gunakan loop untuk mengiterasi collection dan kondisi untuk memisahkan

        for (Integer num : collection) { // loop setiap element di collection
            if (num <= threshold) { // cek apakah element <= threshold
                lessOrEqual.add(num); // kalo ya, masukkan ke grup lessOrEqual
            } else {
                greater.add(num); // kalo gak, masukkan ke grup greater
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(lessOrEqual); // tambahkan grup lessOrEqual di index 0
        result.add(greater); // tambahkan grup greater di index 1
        
        return result;  // Return hasil partisinya
    }
    
    // TODO: Buat method findTopN(int n)
    public List<Integer> findTopN(int n) {
        List<Integer> sorted = new ArrayList<>(collection); // buat copy dari collection biar gak ganti yang asli
        Collections.sort(sorted, Collections.reverseOrder()); // urutin list dalam urutan desc
        
        if (n >= sorted.size()) { // kalau n lebih besar dari ukuran collection, kembaliin semua elemen
            return sorted;
        }
        
        // return list yang berisi n elemen pertama (yang terbesar)
        return sorted.subList(0, n);
    }
    // Return List<Integer> berisi n element terbesar dalam urutan descending
    // Jika n lebih besar dari ukuran collection, return semua element yang ada
    // Pastikan hasilnya terurut dari terbesar ke terkecil
    //
    // HINT:
    // - Collection asli tidak boleh dimodifikasi
    // - Pertimbangkan cara mengurutkan List dalam urutan terbalik
    // - Collections class memiliki method utility yang berguna

    // TODO: Buat method runningSum()
    public List<Integer> runningSum() {
        List<Integer> result = new ArrayList<>(); // buat list untuk nyimpan hasil running sum
        int sum = 0; // variabel untuk menyimpan akumulasi su
        
        for (Integer num : collection) { // loop setiap element dalam collection
            sum += num; // tambahkan elemen saat ini ke akumulasi sum
            result.add(sum); // tambahin sum saat ini ke result
        }
        
        return result; // return list cumulative sum
    }
    // Return List<Integer> berisi cumulative sum
    // Element ke-i berisi jumlah dari element index 0 sampai i
    // Contoh: [1, 2, 3, 4] -> [1, 3, 6, 10]
    //
    // HINT:
    // - Perlu menyimpan state (akumulasi) saat iterasi
    // - Setiap element dalam result adalah hasil penjumlahan sampai index tersebut

    // TODO: Buat method findPairsWithSum(int targetSum)
    public List<String> findPairsWithSum(int targetSum) {
        Set<String> pairs = new TreeSet<>();         // treeSet untuk menyimpan pasangan unik dan otomatis terurut
        
        for (int i = 0; i < collection.size(); i++) {  // loop untuk element pertama (i)
            for (int j = i + 1; j < collection.size(); j++) { // loop elemen kedua (j), mulai dari i+1 biar gak duplikat
                int a = collection.get(i);
                int b = collection.get(j);
                // ambil nilai element i dan j
                
                if (a + b == targetSum) {  // cek apakah jumlah a + b = targetSum
                    int min = Math.min(a, b);
                    int max = Math.max(a, b);
                    // nilai minimum dan maksimum untuk menghindari duplikat
                    String pair = min + "+" + max + "=" + targetSum; // Buat string dengan format "min+max=sum"
                    pairs.add(pair); // Tambahkan ke set (set otomatis menghindari duplikat)
                }
            }
        }
        
        return new ArrayList<>(pairs); // ubah TreeSet ke ArrayList dan return
    }
    // Cari semua pasangan element yang jika dijumlahkan = targetSum
    // Return List<String> dengan format "a+b=sum"
    // Hindari duplikat pasangan (a,b) dan (b,a) dianggap sama
    // Urutkan hasil berdasarkan nilai a
    //
    // HINT:
    // - Perlu mengecek setiap kemungkinan pasangan element
    // - Bagaimana cara menghindari duplikat seperti "3+5" dan "5+3"?
    // - Pertimbangkan struktur data yang otomatis mengurutkan dan menghindari duplikat
    // - TreeSet adalah Set yang sorted
    // - Gunakan .addAll untuk menambahkan seluruh elemen dari set ke List hasil kalian

    // TODO: Buat method getMostFrequentElements(int n)
    // Return List<Integer> berisi n element yang paling sering muncul
    // Jika ada element dengan frekuensi sama, pilih yang nilainya lebih besar
    public List<Integer> getMostFrequentElements(int n) {
        Map<Integer, Integer> frequencyMap = new HashMap<>(); // map untuk menghitung frekuensi setiap element
        
        for (Integer num : collection) { // loop untuk menghitung frekuensi setiap element
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            // getOrDefault: ambil frekuensi saat ini (atau 0 jika belum ada), lalu tambah 1
        }
        
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(frequencyMap.entrySet());
         // list untuk menyimpan semua element unik beserta frekuensinya
        
        
        Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {
            // sort berdasarkan frekuensi (descending), klo sama sort berdasarkan nilai (descending)
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                int freqCompare = e2.getValue() - e1.getValue(); // bandingkan frekuensi (e2 - e1 untuk descending)
                if (freqCompare == 0) { // kalo frekuensi sama, bandingkan nilai (e2 - e1 untuk descending)
                    return e2.getKey() - e1.getKey();
                }
                return freqCompare;
            }
        });
        
        List<Integer> result = new ArrayList<>();  // list untuk menyimpan hasil akhir
        // Loop untuk mengambil n element teratas (atau semua klo kurang dari n)
        for (int i = 0; i < Math.min(n, entries.size()); i++) {
            // loop untuk ambil n element teratas (atau semua klo kurang dari n)
            result.add(entries.get(i).getKey()); // tambahkan key (nilai element) ke result
        }
        
        return result;
    }
    // HINT:
    // - Langkah 1: Identifikasi semua element unik
    // - Langkah 2: Hitung berapa kali setiap element muncul
    // - Langkah 3: Urutkan berdasarkan frekuensi (tinggi ke rendah), lalu nilai (tinggi ke rendah)
    // - Pertimbangkan membuat helper class untuk menyimpan pasangan (value, frequency)
    // - Untuk sorting custom, gunakan Comparator

    // TODO: Buat method getCollection()
    // Return collection yang sedang digunakan (type: List<Integer>)
    public List<Integer> getCollection() {
        return collection;
    }

    // TODO: Buat method setCollection(List<Integer> newCollection)
    // Set atribut collection dengan newCollection
    public void setCollection(List<Integer> newCollection) {
        this.collection = newCollection;
    }
}