package stage1.TasksPack2.Bonus;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyIntList myList = new MyIntList();
        Scanner in = new Scanner(System.in);
        for (; ; ) {
            System.out.println("— Длина массива - " + myList.getLength() +
                    "\n— Исходный массив: \n" + myList.toString() +
                    "\n— Выберите операцию:" +
                    "\n1. Добавить элемент" +
                    "\n2. Вставить элемент по индексу" +
                    "\n3. Удалить элемент по индексу" +
                    "\n4. Отсортировать список:" +
                    "\n5. Очистить список:" +
                    "\n6. Завершить работу" +
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
                    System.out.println("Введите элемент:");
                    int element = in.nextInt();
                    System.out.println("Введите индекс:");
                    int pos = in.nextInt();
                    myList.insert(element, pos);
                    System.out.println("Элемент вставлен по индексу");
                    break;
                }
                case 3: {
                    System.out.println("Введите индекс для удаления:");
                    int pos = in.nextInt();
                    myList.remove(pos);
                    System.out.println("Элемент удален по индексу!");
                    break;
                }
                case 4: {
                    myList.sort();
                    System.out.println("Лист отсортирован!");
                    break;
                }
                case 5: {
                    myList.clear();
                    System.out.println("Список очищен!");
                    return;
                }
                case 6: {
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
