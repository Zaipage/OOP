public class EWallet extends Pembayaran {
    public EWallet(String namaPelanggan, double jumlah) {
        super(namaPelanggan, jumlah);
    }

    public double hitungTotal() {
        return getJumlah() + (getJumlah() * 0.01);
    }
}


/**
 * Alternatif 2 (Pake Protected)
 * 
 * public class TransferBank extends Pembayaran {
    public TransferBank(String namaPelanggan, double jumlah) {
        super(namaPelanggan, jumlah);
    }

    @Override
    public double hitungTotal() {
        return jumlah + 4000;
    }
}
 * 
 */