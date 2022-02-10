package stage1.TasksPack1.Task2;

public class Task2 {
    public static void main(String[] args) {
        int num1 = 20;
        float num2 = 10.5F;
        String sum = String.format("Сумма %f", num1 + num2);
        String diff = String.format("Разность %f", num1 - num2);
        String mult = String.format("Произведение %f", num1 * num2);
        String div = String.format("Частное %f", num1 / num2);


        System.out.println(sum+'\n'+diff+'\n'+mult+'\n'+div);

    }
}
