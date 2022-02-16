package stage1.TasksPack2.Task1;

import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        System.out.println(convertSequenceToString(getFibonacciSequence(count)));

    }

    public static ArrayList<Integer> getFibonacciSequence(int count) {
        ArrayList<Integer> list = new ArrayList<>();
        if (count == 0) return list;
        list.add(0);
        if (count > 1) {
            list.add(1);
        }
        for (int i = 2; i < count; i++)
            list.add(list.get(i - 2) + list.get(i - 1));
        return list;

    }

    public static String convertSequenceToString(ArrayList<Integer> list) {
        StringBuilder builder = new StringBuilder();
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            builder.append(list.get(i));
            if (i != listSize - 1)
                builder.append(" ");
        }
        return builder.toString();

    }
}
