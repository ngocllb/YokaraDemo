//config để chạy trên cả iOS/Android
package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    static Properties androidProps = new Properties();
    static Properties iosProps = new Properties();

    static {

        try {

            androidProps.load(new FileInputStream("config/android.properties"));
            iosProps.load(new FileInputStream("config/ios.properties"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String getAndroid(String key){
        return androidProps.getProperty(key);
    }

    public static String getIOS(String key){
        return iosProps.getProperty(key);
    }

}