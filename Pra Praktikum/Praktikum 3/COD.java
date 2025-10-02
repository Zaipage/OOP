public class COD extends Pembayaran {
    public COD(String namaPelanggan, double jumlah) {
        super(namaPelanggan, jumlah);
    }

    public double hitungTotal() {
        return getJumlah() + 5000;
    }
}

/**
 * Alternatif 2 (Pake Protected)
 * public class COD extends Pembayaran {
    public COD(String namaPelanggan, double jumlah) {
        super(namaPelanggan, jumlah);
    }

    public double hitungTotal() {
        return jumlah + 5000;
    }
}
 */