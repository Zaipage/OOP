public final class PairComparator {
    private PairComparator() {
    }

    // TODO:
    // 1. Lengkapi parameter generik method yang merupakan kelas-kelas yang
    // menerapkan interface Comparable
    // 2. Lengkapi parameter generik dari pair yang dibandingkan
    public static <F extends Comparable<F>, S extends Comparable<S>> boolean isGreater(Pair<? extends F, ? extends S> p1, Pair<? extends F, ? extends S> p2) {
        // 'F extends Comparable<F>' agar F cuma bisa dibandingkan sm dirinya sendiri
        // sama kasusnya dengan yg S
        // pake '? extends' karena cuma untuk ngambil data yg mau dibandingkan bukan untuk memasukkan data ke objek
        // TODO:
        // 1. Bandingkan elemen pertama dan kedua antar pair menggunakan compareTo().
        // 2. Kembalikan true hanya jika kedua perbandingan menunjukkan p1 lebih besar dari p2.
        // ...
        int p1Comparison = p1.getFirst().compareTo((F) p2.getFirst());
        int p2Comparison = p1.getSecond().compareTo((S) p2.getSecond());

        return p1Comparison > 0 && p2Comparison > 0;
    }
}
