import java.util.ArrayList;
import java.util.Random;

public class CardGame {
    private String gameName;
    private int maxPlayers;

    public CardGame(String gameName, int maxPlayers) {
        this.gameName = gameName;
        this.maxPlayers = maxPlayers;
    }

    public String getGameName() {
        return gameName;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    // TODO: Buat static nested class bernama Card
    // Pertanyaan: Mengapa Card menggunakan static nested class?
    // Hint: Apakah sebuah kartu perlu bergantung pada instance game tertentu?
    //
    // Atribut yang diperlukan: suit, rank, value (tipe data sesuaikan sendiri)
    // Method yang diperlukan:
    // - Constructor untuk inisialisasi
    // - Getter untuk setiap atribut
    // - displayCard() untuk menampilkan informasi kartu dalam format:
    //   "[rank] of [suit] (Value: [value])"
    public static class Card {
        private String suit;
        private String rank;
        private int value;

        public Card(String suit, String rank, int value){
            this.suit = suit;
            this.rank = rank;
            this.value = value;
        }

        public String getSuit(){
            return suit;
        }

        public String getRank(){
            return rank;
        }

        public int getValue(){
            return value;
        }

        public void displayCard(){
            System.out.println(rank + " of " + suit + " (Value: " + value + ")");
        }
        
    }

    // TODO: Buat inner class bernama Deck
    // Pertanyaan: Mengapa Deck menggunakan inner class (bukan static)?
    // Hint: Perhatikan apakah Deck perlu mengakses atribut gameName dari outer class
    //
    // Atribut yang diperlukan:
    // - Array untuk menyimpan Card
    // - Variabel untuk melacak jumlah kartu yang ada di deck
    //
    // Method yang diperlukan:
    // - Constructor(int size): inisialisasi deck dengan kapasitas tertentu
    // - addCard(Card card): menambahkan kartu ke deck
    //   * Tampilkan: "Kartu ditambahkan ke deck [gameName]"
    //   * Handle kasus deck penuh dengan menampilkan pesan "Deck penuh!"
    // - drawCard(): mengambil kartu terakhir dari deck dan mengembalikannya
    //   * Handle kasus deck kosong dengan menampilkan pesan "Deck kosong!" dan return null
    //   * Pastikan kartu yang diambil dihapus dari deck
    // - shuffle(long seed): mengacak posisi kartu dalam deck
    //   * Parameter: seed untuk Random (agar hasil deterministik)
    //   * Tampilkan: "Deck [gameName] dikocok"
    //   * Implementasi: gunakan java.util.Random dengan seed parameter
    //   * Algoritma: Fisher-Yates shuffle
    //     Hint: Loop dari belakang (i = currentSize-1 sampai 1 (inklusif)),
    //           pilih random index j dari 0 sampai i (gunakan rand.nextInt(i+1)),
    //           swap cards[i] dengan cards[j]  
    // - displayDeck(): menampilkan semua kartu di deck
    //   * Format: "Deck [gameName] berisi [jumlah] kartu:"
    public class Deck {
        private Card[] cards;
        private int countCards;

        public Deck(int size){
            this.cards = new Card[size];
            this.countCards = 0;
        }

        public void addCard (Card card){
            if(countCards < cards.length){
                cards[countCards++] = card;
                System.out.println("Kartu ditambahkan ke deck " + gameName);
            } else {
                System.out.println("Deck penuh!");
            }
        }

        public Card drawCard(){
            if (countCards == 0) {
                System.out.println("Deck kosong!");
                return null;
            }

            Card drawnCard = cards[countCards - 1];
            cards[countCards - 1] = null;
            countCards--;
            return drawnCard;
        }

        public void shuffle(long seed){
            System.out.println("Deck " + gameName + " dikocok");
            Random rand = new Random(seed);
            for (int i = countCards - 1; i >= 1; i--){
                int j = rand.nextInt(i+1);
                Card tmp = cards[i];
                cards[i] = cards[j];
                cards[j] = tmp;
            }
        }
        
        public void displayDeck(){
            System.out.println("Deck " + gameName + " berisi " + countCards + " kartu:");
            for(int i = 0; i < countCards; i++){
                cards[i].displayCard();
            }
        }
    }

    // TODO: Buat inner class bernama Player
    // Atribut yang diperlukan:
    // - name
    // - Array untuk menyimpan kartu di tangan (hand)
    // - score
    // - Variabel untuk melacak berapa banyak kartu yang dimiliki
    //   (Hint: Pikirkan mengapa kita perlu variabel terpisah untuk tracking jumlah kartu)
    //
    // Method yang diperlukan:
    // - Constructor(String name, int handSize): inisialisasi player
    // - Getter untuk name, hand, dan score
    // - addCardToHand(Card card): menambahkan kartu ke hand
    //   * Tampilkan: "[name] menerima kartu di game [gameName]"
    //   * Handle kasus hand penuh dengan menampilkan pesan "Tangan [name] sudah penuh!"
    // - playCard(int index): memainkan kartu pada index tertentu
    //   * Tampilkan kartu yang dimainkan menggunakan displayCard()
    //   * Hapus kartu dari hand (Hint: pikirkan cara reorganisasi array, array harus rata kiri)
    //   * Return kartu yang dimainkan
    //   * Handle kasus index tidak valid dengan menampilkan pesan "Tidak ada kartu di index tersebut"
    // - displayHand(): menampilkan semua kartu di tangan
    //   * Format: "[name] memiliki [jumlah] kartu:" lalu list kartu menggunakan displayCard()
    // - calculateScore(): menghitung total nilai kartu di tangan
    //   * Tampilkan: "[name] memiliki total score: [score]"
    public class Player {
        private String name;
        private Card[] hand;
        private int score;
        private int countCards;
        
        public Player(String name, int handSize){
            this.name = name;
            this.hand = new Card[handSize];
            this.score = 0;
            this.countCards = 0;
        }

        public String getName(){
            return name;
        }

        public Card[] getHand(){
            return hand;
        }

        public int getScore(){
            return score;
        }

        public void addCardToHand(Card card){
            if (countCards < hand.length ){
                hand[countCards++] = card;
                System.out.println(name + " menerima kartu di game " + gameName);
            } else {
                System.out.println("Tangan " + name + " sudah penuh!");
            }
        }

        public Card playCard(int index){
            if(index < 0 || index >= countCards){
                System.out.println("Tidak ada kartu di index tersebut");
                return null;
            }
            Card played = hand[index];
            System.out.println(name + " memainkan kartu:");
            played.displayCard();
            for(int i = index + 1; i < countCards; i++){
                hand [i-1] = hand [i];
            }
            hand[--countCards] = null;
            return played;
        }

        public void displayHand(){
            System.out.println(name + " memiliki " + countCards + " kartu:");
            for(int i = 0; i < countCards; i++){
                hand[i].displayCard();
            }
        }

        public void calculateScore(){
            int sum = 0;
            for(int i = 0; i < countCards; i++){
                sum += hand[i].getValue();
            }
            this.score = sum;
            System.out.println(name + " memiliki total score: " + this.score);
        }
    }

    // TODO: Buat method startGame()
    // Tampilkan: "Game [gameName] dimulai dengan [maxPlayers] pemain maksimal!"
    public void startGame(){
        System.out.println("Game " + gameName + " dimulai dengan " + maxPlayers + " pemain maksimal!");
    }

    // TODO: Buat method overloading startGame(int rounds)
    // Tampilkan: "Game [gameName] dimulai dengan [rounds] ronde!"
    public void startGame(int rounds){
        System.out.println("Game " + gameName + " dimulai dengan " + rounds + " ronde!");
    }
}