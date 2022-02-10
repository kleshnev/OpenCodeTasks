package stage1.TasksPack1.Task8;

import java.util.*;

public class Task8 {
    static List<String> strList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String expression = in.nextLine();
        String[] strmass = (expression.split("((?<=[*\\-+/])|(?=[*\\-+/]))"));

        int numbers = 0;
        int symbols = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (tryParseInt(strmass[i])) {
                numbers++;
            } else {
                symbols++;
            }
        }
        if (symbols >= numbers || !tryParseInt(strmass[0]) || !tryParseInt(strmass[strmass.length - 1])) {
            System.out.println("Ошибка ввода");
            return;
        }
        Collections.addAll(strList, strmass);

        //При нахождении * или / удаляем правое число i+1, символ i, левый символ i-1 и сдвигаемся на один цикл назад. Ищем умножение или деление дальше.
        //Повторное прохождения цикла уже завершает все + и - в порядке очереди.

        for (int i = 0; i < strList.size(); i++) {
            String str = strList.get(i);
            if (str.equals("*")) {
                solveAndChangeList(i);
                i--;
            } else if (str.equals("/")) {
                solveAndChangeList(i);
                i--;
            }
        }
        for (int i = 0; i < strList.size(); i++) {
            String str = strList.get(i);
            if (str.equals("+")) {
                solveAndChangeList(i);
                i--;
            }
            if (str.equals("-")) {
                solveAndChangeList(i);
                i--;
            }
        }
        System.out.println(strList.get(0));
    }

    public static void solveAndChangeList(int i) {
        int res = Integer.parseInt(strList.get(i - 1)) - Integer.parseInt(strList.get(i + 1));
        strList.remove(i + 1);
        strList.remove(i);
        strList.remove(i - 1);
        strList.add(i - 1, String.valueOf(res));
    }

    public static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
