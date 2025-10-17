public class CliDeliveryChannel implements DeliveryChannel{
    // TODO:
    // Kelas ini harus mengimplementasikan interface Delivery channel

    // TODO:
    // Kelas ini harus method deliver dari DeliveryChannel dengan ketentuan:
    // 1. Ketika responsenya adalah null maka return string kosong ("")
    // 2. Ketika responsenya valid, return: "[CLI] <chatbot name>: <response>"
    @Override
    public String deliver(String response, Chatbot chatbot){
        if (response == null){
            return "";
        }
        return "[CLI] " + chatbot.getName() + ": " + response;
    }
}
