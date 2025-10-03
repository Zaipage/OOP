public interface MagicalAttack extends Attack {
    public int getMagicalPower();

    public void setMagicalPower(int power);

    // TODO: Buat default method meditate()
    // Tambahkan 10 ke magicalPower dengan memanggil getMagicalPower() dan setMagicalPower()
    default void meditate(){
        setMagicalPower(getMagicalPower() + 10);
    }
    
    // TODO: Buat default method showMagicalStats()
    // Tampilkan: "Kekuatan Sihir: <magicalPower>"
    default void showMagicalStats(){
        System.out.println("Kekuatan Sihir: " + getMagicalPower());
    }
}