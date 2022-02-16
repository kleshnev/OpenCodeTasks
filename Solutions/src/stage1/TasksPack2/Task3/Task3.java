package stage1.TasksPack2.Task3;

import java.util.ArrayList;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите слова");
        String inputStr = in.nextLine();
        String[] strArray = inputStr.split(" ");
        System.out.println("Введите номер позиции символа для замены");

        int position = in.nextInt();
        if (position < 0) throw new IllegalArgumentException("Введите правильный номер символа");

        System.out.println("Введите символ для замены");
        char symbolReplacement = in.next().charAt(0);
        ArrayList<String> resultArray = getReplacedWords(strArray, position, symbolReplacement);

        for (String word : resultArray) {
            System.out.print(word + " ");
        }
    }

    public static ArrayList<String> getReplacedWords(String[] strArray, int position, char symbolReplacement) {

        StringBuilder builder = new StringBuilder();
        ArrayList<String> resultArray = new ArrayList<>();
        for (String word : strArray) {
            if (position < word.length()) {
                builder.append(word);
                builder.setCharAt(position, symbolReplacement);
                resultArray.add(builder.toString());
                builder.setLength(0);
            } else {
                resultArray.add(word);
            }
        }
        return resultArray;
    }
}
