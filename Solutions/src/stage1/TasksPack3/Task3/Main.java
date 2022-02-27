package stage1.TasksPack3.Task3;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ElectricLine line = new ElectricLine();
        line.setPowerToAppliances();
        System.out.println("Введите значение лимита нагрузки на сеть:");
        int limitAmperage = in.nextInt();
        boolean stopProgram = false;
        while (!stopProgram) {
            line.checkForLoadExceeding(limitAmperage);
            System.out.println("\nВыберите дальнешее действие:");
            System.out.println("1. Выключить/включить выбранное устройтво и произвести расчеты.");
            System.out.println("2. Поменять значение лимита нагрузки на сеть");
            System.out.println("3. Завершить работу");
            switch (in.nextInt()) {
                case 1: {
                    System.out.println("Выберите какой прибор отключить/влючить");
                    line.printList();
                    int index = in.nextInt();
                    while (index < 0 || index > line.getListLength() - 1) {
                        System.out.println("Введите правильное значение");
                        index = in.nextInt();
                    }
                    line.switchPowerByIndex(index);
                    break;
                }
                case 2: {
                    System.out.println("Введите значение лимита нагрузки на сеть:");
                    limitAmperage = in.nextInt();
                    break;
                }
                case 3: {
                    stopProgram = true;
                    break;
                }
                default: {
                    System.out.println("Выберите правильное значение\n");
                    break;
                }
            }
        }
    }


}
