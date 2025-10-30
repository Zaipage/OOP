import java.util.List;

// Hint: Pelajari PECS Rule
// kalau menghasilkan objek -> pakai extends
// kalau menerima objek -> pakai super
public class ZooManager {
    
    // TODO: Lengkapi tipe wildcard pada parameter
    public static void printAllAnimals(List<? extends Animal> animals) {
        // make extends karena dia cuma mau print aja bukan nerima objek, alias ngambil doang
        // TODO: Loop semua animal dalam list dan tampilkan:
        // "- <animal.getInfo()> says: <animal.makeSound()>"
        for (Animal animal : animals){
            System.out.println("- " + animal.getInfo() + " says: " + animal.makeSound());
        }
    }
    
    // TODO: Lengkapi tipe wildcard pada parameter
    public static void addMammals(List<? super Mammal> list, Mammal mammal) {
        // TODO: Tambahkan mammal ke dalam list
        // TODO: Tampilkan: "<mammal.getName()> ditambahkan ke daftar mamalia"
        list.add(mammal);
        System.out.println(mammal.getName() + " ditambahkan ke daftar mamalia");
    }
    
    // TODO: Lengkapi tipe wildcard pada parameter
    public static int countAnimals(List<? extends Animal> list) {
        // TODO: Return jumlah elemen dalam list (gunakan list.size())
        return list.size();
    }
    
    // TODO: Lengkapi tipe wildcard pada kedua parameter Enclosure
    public static void transferAnimal(Enclosure<? extends Animal> source, Enclosure<? super Animal> destination) {
        // TODO: Ambil animal dari source menggunakan getAnimal()
        Animal animal = source.getAnimal();
        // TODO: Set animal di destination menggunakan setAnimal()
        destination.setAnimal(animal);
        // TODO: Tampilkan: "<animal.getName()> dipindahkan dari kandang <source.getEnclosureId()> ke <destination.getEnclosureId()>"
        System.out.println(animal.getName() + " dipindahkan dari kandang " + source.getEnclosureId() + " ke " + destination.getEnclosureId());
        
    }
    
    // TODO: Lengkapi tipe wildcard pada parameter
    public static void showGenericInfo(Enclosure<? extends Animal> enclosure) {
        // TODO: Panggil enclosure.showEnclosureInfo()
        enclosure.showEnclosureInfo();
    }
}