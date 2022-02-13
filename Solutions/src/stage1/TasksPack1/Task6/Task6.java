package stage1.TasksPack1.Task6;

import java.util.HashMap;

public class Task6 {
    public static void main(String[] args) {
        String helloString = "Hello World!";
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < helloString.length(); i++) {
            char thisChar = helloString.charAt(i);
            if (map.containsKey(thisChar)) {
                map.put(thisChar, map.get(thisChar) + 1);
            } else {
                map.put(helloString.charAt(i), 1);

            }
        }

        map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(System.out::println);
    }
}

