package imran.util;

public class StringUtil {

    public static boolean isNotBlank(String in) {
        if (in == null || in.isEmpty()) {
            return false;
        }

        return true;
    }

    public static boolean isBlank(String in) {
        if (in == null || in.isEmpty()) {
            return true;
        }

        return false;
    }
}
