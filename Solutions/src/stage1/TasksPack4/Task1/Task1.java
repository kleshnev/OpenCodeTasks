package stage1.TasksPack4.Task1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите N размер матрицы");
        drawSpiral(in.nextInt());
    }

    public static void drawSpiral(int n) {
        int[][] matrix = new int[n][n];
        int value = 1;
        int minColumn = 0;
        int maxColumn = n - 1;
        int minRow = 0;
        int maxRow = n - 1;

        int offset = 1;
        int offsetCol = 0;

        while (maxColumn > 0) {
            for (int i = minColumn; i <= maxColumn; i++) {
                matrix[minRow][i] = value;
                value++;
            }

            for (int i = minRow + 1; i <= maxRow; i++) {
                matrix[i][maxColumn] = value;
                value++;
            }

            for (int i = maxColumn - 1; i >= minColumn + offsetCol; i--) {
                matrix[maxRow][i] = value;
                value++;
            }

            for (int i = maxRow - 1; i >= minRow + 2; i--) {
                matrix[i][minColumn + offsetCol] = value;
                value++;
            }

            minColumn += offset;
            minRow += 2;

            maxColumn -= 2;
            maxRow -= 2;

            if (offset < 2) {
                offset++;
            }
            if (offsetCol == 0) {
                offsetCol++;
            }

        }
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(ints[j] == 0? "\t" : ints[j] + "\t");
            }
            System.out.println();
        }
    }
}

