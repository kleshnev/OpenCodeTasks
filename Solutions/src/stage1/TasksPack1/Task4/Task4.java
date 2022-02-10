package stage1.TasksPack1.Task4;

public class Task4 {

    public static void main(String[] args) {
        int[] mass = new int[30];
        for (int i = 0; i < mass.length; i++) {
            if (i % 10 == 0 && i != 0)
                System.out.println();
            System.out.print(i + " ");

        }
    }
}

