package stage1.TasksPack1.Task9;

import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String formatSentence = in.nextLine().toLowerCase().replaceAll(" ", "");
        String reverse = new StringBuilder(formatSentence).reverse().toString();
        if (formatSentence.equals(reverse)) {
            System.out.println("Это палиндром");
        } else {
            System.out.println("Это не палиндром");
        }

    }
}
