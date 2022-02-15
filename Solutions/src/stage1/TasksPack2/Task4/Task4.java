package stage1.TasksPack2.Task4;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputStr = in.nextLine();
        String[] inputArray = inputStr.split(" ");

        List<String> maxElements = findMaxElements(inputArray);
        List<String> minElements = findMinElements(inputArray);

        printOutputResult(maxElements, maxElements.get(0).length(), "Максимальное");
        printOutputResult(minElements, minElements.get(0).length(), "Минимальное");
    }

    public static List<String> findMaxElements(String[] array) {
        return Arrays.stream(array)
                .collect(groupingBy(String::length, TreeMap::new, toList()))
                .lastEntry()
                .getValue();
    }

    public static List<String> findMinElements(String[] array) {
        return Arrays.stream(array)
                .collect(groupingBy(String::length, TreeMap::new, toList()))
                .firstEntry()
                .getValue();
    }

    public static HashMap<String, Integer> getRepeatedEntries(List<String> words) {
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

    public static void printOutputResult(List<String> resultList, int listLength, String userText) {
        System.out.println(String.format("%s значение символов - %d.", userText, listLength));
        getRepeatedEntries(resultList)
                .forEach((key, value) -> System.out.println(String.format("%s - повторяется %d р. ", key, value)));
        System.out.println();
    }
}
