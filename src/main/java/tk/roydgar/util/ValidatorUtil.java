package tk.roydgar.util;

public class ValidatorUtil {

    private ValidatorUtil() {}

    public static boolean parameterIsEmptyOrNull(String...inputs) {
        for (String parameter : inputs) {
            if (parameter == null || parameter.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
