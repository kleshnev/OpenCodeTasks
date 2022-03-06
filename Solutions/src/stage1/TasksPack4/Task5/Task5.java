package stage1.TasksPack4.Task5;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число для проверки");
        int inputNum = in.nextInt();
        System.out.println(new Fibonacci().isFibonacci(inputNum)
                ? "Число является элементом фибоначчи"
                : "Число НЕ является элементом фибоначчи");
    }

}

class Fibonacci {
    private int previous = 0;
    private int current = 1;

    private int next() {
        int temp = previous + current;
        previous = current;
        current = temp;
        return current;
    }

    public boolean isFibonacci(int userNum) {
        var fibList = Stream.generate(this::next)
                .takeWhile(number -> number <= userNum)
                .collect(Collectors.toList());
        return fibList.get(fibList.size() - 1) == userNum;
    }
}
