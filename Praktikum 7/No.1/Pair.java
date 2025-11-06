// TODO:
// Lengkapi parameter generik dari kelas Pair.
// Note: disarankan parameter generik dalam kelas ini tidak perlu menggunakan bounded generic
public final class Pair<F, S> {
    private final F first;
    private final S second;

    public Pair(F first, S second) {
    // TODO:
    // 1. Simpan parameter first dan second
    this.first = first;
    this.second = second;
    }

    public F getFirst() {
        // TODO:
        // 1. Kembalikan nilai elemen pertama dari pair.
        // ...
        return first;
    }

    public S getSecond() {
        // TODO:
        // 1. Kembalikan nilai elemen kedua dari pair.
        // ...
        return second;
    }
}
