public class ApiDeliveryChannel implements DeliveryChannel {
    // TODO:
    // Kelas ini harus mengimplementasikan interface Delivery channel
    private String token;

    // TODO:
    // Kelas ini harus memiliki sebuah attribute token dengan tipe String
    // Inisialisasi token dilakukan dalam konstruktor kelas, apabila token yang
    // di-passing dalam parameter konstruktor kelas adalah null, maka beri nilai
    // default yaitu: "BLANK"
    public ApiDeliveryChannel(String token){
        if (token == null){
            this.token = "BLANK";
        } else {
            this.token = token;
        }
    }

    // TODO:
    // Kelas ini harus method deliver dari DeliveryChannel dengan ketentuan:
    // 1. Ketika responsenya adalah null maka return string kosong ("")
    // 2. Ketika responsenya valid, return: "[API token=<token>] <chatbot name>: <response>"
    @Override
    public String deliver(String response, Chatbot chatbot){ //kalau misal dia override method maka copas kepala method dari file yg di override aja *persis
        if (response == null){
            return ""; //return itu mengakhiri method alias menghentikan eksekusi
        }
        return "[API token=" + token + "] " + chatbot.getName() + ": " + response; //makanya kondisi kedua diluar if-else karna udh berhenti di return 
        // pakai chatbot.getname() karena atribut name di chatbot sifatnya private jadi harus melalui getter
    }
}
