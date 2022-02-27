package stage1.TasksPack3.Task1;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите нечетное значение размера матрицы (нечетное):");

        int size = in.nextInt();
        while (size % 2 == 0) {
            System.out.println("Введите нечетное значение!");
            size = in.nextInt();
        }

        Matrix matrixCross = new Matrix(size);
        System.out.println("\nКрест");
        matrixCross.drawCross();

        Matrix matrixPlus = new Matrix(size);
        System.out.println("\nЗнак плюс");
        matrixPlus.drawPlusSign();

        Matrix matrixSquare = new Matrix(size);
        System.out.println("\nКвадрат");
        matrixSquare.drawSquare();

        Matrix matrixDiamond = new Matrix(size);
        System.out.println("\nРомб");
        matrixDiamond.drawDiamond();

    }

}

class Matrix {
    private final int[][] matrix;

    public Matrix(int size) {
        matrix = new int[size][size];
    }

    public void drawCross() {
        int column = matrix.length;
        int row = matrix[0].length;
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                matrix[i][i] = 1;
                matrix[i][column - 1 - i] = 1;
            }
        }
        print();
    }

    public void drawSquare() {
        int column = matrix.length;
        int row = matrix[0].length;
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                if (i == 0 || i == column - 1) {
                    matrix[i][j] = 1;
                } else if (j == 0 || j == row - 1) {
                    matrix[i][j] = 1;
                }
            }
        }
        print();
    }

    public void drawPlusSign() {
        int column = matrix.length;
        int row = matrix[0].length;
        int mid = matrix.length / 2;
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                if (i == mid) {
                    matrix[i][j] = 1;
                }
                if (j == mid) {
                    matrix[i][j] = 1;
                }
            }
        }
        print();
    }

    public void drawDiamond() {
        int column = matrix.length;
        int row = matrix[0].length;
        int mid = matrix.length / 2;
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                if (j == mid) {
                    if (i <= mid) {
                        matrix[i][mid + i] = 1;
                        matrix[i][mid - i] = 1;
                    }
                }
                if (i > mid) {
                    matrix[i][j] = matrix[row - 1 - i][j];
                }
            }
        }
        print();
    }


    public void print() {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}

