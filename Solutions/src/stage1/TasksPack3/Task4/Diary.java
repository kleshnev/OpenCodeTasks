package stage1.TasksPack3.Task4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Diary {

    private final HashSet<BusinessRecord> businessRecords = new HashSet<>();

    public BusinessRecord[] searchByDateTime(LocalDateTime date) {
        return businessRecords.stream()
                .filter(x ->
                        x.getExecuteDate().getYear() == date.getYear()
                                && x.getExecuteDate().getMonthValue() == date.getMonthValue()
                                && x.getExecuteDate().getDayOfMonth() == date.getDayOfMonth())
                .toArray(BusinessRecord[]::new);
    }

    public boolean deleteByDate(LocalDateTime date) {
        List<BusinessRecord> records =
                businessRecords.stream()
                        .filter(x -> x.getExecuteDate() == date)
                        .collect(Collectors.toList());
        if (records.size() > 0) {
            businessRecords.removeAll(records);
            return true;
        }
        return false;
    }

    public boolean deleteByHash(int hashCode) {

        List<BusinessRecord> records =
                businessRecords.stream()
                        .filter(x -> x.hashCode() == hashCode)
                        .collect(Collectors.toList());
        if (records.size() > 0) {
            businessRecords.removeAll(records);
            return true;
        }
        return false;
    }

    public BusinessRecord searchByHash(int hash) {
        for (BusinessRecord rec : businessRecords) {
            if (rec.hashCode() == hash) {
                return rec;
            }
        }
        throw new NullPointerException();
    }

    public void addRecord(BusinessRecord record) {
        businessRecords.add(record);
    }

    public void correct(LocalDateTime date) {
        Scanner in = new Scanner(System.in);
        BusinessRecord record;
        BusinessRecord[] sameDateRecords = searchByDateTime(date);
        if (sameDateRecords.length > 1) {
            showByDateTime(date);
            System.out.println("???????????? ???????? ???????????????? ?????????? ???????? ????????????. ???????????????? ?????????? ????????????.");
            int Uinput = in.nextInt();
            while (Uinput < 1 || Uinput > sameDateRecords.length) {
                System.out.println("?????????????? ???????????????????? ????????????????!");
                Uinput = in.nextInt();
            }
            record = searchByHash(sameDateRecords[Uinput - 1].hashCode());
        } else {
            record = sameDateRecords[0];
        }
        System.out.println("???????????????? ?????? ??????????????????????????:\n1.???????? ????????????\n2.?????????? ????????????");
        int input = in.nextInt();
        if (input == 1) {
            in.nextLine();
            System.out.println("?????????????? ???????? ?? ?????????????? dd/M/yyyy/HH:mm");
            LocalDateTime userDate = convertStringToDateTime(in.nextLine());
            for (BusinessRecord rec : businessRecords) {
                if (rec.hashCode() == record.hashCode()) {
                    rec.setExecuteDate(userDate);
                }
            }
        } else if (input == 2) {
            in.nextLine();
            System.out.println("?????????????? ??????????");
            String str = in.nextLine();
            String[] strArr = str.split(" ");
            ArrayList<Word> words = new ArrayList<>();
            for (String s : strArr) {
                words.add(new Word(s));
            }
            for (BusinessRecord rec : businessRecords) {
                if (rec.hashCode() == record.hashCode()) {
                    rec.setWords(words);
                }
            }
        }
        showAll(true);
    }


    public void showAll(boolean asc) {
        List<BusinessRecord> temp = new ArrayList<>(businessRecords);
        Comparator<BusinessRecord> ascending = Comparator.comparing(BusinessRecord::getExecuteDate);
        Comparator<BusinessRecord> descending = Comparator.comparing(BusinessRecord::getExecuteDate).reversed();
        temp.sort(asc ? ascending : descending);
        int count = 0;
        for (BusinessRecord record : temp) {
            print(record, ++count);
        }
    }

    public void showByDateTime(LocalDateTime date) {
        int count = 0;
        BusinessRecord[] time = searchByDateTime(date);
        for (BusinessRecord record : time) {
            print(record, ++count);
        }
    }

    public BusinessRecord showLast() {
        List<BusinessRecord> temp = new ArrayList<>(businessRecords);
        Comparator<BusinessRecord> ascending = Comparator.comparing(BusinessRecord::getCreatedWhen);
        temp.sort(ascending);
        BusinessRecord lastRec = temp.get(temp.size() - 1);
        print(lastRec, 1);
        return lastRec;
    }

    public LocalDateTime convertStringToDateTime(String text) {
        return LocalDateTime.parse(text, DateTimeFormatter.ofPattern("dd/M/yyyy/HH:mm"));
    }

    private String getFormattedDate(LocalDateTime time) {
        return time.format(DateTimeFormatter.ofPattern("dd/MM/yyyy/HH:mm"));
    }

    private void print(BusinessRecord record, int counter) {
        System.out.printf("???????????? #%d\n", counter);
        System.out.printf("???????????? ??????????????:\n%s\n", getFormattedDate(record.getCreatedWhen()));
        System.out.printf("?????????????????????? ??????????:\n%s\n", getFormattedDate(record.getExecuteDate()));
        System.out.printf("??????????: \n%s\n\n", record.getWordsAsString());
    }
}
