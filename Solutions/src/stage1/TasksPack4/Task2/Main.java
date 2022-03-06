package stage1.TasksPack4.Task2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите текст с повторами");
        Scanner in = new Scanner(System.in);
        Sentence sentence = new Sentence(in.nextLine().split(" "));
        Set<String> set = new HashSet<>(sentence.getWordsCount());
        Arrays.stream(sentence.getWords())
                .filter(word -> set.add(word.getOriginalWord()))
                .collect(Collectors.toList())
                .forEach(word -> System.out.print(word.getOriginalWord() + " "));

    }
}
