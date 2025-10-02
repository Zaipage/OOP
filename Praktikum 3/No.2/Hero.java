public abstract class Hero {
    // TODO: Buat atribut berikut String name,int  level,int  hp,int  attackPower, String role
    protected String name;
    protected int level;
    protected int hp;
    protected int attackPower;
    protected String role;

    // TODO: Buat constructor yang menerima name, hp, attackPower, role
    public Hero(String name, int hp, int attackPower, String role){
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        this.role = role;
        level = 1;
    }

    // Level default = 1

    // TODO: Buat method displayInfo() yang menampilkan info hero
    // Gunakan format "<role> <name> - Level: <level>, HP: <hp>, Attack: <attackPower>"
    // Contoh: "Mage Kagura - Level: 1, HP: 300, Attack: 80"
    public void displayInfo(){
        System.out.println(role + " " + name + " - Level: " + level + ", HP: " + hp + ", Attack: " + attackPower);
    }

    // TODO: Buat method attack() dasar
    // Tampilkan pesan "<name> melakukan serangan dasar dengan damage <attackPower>!"
    // Contoh: "Kagura melakukan serangan dasar dengan damage 80!"
    public void attack(){
        System.out.println(name + " melakukan serangan dasar dengan damage " + attackPower + "!");
    }

    // TODO: Buat method levelUp() yang menaikkan level dan stats dasar
    // Naikkan level, Naikkan hp sebanyak 50, naikkan attackPower sebanyak 10, tampilkan pesan level up
    // Format: "<name> naik ke level <level>!"
    // Contoh: "Kagura naik ke level 2!"
    public void levelUp(){
        level++;
        hp += 50;
        attackPower += 10;
        System.out.println(name + " naik ke level " + level + "!");
    }

    // TODO: Implementasikan method abstract berikut di subclass
    public abstract void specialSkill();

    // TODO: Buat getter dan setter untuk semua atribut
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public int getHp(){
        return hp;
    }

    public void setHp(int hp){
        this.hp = hp;
    }

    public int getAttackPower(){
        return attackPower;
    }

    public void setAttackPower(int attackPower){
        this.attackPower = attackPower;
    }

    public String getRole(){
        return role;
    }

    public void setRole(String role){
        this.role = role;
    }
}