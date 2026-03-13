package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class DeviceManager {

    public static String getAndroidUDID() {

        ProcessBuilder processBuilder = new ProcessBuilder("adb", "devices");
        processBuilder.redirectErrorStream(true);

        try {
            Process process = processBuilder.start();

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8))
            ) {
                String line;

                while ((line = reader.readLine()) != null) {
                    String normalized = line.trim();

                    if (normalized.isEmpty() || normalized.startsWith("List")) {
                        continue;
                    }

                    String[] parts = normalized.split("\\s+");
                    if (parts.length >= 2 && "device".equals(parts[1])) {
                        return parts[0];
                    }
                }
            }

            int exitCode = process.waitFor();
            if (exitCode != 0) {
                throw new RuntimeException("adb devices returned non-zero exit code: " + exitCode);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to execute adb devices command", e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted while reading adb devices output", e);
        }

        throw new RuntimeException("No Android device found in 'adb devices' output");
    }
}