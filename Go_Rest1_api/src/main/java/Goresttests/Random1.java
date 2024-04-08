package Goresttests;

import java.util.Random;

public class Random1 {
    public static String generateRandomName() {
        return "Anushka" + new Random().nextInt(1000);
    }

    public static String generateDynamicEmail() {
        return "Anushka" + new Random().nextInt(1000) + "@gmail.com";
    }
}
