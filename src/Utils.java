public class Utils {
    public static boolean validateStr(String str) {
        String[] data = str.split(";");
        return data.length != 3;
    }
}
