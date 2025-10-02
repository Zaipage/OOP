import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan nama:");
        String nama = sc.nextline;

        Mahasiswa mhs = new Mahasiswa(nama, nim);
        Funfact ff = new Funfact(hobi, umur);

        mhs.tampilkandata();
        ff.tampilkandata();

        sc.close();
    }
}

