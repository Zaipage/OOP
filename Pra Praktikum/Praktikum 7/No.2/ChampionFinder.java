public final class ChampionFinder {
    // TODO:
    // Tambahkan konstruktor private tanpa parameter di sini agar kelas
    // tidak dapat diinstansiasi.
    private ChampionFinder(){

    }

    public static <T extends Comparable<T>> T findChampion(T a, T b) {
        // TODO:
        // 1. Lengkapi parameter generik yang menerapkan interface Comparable.
        // 2. Bandingkan kedua kandidat dan kembalikan kandidat dengan nilai terbesar.
        // HINT: gunakan fungsi compareTo
        return a.compareTo(b) >= 0 ? a : b;
        // 'a.compareTo(b)' membandingkan nilai a dan b
        // '>= 0' artinya jika a sama besar atau lebih besar daripada b maka kembalikan a
        // karna dalam tenary tu dia ngembaliin nilai true or false alias:
        // == -> 0
        // lebih besar -> 1
        // lebih kecil -> -1
    }

    public static <T extends Comparable<T>> T findChampion(T a, T b, T c) {
        // TODO:
        // 1. Gunakan parameter generik yang sama seperti versi dua kandidat.
        // 2. Manfaatkan findChampion(a, b) untuk mendapatkan juara sementara.
        // 3. Bandingkan juara sementara dengan kandidat ketiga dan kembalikan hasil akhirnya.
        T tempChampion = findChampion(a, b);
        // ambil champion sementara dari T dan simpan dalam tempChampion alias juara sementara
        return findChampion(tempChampion, c); 
        // bandingkan juara sementara dengan c untuk menentukan juara akhir
    }
}
