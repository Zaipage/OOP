class Character implements Spellcaster {
    private String name;
    private int mana;
    private int maxMana;
    
    public Character(String name, int maxMana) {
        this.name = name;
        this.maxMana = maxMana;
        this.mana = maxMana;
    }
    
    // Method untuk merestore mana sejumlah amount
    @Override
    public void restoreMana(int amount) throws InvalidManaAmountException {
        // Todo: Implementasi method restoreMana, throw exception jika amount tidak valid (negatif atau nol)
        // Pastikan mana tidak melebihi maxMana setelah restore, jika melebihi set ke maxMana
        if (amount <= 0){
            throw new InvalidManaAmountException(amount);
        }
        
        mana += amount;
        if (mana > maxMana){
            mana = maxMana;
        }

        System.out.println("Mana restored! Mana sekarang: " + mana);
    }
    
    // Method untuk cast spell dengan cost mana tertentu
    @Override
    public void castSpell(int manaCost) throws InsufficientManaException, InvalidManaAmountException {
        // Todo: Implementasi method castSpell, throw exception jika mana tidak cukup atau manaCost tidak valid (negatif atau nol)
        if (mana < manaCost){
            throw new InsufficientManaException(mana, manaCost);
        }

        if (manaCost <= 0){
            throw new InvalidManaAmountException(manaCost);
        }

        mana -= manaCost;
        System.out.println("Spell berhasil dicast! Mana sekarang: " + mana);
    }
    
    public String getName() {
        return name;
    }

    public int getMana() {
        return mana;
    }
}