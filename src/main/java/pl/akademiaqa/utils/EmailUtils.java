package pl.akademiaqa.utils;

import com.github.javafaker.Faker;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class EmailUtils {

    public static String generateRandomEmail() {
        return new Faker().internet().emailAddress();
    }
}
