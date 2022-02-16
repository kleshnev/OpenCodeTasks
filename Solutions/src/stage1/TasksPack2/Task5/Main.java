package stage1.TasksPack2.Task5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputLine = in.nextLine();
        String[] inputArray = inputLine.split(" ");
        Sentence sentence = new Sentence(inputArray);
        System.out.println("Модель создана.");

    }
}
