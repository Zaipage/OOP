// TODO:
// Lengkapi parameter generik dari kelas ini. 
// Perhatikan bahwa objek ini hanya bisa dibandingkan dengan objek Temperature lain
public final class Temperature implements Comparable<Temperature> {
    private final double celcius;

    public Temperature(double meters) {
        this.celcius = meters;
    }

    // TODO:
    // 1. Implementasikan fungsi compareTo untuk membandingkan nilai temperatur objek ini dengan objek lain.
    //    Gunakan Double.compare(<Temperature objek ini> , <Temperature objek lain>) untuk mendapatkan hasil perbandingan.
    public int compareTo(Temperature other){
        return Double.compare(this.celcius, other.celcius);
    }

    @Override
    public String toString() {
        return celcius + " c";
    }
}
