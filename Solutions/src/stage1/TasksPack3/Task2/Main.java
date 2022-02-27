package stage1.TasksPack3.Task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer(
                new Hdd(1024),
                new Processor(),
                new Ram(8));
        Scanner in = new Scanner(System.in);
        System.out.println("Выберите действие: " +
                "\n1. Включить/выключить компьютер" +
                "\n2. Проверить на вирусы" +
                "\n3. Вывести размер опер. памяти и винчестера" +
                "\n4. Завершить работу.");

        for (; ; ) {
            switch (in.nextInt()) {
                case 1: {
                    computer.power();
                    String state = computer.checkPower() ? "включен!" : "выключен!";
                    System.out.println("Компьютер " + state);
                    break;
                }
                case 2: {
                    System.out.println(computer.virusCheck()
                            ? "Вирусы найдены!"
                            : "Вирусы не найдены!");
                    break;
                }
                case 3: {
                    System.out.println(computer.getMemory());
                    break;
                }
                case 4: {
                    System.out.println("Работа завершена!");
                    return;
                }
                default: {
                    System.out.println("Введите правильное значение");
                    break;
                }
            }
        }
    }
}
