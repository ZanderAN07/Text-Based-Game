package MyGame;

import java.util.Scanner;

public class Helper {
    static int getValidIntInput(Scanner sc, int min, int max) {
        while (true) {
            if (sc.hasNextInt()) {
                int input = sc.nextInt();
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println("⚠️ Input out of range. Please enter between " + min + " and " + max + ".");
                }
            } else {
                System.out.println("⚠️ Invalid input. Please enter a number.");
                sc.next(); // 清除非数字输入
            }
        }
    }

}
