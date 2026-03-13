//tự động detect ra các driver của thiết b khi chạy test
package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DeviceDetector {

    public static String detectPlatform() {

        try {

            Process process = Runtime.getRuntime().exec("adb devices");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.contains("device") && !line.contains("List")) {
                    return "android";
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "ios";
    }

}