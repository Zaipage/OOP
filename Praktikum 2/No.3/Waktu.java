public class Waktu {
    private int hour;   // 0..23
    private int minute; // 0..59

    // Static attribute untuk default timezone (misalnya "WIB")
    private static String DEFAULT_TZ = "WIB";

    // TODO: default constructor  -> set jam dan menit ke 0
    public Waktu() {
        hour = 0;
        minute = 0;
        
    }

    // TODO: Parameterized constructor dengan parameter jam dan menit
    // - batasi jam hanya 0..23
    // - batasi menit hanya 0..59
    public Waktu(int hour, int minute) {
        if (hour < 0) hour = 0;
        if (hour > 23) hour = 23;
        if (minute < 0) minute = 0;
        if (minute > 59) minute = 59;
        this.hour = hour;
        this.minute = minute;
        // gunakan this.hour dan this.minute
    }

    // TODO: Constructor dengan total menit
    // - ubah total menit jadi jam dan menit
    public Waktu(int totalMinutes) {
        // hour = totalMinutes/60;
        // if(hour >23){
        //     hour = hour % 24;
        // }
        // minute = totalMinutes % 60;
        // // misalnya 150 -> 02:30
        // totalMinutes = totalMinutes % (24 * 60); // handle negatif
        // if (totalMinutes < 0) {
        //     totalMinutes += 24 * 60;
        // }
        
        // hour = totalMinutes / 60;
        // minute = totalMinutes % 60;
        this.hour = (totalMinutes / 60) % 24;
        this.minute = totalMinutes % 60;
    }

    // TODO: Buatlah Getter getHour() dan getMinute()
    public int getHour() {
        return hour;
    }

    public int getMinute(){
        return minute;
    }

    // ===== STATIC method =====
    // TODO: fromMinutes(int total) -> kembalikan Waktu dari total menit
    public static Waktu fromMinutes(int total){
        Waktu w = new Waktu(total);
        return w;
    }
    // TODO: toMinutes(Waktu t) -> kembalikan total menit dari objek Waktu
    public static int toMinutes(Waktu t){
        int tm = 0;
        tm += t.getHour() * 60;
        tm += t.getMinute();
        return tm;
    }
    // TODO: addMinutes(Waktu t, int add) -> tambah menit ke sebuah Waktu
    public static Waktu addMinutes(Waktu t, int add){
        int tm = Waktu.toMinutes(t);
        tm += add;
        return new Waktu(tm);
    }

    // ===== STATIC getter & setter untuk Waktuzone =====
    // TODO: getDefaultTz() -> kembalikan DEFAULT_TZ
    public static String getDefaultTz(){
        return DEFAULT_TZ;
    }
    // TODO: setDefaultTz(String tz) -> ubah DEFAULT_TZ
    public static void setDefaultTz(String tz){
        DEFAULT_TZ = tz;
    }

    // Helper untuk format jam:menit
    private String format() {
        // TODO: kembalikan hour & minute jadi string 2 digit, contoh "09:05"
        return String.format("%02d:%02d", hour, minute);
    }

    @Override
    public String toString() {
        // TODO: kembalikan (bukan print) string "HH:MM TZ", contoh "09:05 WIB"
        String output = "" + this.format() + " "+ DEFAULT_TZ;
        return output;
}
}
