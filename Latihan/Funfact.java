public class Funfact {
    String hobi;
    int umur;

    public Funfact (String hobi, int umur){
        this.hobi = hobi;
        this.umur = umur;
    }
    
    public void tampilkandata() {
        System.out.println("Hobi: " + hobi);
        System.out.println("Umur: " + umur);
    }
}
