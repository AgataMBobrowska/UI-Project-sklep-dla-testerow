package pl.akademiaqa.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import java.nio.charset.StandardCharsets;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringUtils {

    public static String removeRoundBrackets(String text) {
        return text.replaceAll("[(]", "");
    }

    public static String toUTF8(String str) {
        return new String(str.getBytes(), StandardCharsets.UTF_8);
    }
}
