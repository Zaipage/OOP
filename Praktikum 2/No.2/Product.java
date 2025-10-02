class Product {
    // TODO: Deklarasikan atribut: name (String), price (double)
    String name;
    double price;
    
    // TODO: Constructor untuk inisialisasi name dan price
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // TODO: Buat method getName() untuk mendapatkan nama produk
    public String getName() {
        return name;
    }

    // TODO: Buat method getPrice() untuk mendapatkan harga produk
    public double getPrice() {
        return price;
    }

    // TODO: Override method toString() untuk menampilkan informasi produk
    // Format: "- name : price"
    public String toString() {
        String message ="- " + name + " : " + price;
        return message;
    }
}