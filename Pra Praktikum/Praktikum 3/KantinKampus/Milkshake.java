/**
 * Milkshake.java
 * 
 */
public class Milkshake extends MenuItem {
    public enum Ukuran { SMALL, MEDIUM, LARGE }

    private String jenis;
    private boolean iceCreamTopping;
    private Ukuran ukuran;

    /**
     * Constructor Milkshake.
     *
     * For your exploration:
     * - Untuk enum, jangan lupa gunakan EnumName.VALUE
     * - Pastikan input jenis milkshake bersih dengan menggunakan .trim()
     * - Pastikan nama jenis milkshake tidak null/kosong, jika null/kosong, set jenis menjadi "Original"
     *
     * @param volumeMl        volume minuman dalam ml
     * @param jenis           jenis milkshake (contoh: "Strawberry")
     * @param iceCreamTopping true jika ada topping es krim tambahan
     * @param ukuran          ukuran milkshake (SMALL, MEDIUM, LARGE)
     */
    public Milkshake(int volumeMl, String jenis, boolean iceCreamTopping, Ukuran ukuran) {
        // TODO: panggil constructor superclass (super) dengan namaMenu="Milkshake",
        //       quantity=volumeMl, unit=Unit.ML, kategori=Kategori.MINUMAN
        // TODO: simpan parameter jenis, iceCreamTopping, ukuran ke atribut
        super("Milkshake", volumeMl, Unit.ML, Kategori.MINUMAN);
        this.iceCreamTopping = iceCreamTopping;
        if (jenis == null || jenis.trim().isEmpty()) {
            this.jenis = "Original";
        } else {
            this.jenis = jenis.trim();
        }
        this.ukuran = ukuran;
    }

    /**
     * Getter untuk jenis milkshake.
     *
     * @return jenis milkshake
     */
    public String getJenis() { 
        return jenis;
    }

    /**
     * Setter untuk jenis milkshake.
     * 
     * - Pastikan input jenis milkshake bersih dengan menggunakan .trim()
     * - Pastikan nama jenis milkshake tidak null/kosong, jika null/kosong, set jenis menjadi "Original"
     *
     * @param jenis jenis milkshake baru
     */
    public void setJenis(String jenis) {
        if (jenis == null || jenis.trim().isEmpty()) {
            this.jenis = "Original";
        } else {
            this.jenis = jenis.trim();
        }
    }

    /**
     * Getter untuk iceCreamTopping.
     *
     * @return iceCreamTopping
     */
    public boolean hasIceCreamTopping() { 
        return iceCreamTopping;
    }

    /**
     * Setter untuk status topping es krim.
     * 
     * @param iceCreamTopping true jika ada topping
     */
    public void setIceCreamTopping(boolean iceCreamTopping) {
        this.iceCreamTopping = iceCreamTopping;
    }

    /**
     * Getter untuk ukuran milkshake.
     *
     * @return ukuran milkshake
     */
    public Ukuran getUkuran() { 
        return ukuran;
    }
    
    /**
     * Setter untuk ukuran milkshake.
     *
     * @param ukuran ukuran milkshake baru
     */
    public void setUkuran(Ukuran ukuran) {
        this.ukuran = ukuran;
    }

    /**
     * Override basePrice() dari MenuItem.
     * Aturan harga dasar:
     * - SMALL  = 10000
     * - MEDIUM = 13000
     * - LARGE  = 15000
     * Tambahan:
     * - Jika iceCreamTopping = true, tambahkan 5000
     *
     * @return harga dasar milkshake
     */
    @Override
    public int basePrice() {
        int harga = 0;
        switch (this.ukuran) {
            case SMALL :
                harga = 10000;
                break;
            case MEDIUM :
                harga  = 13000;
                break;
            case LARGE : 
                harga = 15000;
                break;
        }

        if (this.iceCreamTopping){
            harga += 5000;
        }
        return harga;
    }

    /**
     * Override label() dari MenuItem.
     * Format contoh: 
     * - "Milkshake Strawberry [MEDIUM] 250ml" (jika iceCreamTopping = false)
     * - "Milkshake Strawberry Float [MEDIUM] 250ml" (jika iceCreamTopping = true)
     *
     * @return label string untuk milkshake
     */
    @Override
    public String label() {
        if (this.iceCreamTopping){
            return super.getNamaMenu() + " " + this.jenis + " Float [" + this.ukuran.toString() + "] " + super.getQuantity() + ((super.getUnit() == Unit.ML) ? "ml" : "g");
        }
        else{
            return super.getNamaMenu() + " " + this.jenis + " [" + this.ukuran.toString() + "] " + super.getQuantity() + ((super.getUnit() == Unit.ML) ? "ml" : "g");
        }
    }
}