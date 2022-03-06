package stage1.TasksPack4.Task4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class Task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите слова");
        String initialText = in.nextLine();
        System.out.println("Введите количество копий N");
        int copyCount = in.nextInt();
        System.out.println("Введите лимит на слова");
        int wordsLimit = in.nextInt();
        System.out.println(copyAndPutCommas(initialText, copyCount, wordsLimit));
    }

    public static String copyAndPutCommas(String initialText, int copyCount, int wordsLimit) {
        String[] temp = initialText.split(" ");
        String commaAddedStrings = Arrays.stream(temp)
                .map(Object::toString)
                .collect(joining(","));

        int wordsCount = temp.length;
        String halfString = "";
        if (copyCount * wordsCount > wordsLimit) {
            copyCount = wordsLimit / wordsCount;
            int wordsNotFit = wordsLimit % wordsCount;
            halfString = Arrays.stream(commaAddedStrings.split(","))
                    .limit(wordsNotFit)
                    .collect(joining(","));
        }

        String copiedStrings = Stream.generate(() -> commaAddedStrings + "\n")
                .limit(copyCount)
                .collect(joining());
        return copiedStrings + halfString;
    }
}
