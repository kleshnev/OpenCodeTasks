package stage1.TasksPack2.Bonus;

import java.util.Scanner;

public class ConsoleProgram {
    public void start(MyIntList myList) {
        Scanner in = new Scanner(System.in);
        for (; ; ) {
            System.out.println("— Длина массива - " + myList.getLength() +
                    "\n— Исходный массив: \n" + myList.toString() +
                    "\n— Выберите операцию:" +
                    "\n\n1. Добавить элемент" +
                    "\n2. Вставить элемент в середину" +
                    "\n3. Вставить элемент по индексу" +
                    "\n4. Удалить элемент по индексу" +
                    "\n5. Отсортировать список" +
                    "\n6. Очистить список" +
                    "\n7. Завершить работу" +
                    "\n— Введите номер операции:");
            int userInput = in.nextInt();
            switch (userInput) {
                case 1: {
                    System.out.println("Введите элемент:");
                    myList.add(in.nextInt());
                    System.out.println("Элемент добавлен!");
                    break;
                }
                case 2: {
                    System.out.println("Введите элемент для вставки в середину:");
                    myList.insert(in.nextInt(), myList.getLength() / 2);
                    System.out.println("Элемент вставлен в середину");
                    break;
                }
                case 3: {
                    System.out.println("Введите элемент для вставки по индексу:");
                    int element = in.nextInt();
                    System.out.println("Введите номер индекса:");
                    int pos = in.nextInt();
                    while (pos > myList.getLength()) {
                        System.out.println("Неверное значение, введите новое значение:");
                        pos = in.nextInt();
                    }
                    myList.insert(element, pos);
                    System.out.println("Элемент вставлен по индексу");
                    break;
                }
                case 4: {
                    System.out.println("Введите индекс для удаления:");
                    int pos = in.nextInt();
                    while (pos > myList.getLength() - 1) {
                        System.out.println("Неверное значение, введите новое значение:");
                        pos = in.nextInt();
                    }
                    myList.remove(pos);
                    System.out.println("Элемент удален по индексу!");
                    break;
                }
                case 5: {
                    myList.sort();
                    System.out.println("Лист отсортирован!");
                    break;
                }
                case 6: {
                    myList.clear();
                    System.out.println("Список очищен!");
                    break;
                }
                case 7: {
                    System.out.println("Работа завершена!");
                    return;
                }
                default: {
                    System.out.println("Введите правильный номер операции");
                }
            }
            System.out.println("******************************");
        }
    }
}
