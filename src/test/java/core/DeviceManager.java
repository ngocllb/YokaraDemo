package core;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DeviceManager {

    public static String getAndroidUDID() {

        try {

            Process process = Runtime.getRuntime().exec("adb devices");

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.endsWith("device") && !line.startsWith("List")) {

                    return line.split("\\s")[0];
                }
            }

        } catch (Exception e) {

            throw new RuntimeException("No Android device found");
        }

        return null;
    }
}