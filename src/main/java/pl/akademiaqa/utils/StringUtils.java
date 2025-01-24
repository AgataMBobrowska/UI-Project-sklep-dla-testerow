package pl.akademiaqa.utils;

public class StringUtils {

    public static String removeRoundBrackets(String text) {
        return text.replaceAll("[(]", "");
    }
}
