public class Warrior implements PhysicalAttack, StrengthComparable {
    // TODO: Buat atribut private String name, int physicalPower
    private String name;
    private int physicalPower;
    
    // TODO: Buat constructor yang menerima name dan physicalPower
    // Set kedua atribut dengan parameter yang diterima
    public Warrior (String name, int physicalPower){
        this.name = name;
        this.physicalPower = physicalPower;
    }
    
    // TODO: Override method performAttack()
    // Tampilkan: "<name> mengayunkan pedang dengan kuat! memberikan <physicalPower> damage fisik!"
    @Override
    public void performAttack(){
        System.out.println(name + " mengayunkan pedang dengan kuat! memberikan " + physicalPower + " damage fisik!");
    }
    
    // TODO: Override method getPhysicalPower()
    // Buat getter untuk physicalPower
    @Override
    public int getPhysicalPower(){
        return this.physicalPower;
    }
    
    // TODO: Override method setPhysicalPower(int power)
    // Buat setter untuk physicalPower
    @Override
    public void setPhysicalPower(int power){
        this.physicalPower = power;
    }
    
    // TODO: Override method compareStrength(StrengthComparable other)
    // Jika other adalah instance dari Warrior:
    //   - Bandingkan physicalPower:
    //     - Jika this.physicalPower < other.physicalPower, return -1
    //     - Jika this.physicalPower == other.physicalPower, return 0
    //     - Jika this.physicalPower > other.physicalPower, return 1
    // Jika other bukan instance dari Warrior, return -2
    @Override
    public int compareStrength(StrengthComparable other){
        if (other instanceof Warrior){
            Warrior warrior = (Warrior) other;
            if (this.physicalPower < warrior.physicalPower){
                return -1;
            } else if (this.physicalPower == warrior.physicalPower){
                return 0;
            } else {
                return 1;
            }
        }
        return -2;
    }
    
}