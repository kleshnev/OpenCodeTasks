package stage1.TasksPack4.Task3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("Введите число для проверки");
        Scanner in = new Scanner(System.in);
        CheckInterface dividesByThirteen = (x -> x % 13 == 0);
        System.out.println(dividesByThirteen.check(in.nextInt()) ? "Делится" : "Не делится!");
    }

    @FunctionalInterface
    interface CheckInterface {
        boolean check(int n);
    }
}
