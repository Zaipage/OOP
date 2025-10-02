public abstract class Pembayaran {
    private String namaPelanggan;
    private double jumlah;

    public Pembayaran(String namaPelanggan, double jumlah) {
        this.namaPelanggan = namaPelanggan;
        this.jumlah = jumlah;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public double getJumlah() {
        return jumlah;
    }

    public abstract double hitungTotal(); 
}

/**
 * Alternatif 2 (Pake Protected)
 *
 * public abstract class Pembayaran {
    protected String namaPelanggan;
    protected double jumlah;

    public Pembayaran(String namaPelanggan, double jumlah) {
        this.namaPelanggan = namaPelanggan;
        this.jumlah = jumlah;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public abstract double hitungTotal();
}
 */