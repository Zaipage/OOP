import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question {
    // TODO: Deklarasikan field untuk menyimpan teks pertanyaan
    // TODO: Deklarasikan field untuk daftar Option
    // TODO: Deklarasikan field untuk indeks jawaban yang benar
    private String text;
    private List<Option> options;
    private int correctAnswerIndex;

    public Question(String text) {
        // TODO: Inisialisasi teks pertanyaan dan struktur data daftar option
        // TODO: Atur nilai awal indeks jawaban benar (misalnya -1)
        this.text = text;
        this.options = new ArrayList<>();
        this.correctAnswerIndex = -1;
    }

    public void addOption(String optionText, boolean correct) {
        // TODO: Buat objek Option baru menggunakan inner class
        Option newOption = new Option(optionText); // newOption sebagai variabel baru yg menampung hasil "new Option(optionText)"
        // Cara baca:
        // variabel baru bernama newOption bertipe option lalu isi variabel tsb dengan objek "new Option"dan diinisialisasi dengan texk dari parameter "optionText"
        // TODO: Tambahkan option ke dalam daftar
        options.add(newOption);
        // TODO: Jika parameter correct true, perbarui indeks jawaban benar
        if (correct){
            correctAnswerIndex = options.size() - 1;
            // sebelum addOption dipanggil options.size() == 0
            // tiap dipanggil dan dia benar maka menjadi options.size == 1 dst, alias bertambah
            // ".size()" dipake ketika mau tau jumlah elemen skrg dan urutan elemen yg baru ditambah
            // correctAnswerIndex = options.size() - 1 karena size() itu jumlah/ukuran bukan urutan i
            // jadi misal kita udah masukin 3 jawaban brrti nanti sizenya ada 3, jadi kalau kita input user no 2.java akan salah karena di list java itu urutan 1 (0-based)
            // jadi dia malahan akan baca indeks urutan 3 dari 0,1,2 yaitu indeks 2
            // dia juga berhubungan sama method isCorrect dimana opsi yg benar adalah " x - 1 == correctAnswerIndex"
        }
    }

    public void display() {
        // TODO: Cetak teks pertanyaan yang diakhiri newline
        System.out.println(text); // ini tu sama aja kaya -> cetak isi variabel text ke layar
        // TODO: Iterasi seluruh option dan tampilkan dengan format "nomor.teks<newline>"
        for (int i = 0; i < options.size(); i++){ // seluruh option = options.size() jadi iterasi selama i alias isi dari options masih belum sejumlah size()
            System.out.println((i + 1) + ". " + options.get(i).getText());
            // (i + 1 ) itu maksudnya no urut, "+ 1" karena biasa i mulai dari 0. Jadi biar outputnya 1. blablbla
            // ". " biar hasilnya 1"." blablabla
            // options.get(i) = ambil elemen ke-i dari list options
            // .getText() = ambil text dari si options
            // gak bisa langsung ambil text karena options itu list jadi kita mulai ambil dri index nya
        }
    }

    public boolean isCorrect(int selectedOptionNumber) {
        // TODO: Konversi nomor 1-based menjadi indeks 0-based dan bandingkan dengan
        // jawaban benar yang disimpan di dalam kelas
        return (selectedOptionNumber - 1) == correctAnswerIndex; 
        // - 1 karena pas di display kan kita nampilinnya dalam bentuk + 1 (1-based)
        // jadi kalo selected ga di - 1 nanti yg ditampilin salah (misal user milih opsi 1 di display (i + 1), tapi karena di 0-based aslinya opsi 1 == list ke 0, maka kalo langsung dan ga di - 1 nanti yg keluar malah isi opsi 2)
        // correctAnswerIndex untuk cek opsi yg dipilih == jawaban bener atau engga
        // cth: 
        /* Opsi:
         * 1. A (dalam list java == 0)
         * 2. B (dalam list java == 1)
         * opsi yang benar (correctAnswerIndex) = 1 (1-based) alias 0 dalam java (0-based)
         * user menjawab 1 (1-based)
         * maka terjadi perhitungan " 1 - 1 = correctAnswerIndex" -> "0 = 0"
         * 0 = 0 -> sesuai berarti input jawaban user bener
         */
    }

    public boolean isValidOption(int selectedOptionNumber) {
        // TODO: Periksa apakah nomor opsi berada dalam rentang indeks daftar option
        return selectedOptionNumber >= 1 && selectedOptionNumber <= options.size();
        // selected >= 1 karena inputnya 1-based kalau mulai dari 0 nanti 0 - 1 = -1 (error)
        // selectedOptionNumber <= options.size() artinya pilihannya masih ada dalam rentang opsi
    }

    public List<Option> getOptions() {
        return Collections.unmodifiableList(options);
    }

    public class Option { // nested class alias class yg di deklarasikan dalam class lain (option sebagai inner class dari question)
        // TODO: Deklarasikan field untuk menyimpan teks option
        private String text;

        private Option(String text) {
            // TODO: Simpan teks option pada field yang sesuai
            this.text = text;
        }

        public String getText() {
            // TODO: Mengembalikan teks option
            return text;
        }
    }
    // public class option jadi inner class karena dia kepake cuma kalo question berjalan
    // jadi kalo mau manggil diluar class atau file question harus -> Question.Option
    
}

