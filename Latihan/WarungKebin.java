import java.lang.System;
import java.util.Scanner;

public class WarungKebin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Baca jumlah pembeli (N)
        // HINT: Perhatikan input setelah N ini
        int N = sc.nextInt();
        sc.nextLine();

        int i = 0;
        while (i < N) {
            // TODO: Baca data pembeli (nama, nomorMeja, saldo)
            // HINT: Perhatikan input setelah data pembeli ini
            String nama = sc.nextLine();
            int nomorMeja = sc.nextInt();
            sc.nextLine();
            double saldo = sc.nextInt();
            sc.nextLine();
            
            // TODO: Baca data order makanan (namaMakanan, jumlah, hargaSatuan)
            // HINT: Perhatikan input setelah data order makanan ini
            String namaMakanan = sc.nextLine();
            int jumlah = sc.nextInt();
            sc.nextLine();
            double hargaSatuan = sc.nextInt();
            sc.nextLine();
            
            // TODO: Buat objek Pembeli dan OrderMakanan
            Pembeli pembeli = new Pembeli(nama, nomorMeja, saldo);
            OrderMakanan order = new OrderMakanan(namaMakanan, jumlah, hargaSatuan);

            // TODO: Cek apakah pembeli bisa membayar sendiri pesanannya
            double total = order.getTotalHarga();
            boolean Bayar;
            if (saldo >= total){
                Bayar = true;
            } else {
                Bayar = false;
            }
            
            // TODO: Jika bisa bayar, kurangi saldo pembeli
            
            // TODO: Cetak laporan pembeli i
            // HINT: Jika pembeli tidak bisa membayar, tidak perlu tampilkan saldo setelah bayar
            // HINT: Perhatikan lagi format output yang diharapkan
            System.out.printf("=== Pembeli %d ===\n", (i + 1));
            System.out.printf("Nama: %s (Meja %d)\n", nama, nomorMeja);
            System.out.printf("Pesanan: %s x %d @ %.1f\n", namaMakanan, jumlah, hargaSatuan);
            System.out.printf("Total: %.1f\n", total);
            if (Bayar) {
                double saldoAkhir = saldo - total;
                System.out.println("Bisa Bayar: Bisa");
                System.out.printf("Saldo setelah bayar: %.1f\n", saldoAkhir);
            } else {
                System.out.println("Bisa Bayar: Gak Bisa");
            }
            System.out.println();
            i++;
            
        }

        sc.close();
    }
}