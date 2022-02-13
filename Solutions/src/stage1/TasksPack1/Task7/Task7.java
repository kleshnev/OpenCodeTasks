package stage1.TasksPack1.Task7;

public class Task7 {
    public static void main(String[] args) {
        String tempStr;
        int count;
        for (int i = 100; i >= 0; i--) {
            count = i / 10 % 10 == 1 ? 0 : i % 10;
            if (count == 1) {
                tempStr = "бутылка";
            } else if (count == 2 || count == 3 || count == 4) {
                tempStr = "бутылки";
            } else {
                tempStr = "бутылок";
            }
            String str = String.format("%d %s стояло на столе, одна из них упала и разбилась...", i, tempStr);
            System.out.println(str);
        }
    }
}

