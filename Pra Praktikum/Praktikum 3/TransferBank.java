public class TransferBank extends Pembayaran {
    public TransferBank(String namaPelanggan, double jumlah) {
        super(namaPelanggan, jumlah);
    }

    public double hitungTotal() {
        return getJumlah() + 4000;
    }
}

/**
 * Alternatif 2 (Pake Protected)
 * public class TransferBank extends Pembayaran {
    public TransferBank(String namaPelanggan, double jumlah) {
        super(namaPelanggan, jumlah);
    }

    public double hitungTotal() {
        return jumlah + 4000;
    }
}
 */