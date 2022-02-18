package stage1.TasksPack2.Task2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String formatted = str.replaceAll("[^a-zA-Zа-яА-ЯёЁ\\s]","");
        System.out.println(formatted);
    }
}
