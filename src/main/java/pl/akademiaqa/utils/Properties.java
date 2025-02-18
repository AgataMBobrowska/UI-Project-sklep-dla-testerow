package pl.akademiaqa.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import java.util.ResourceBundle;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Properties {

    public static String getProperty(String propertyName){
        return ResourceBundle.getBundle("application").getString(propertyName);
    }
}
