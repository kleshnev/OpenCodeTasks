package stage1.TasksPack3.Task4;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Diary diary = new Diary();
        LocalDateTime datet = diary.convertStringToDateTime("14/07/2000/15:05");
        BusinessRecord bs = new BusinessRecord(new String[]{"text", "hey"}, datet);
        diary.addRecord(bs);
        BusinessRecord bs2 = new BusinessRecord(new String[]{"text2", "hey2"}, datet);

        diary.addRecord(bs2);
        for (; ; ) {
            System.out.println("Выберите действие:");
            System.out.println("1.Добавить запись\n" +
                    "2.Показать запись по дате/время\n" +
                    "3.Удаление записи по дате/время\n" +
                    "4.Корректировка записи\n" +
                    "5.Показать все записи\n" +
                    "6.Показать последнюю запись\n" +
                    "7.Завершить работу");

            int userInput = in.nextInt();
            in.nextLine();
            switch (userInput) {
                case 1: {
                    System.out.println("Введите дату записи в формате dd/M/yyyy/HH:mm");
                    LocalDateTime date = diary.convertStringToDateTime(in.nextLine());
                    System.out.println("Введите текст записи");
                    String text = in.nextLine();
                    diary.addRecord(new BusinessRecord(text.split(" "), date));
                    System.out.println("Запись добавлена!");
                    diary.showAll(true);
                    break;
                }
                case 2: {
                    System.out.println("Введите дату записи в формате dd/M/yyyy/HH:mm");
                    LocalDateTime date = diary.convertStringToDateTime(in.nextLine());
                    diary.showByDateTime(date);
                    break;
                }
                case 3: {
                    System.out.println("Введите дату записи в формате dd/M/yyyy/HH:mm");
                    LocalDateTime userInputDate = diary.convertStringToDateTime(in.nextLine());
                    BusinessRecord[] sameDateRecords = diary.searchByDateTime(userInputDate);
                    if (sameDateRecords.length > 1) {
                        diary.showByDateTime(userInputDate);
                        System.out.println("Данную дату содержит более одна запись. Выберите номер записи.");
                        int input = in.nextInt();
                        while (input < 1 || input > sameDateRecords.length) {
                            System.out.println("Введите правильное значение!");
                            input = in.nextInt();
                        }
                        System.out.println(diary.deleteByHash(sameDateRecords[input - 1].hashCode()) ? "Запись удалена!" : "Запись не была удалена!");
                    } else {
                        System.out.println(diary.deleteByDate(userInputDate) ? "Запись удалена!" : "Запись не была удалена!");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Введите дату записи в формате dd/M/yyyy/HH:mm");
                    LocalDateTime userInputDate = diary.convertStringToDateTime(in.nextLine());
                    diary.correct(userInputDate);
                    break;
                }
                case 5: {
                    System.out.println("Выберите сортировку:\n1.По возрастанию \n2.По убыванию\n");
                    int sort = in.nextInt();
                    while (sort < 1 || sort > 2) {
                        System.out.println("Выберите правильное значение");
                        sort = in.nextInt();
                    }
                    diary.showAll(sort == 1);
                    break;

                }
                case 6: {
                    diary.showLast();
                    break;
                }
                case 7: {
                    return;
                }

            }
        }
    }
}
