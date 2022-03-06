package stage1.TasksPack4.Task7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {
            //Path source = Paths.get();
            File fileInput = new File("Solutions/src/stage1/TasksPack4/Task7/text.txt");
            File fileResult = new File("Solutions/src/stage1/TasksPack4/Task7/result.txt");
            Scanner in = new Scanner(fileInput);
            Sentence sentence = new Sentence(in.nextLine().split(" "));
            Set<String> set = new HashSet<>(sentence.getWordsCount());
            var resultList = Arrays.stream(sentence.getWords())
                    .filter(word -> set.add(word.getOriginalWord()))
                    .collect(Collectors.toList());
            resultList.forEach(word -> System.out.print(word.getOriginalWord() + " "));


            HashSet<Character> allVowels = new HashSet<>(Arrays.asList('а', 'у', 'о', 'и', 'э','ы','я', 'ю', 'е', 'ё','А', 'У', 'О', 'И', 'Э','Ы','Я', 'Ю', 'Е', 'Ё'));
            int vowelCount = (int) resultList.stream()
                    .filter(p -> allVowels.contains(p.getSymbols()[0]))
                    .count();

            int consonantCount = resultList.size() - vowelCount;

            BufferedWriter out = new BufferedWriter(new FileWriter(fileResult));
            String result = String.format("Анализ текста.\nВсего слов - %d\n" +
                    "Из них : \n" +
                    "с согласной  - %d\n" +
                    "с гласной - %d",resultList.size() ,consonantCount,vowelCount);
            out.write(result);
            out.close();

        } catch (
                Exception ex) {
            ex.printStackTrace();
        }
    }
}
