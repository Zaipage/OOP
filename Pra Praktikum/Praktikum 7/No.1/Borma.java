import java.util.ArrayList;
import java.util.List;

public class Borma {
    static List<Section<Product>> sections = new ArrayList<>();

    /*
     * TODO: Lengkapi implementasi static-method addSection
     * Method ini akan menambahkan Section baru ke dalam list sections
     * Lakukan validasi agar sections memiliki section dengan nama yang unik
     * Jika Section dengan nama yang sama sudah ada, 
     * tampilkan pesan "Section already exists" dan tidak menambahkan Section baru
     */
    public static void addSection(String sectionName) {
        // TODO: Lengkapi implementasi method ini
        for (Section<Product> section : sections){ // mencari semua section di dalam list sections
            //"Section<Product>" adalah generic class instantiation, parameter tipe T = Product
            if (section.getName().equals(sectionName)){ // cari namanya unik atau tidak
                System.out.println("Section already exists"); // kalau namanya sama dengan yg di section name print ini
                return;
            }
        }
        sections.add(new Section<>(sectionName)); // kalau belum ada nama kaya gitu di sectionName baru di add ke section
        // bisa "sections.add(new Section<Product>(sectionName)" sama aja, tapi karena udh di inisialisasi di atas jdi aman tanpa <Product>
        // <> kosong cuma bisa dipake disisi kanan
    }

    /*
     * TODO: Lengkapi implementasi static-method removeSection
     * Method ini akan menghapus Section dari list sections berdasarkan nama section
     * Jika Section dengan nama tersebut tidak ditemukan,
     * tampilkan pesan "Section not found"
     */
    public static void removeSection(String sectionName) {
        // TODO: Lengkapi implementasi method ini
        for (int i = 0; i < sections.size(); i++){ // pakai for i karena utk ngehapus hrus tau posisi
            if (sections.get(i).getName().equals(sectionName)){ // pakai equals karena dia di remove kalau dia ada di sectionName
                sections.remove(i); // mau ngapus berdasar posisi makanya pakai (i)
                return;
            }
        }
        System.out.println("Section not found");
    }

    /*
     * TODO: Lengkapi implementasi static-method getSections
     * Method ini akan mengembalikan list sections
     */
    public static List<Section<Product>> getSections() {
        // TODO: Lengkapi implementasi method ini
        return sections;
    }

    /*
     * TODO: Lengkapi implementasi static-method addProductToSection
     * Method ini akan menambahkan Product ke dalam Section berdasarkan nama section
     * Jika Section dengan nama tersebut tidak ditemukan,
     * tampilkan pesan "Section not found"
     */
    public static void addProductToSection(Product product, String sectionName) {
        // TODO: Lengkapi implementasi method ini
        for (Section<Product> section : sections){
            if (section.getName().equals(sectionName)){
                section.addProduct(product); // addProduct itu method Section bukan arraylist
                // makany apakai 'section.' bukan 'sections.' karena 'section' itu objek buatan Section sementara sections adalah arraylist
                return;
            }
        }
        System.out.println("Section not found");
    }

    /*
     * TODO: Lengkapi implementasi static-method removeProductFromSection
     * Method ini akan menghapus Product dari Section berdasarkan nama section
     * Jika Section dengan nama tersebut tidak ditemukan,
     * tampilkan pesan "Section not found"
     */
    public static void removeProductFromSection(Product product, String sectionName) {
        // TODO: Lengkapi implementasi method ini
        for (Section<Product> section : sections){ // gak pakai i karena dia mau ngapus dari section yang merupakan objek bukan arraylist
            if (section.getName().equals(sectionName)){
                section.removeProduct(product); // removeProduct method Section
                return;
            }
        }
        System.out.println("Section not found");
    }

    /*
     * TODO: Lengkapi implementasi static-method showTotalValue
     * Method ini akan menampilkan total nilai dari semua Section
     * Format tampilan: "Total value of all sections: Rp<total_value>"
     */
    public static void showTotalValue() {
        // TODO: Lengkapi implementasi method ini
        double totalValue = 0; // inisialisasi totalValue dulu biar bisa dipake
        for (int i = 0; i < sections.size(); i++){
            totalValue += sections.get(i).getTotalValue(); // getTotalValue method dari class Section
        }
        System.out.println("Total value of all sections: Rp" + totalValue);
    }
}
