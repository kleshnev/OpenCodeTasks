package stage1.TasksPack2.Task4;

import java.security.KeyStore;
import java.util.*;
import java.util.Map.Entry;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputStr = in.nextLine();
        String[] inputArray = inputStr.split(" ");

        List<String> max = Arrays.stream(inputArray)
                .collect(groupingBy(String::length, TreeMap::new, toList()))
                .lastEntry()
                .getValue();


        List<String> min = Arrays.stream(inputArray)
                .collect(groupingBy(String::length, TreeMap::new, toList()))
                .firstEntry()
                .getValue();


        System.out.println(String.format("Максимальное значение символов - %d", max.get(0).length()));
        getReapetedEntries(max)
                .forEach((key, value) -> System.out.println(key + " - " + value + " повторения"));
        System.out.println(String.format("Минимальное значение символов - %d", min.get(0).length()));
        getReapetedEntries(min)
                .forEach((key, value) -> System.out.println(key + " - " + value + " повторения"));
    }
    public static HashMap<String, Integer> getReapetedEntries(List<String> words)
    {
        HashMap<String, Integer> repeatedEntries = new HashMap<>();
        for (String str : words) {
            if (repeatedEntries.containsKey(str)) {
                repeatedEntries.put(str, repeatedEntries.get(str) + 1);
            } else {
                repeatedEntries.put(str, 1);
            }
        }
        return repeatedEntries;
    }
}
