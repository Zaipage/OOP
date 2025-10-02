public class Mahasiswa {
    String nama;
    int nim;

    public Mahasiswa (String nama, int nim){
        this.nama = nama;
        this.nim = nim;

    }

    public void tampilkandata() {
        System.out.println("Nama Mahasiswa:" + nama);
        System.out.println("Nim:" + nim);
    }
}

