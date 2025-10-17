import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quiz {
    // TODO: Deklarasikan field untuk menyimpan daftar pertanyaan
    private List<Question> questions;

    public Quiz() {
        // TODO: Inisialisasi daftar pertanyaan
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        // TODO: Tambahkan pertanyaan ke daftar
        questions.add(question);
    }

    public void displayAllQuestions() {
        // TODO: Iterasi setiap pertanyaan dan tampilkan dengan format "Pertanyaan
        // x:<newline>" lalu detailnya dengan memanggil question.display() dan tambahkan
        // juga 1 newline setelah pemanggilan fungsi display
        for (int i = 0; i < questions.size(); i++){
            System.out.println("Pertanyaan " + (i + 1) + ":");
            questions.get(i).display(); // di luar system.out.println yg pertama karena display() bukanlah string alias udh langsung cetak ke layar (void)
            System.out.println(); // newline
        }
    }

    public boolean checkAnswer(int questionIndex, int selectedOptionNumber) {
        // TODO: Validasi indeks pertanyaan, jike tidak valid maka keluarkan output:
        // "Question index out of bounds<newline>"
        // kemudian return false
        if (questionIndex < 0 || questionIndex >= questions.size()){ // kalo dia kurang dari 0 atau lebih dari size maka dia tidak valid
            System.out.println("Question index out of bounds");
            return false;
        }
        // TODO: Ambil pertanyaan berdasarkan indeks
        Question question = questions.get(questionIndex); // question itu variabel sementara untuk nyimpen pertanyaan yg diambil berdasarkan fungsi oleh method
        // TODO: Periksa apakah nomor opsi valid, jika tidak valid keluarkan output:
        // "Selected option is not available<newline>"
        // kemudian return false
        if (!question.isValidOption(selectedOptionNumber)){ // pake "question." karena dia diinialisasi sebagai objek Question di baris sebelumnya dimana isValidOption itu method dari Question bukan options
            System.out.println("Selected option is not available");
            return false;
        }
        // TODO: Kembalikan hasil pemeriksaan jawaban benar
        return question.isCorrect(selectedOptionNumber); // sama, isCorrect juga method di class Question
    }

    public List<Question> getQuestions() {
        return Collections.unmodifiableList(questions);
    }

    public int size() {
        // TODO: Mengembalikan jumlah pertanyaan dalam kuis
        return questions.size();
    }
}
