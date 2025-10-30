import java.util.ArrayList;
import java.util.List;

public class Section<T extends Product> {
    private String name;
    private List<T> products;

    /*
     * TODO: Lengkapi implementasi konstruktor Section
     * Semua attribut diinisialisasi melalui konstruktor.
     * Attribut products diinisialisasi sebagai ArrayList kosong.
     */
    public Section(String name) {
        // TODO: Lengkapi implementasi method ini
        this.name = name;
        this.products = new ArrayList<>();
    }

    /*
     * TODO: Lengkapi implementasi method addProduct
     * Method ini akan menambahkan produk ke dalam list products
     */
    public void addProduct(T product) {
        // TODO: Lengkapi implementasi method ini
        products.add(product);
    }
    
    /*
     * TODO: Lengkapi implementasi method removeProduct
     * Method ini akan menghapus produk dari dalam list products
     * Jika produk tidak ditemukan, tampilkan pesan "Product not found"
     */
    public void removeProduct(T product) {
        // TODO: Lengkapi implementasi method ini
        if (!products.remove(product)){
            //Kalau hasil remove() itu false (artinya produk tidak ditemukan), tampilkan pesan
            System.out.println("Product not found");
        }
    }

    /*
     * TODO: Lengkapi implementasi method getProducts
     * Method ini akan mengembalikan list produk yang ada di dalam section
     */
    public List<T> getProducts() {
        // TODO: Lengkapi implementasi method ini
        return products;
    }

    /*
     * TODO: Lengkapi implementasi method getName
     * Method ini akan mengembalikan nama dari section
     */
    public String getName() {
        // TODO: Lengkapi implementasi method ini
        return name;
    }

    /*
     * TODO: Lengkapi implementasi method getProductWithNameAndType
     * Method ini akan mengembalikan produk berdasarkan nama dan tipe produk
     * Jika produk tidak ditemukan, tampilkan pesan "Product not found".
     * Jika produk ditemukan, tampilkan representasi string dari produk tersebut dan kembalikan produk tersebut.
     */
    public T getProductWithNameAndType(String name, Class<? extends T> type) {
        // TODO: Lengkapi implementasi method ini
        for (T product : products){
            if (product.getName().equals(name) && type.isInstance(product)){
                // type di sini adalah objek dari kelas Class<? extends T>
                // ga ada method getType() makanya make instance
                System.out.println(product);
                return product;
            }
        }
        System.out.println("Product not found");
        return null; // karena kalau yg if ga dipenuhi harus tetap return
    }

    /*
     * TODO: Lengkapi implementasi method getTotalValue
     * Method ini akan mengembalikan total nilai dari semua produk yang ada di dalam section
     */
    public double getTotalValue() {
        // TODO: Lengkapi implementasi method ini
        double total = 0;
        for(T product : products){
            total += product.getPrice();
        }
        return total;
    }

    /*
     * TODO: Lengkapi implementasi method findCheapest
     * Method ini akan mencari produk dengan harga terendah dari dalam list
     */
    public static <U extends Product> U findCheapest(List<? extends U> list) {
        // TODO: Lengkapi implementasi method ini
        if (list == null || list.isEmpty()) {
            // list == null, cek list-nya udh/blm diinisialisasi (tidak ada objek List)
            // list.isEmpty() cek list-nya kosong gak
            return null;
            // kalo list kosong/null, langsung return null karena ga ada produk yang bisa dicari
        }
        
        U cheapest = list.get(0);
        // ambil produk pertama dari list sbg patokan awal untuk produk termurah
        for (U product : list) {
            // Untuk setiap product di dalam list..
            // karena method ini static maka dia ga terikat instance lain 
            // jadi gabisa akses product karena products gak static
            if (product.getPrice() < cheapest.getPrice()) {
                // bandingin harga product dengan harga termurah sementara "cheapest" alias index 0
                cheapest = product;
                // kalo lebih murah maka cheapest diganti produk itu
            }
        }
        return cheapest;
        // loop selesai maka kita kembalikan produk tsb

    }

    /*
     * TODO: Lengkapi implementasi method showProducts
     * Method ini akan menampilkan semua produk yang ada di dalam list.
     * Setiap produk ditampilkan dalam baris baru dengan menggunakan representasi string dari produk tersebut.
     */
    public static void showProducts(List<? extends Product> items) {
        // TODO: Lengkapi implementasi method ini
        for (Product product : items){
            // again karena dia static maka dia mandiri jadi dia make List items
            System.out.println(product);
        }
    }
}
