package stage1.TasksPack1.Task3;

public class Task3 {
    public static void main(String[] args) {
        boolean bool1 = true;
        boolean bool2 = false;

        boolean inverse = !bool1; // логическое не (отрицание)
        boolean bitwiseAnd = bool1 & bool2; //побитовое И
        boolean logicalAnd = bool1 && bool2; //логическое И
        boolean bitwiseOr= bool1 | bool2; //побитовое ИЛИ
        boolean logicalOr = bool1 || bool2; //логическое ИЛИ
        boolean xor = bool1 ^ bool2; //исключающее ИЛИ

        System.out.println("Отрицание " + "!"+ bool1 + "=" + inverse);
        System.out.println("Побитовый И " + bool1 + "&"+ bool2 + "=" +bitwiseAnd);
        System.out.println("Логическое И " + bool1 + "&&"+ bool2 + "=" +logicalAnd);
        System.out.println("Побитовое ИЛИ " + bool1 + "|"+ bool2 + "=" +bitwiseOr);
        System.out.println("Логическое ИЛИ " + bool1 + "||"+ bool2 + "=" +logicalOr);
        System.out.println("Исключающее ИЛИ " + bool1 +" ^ "+ bool2 + "=" + xor);

    }
}
