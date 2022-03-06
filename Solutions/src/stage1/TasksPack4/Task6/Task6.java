package stage1.TasksPack4.Task6;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Task6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите значение N");
        printStream(in.nextInt());
    }

    public static void printStream(int n) {
        IntStream.rangeClosed(2, Integer.MAX_VALUE)
                .filter(num -> IntStream.range(2, num)
                        .noneMatch(divideNum -> num % divideNum == 0))
                .limit(n)
                .forEach(System.out::println);
    }
}



