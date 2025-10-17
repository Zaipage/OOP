public class FormalResponseStyle implements ResponseStyle {
    // TODO:
    // Kelas ini harus mengimplementasikan interface ResponseStyle


    // TODO:
    // Kelas ini harus method format dari ResponseStyle dengan ketentuan:
    // 1. Lakukan return: "Dear user, <response> Sincerely."
    public String format(String baseResponse){
        return "Dear user, " + baseResponse + " Sincerely."; // make + baseResponse + karna nama paramater di methodnya baseResponse "(String baseResponse)"
    }
}
