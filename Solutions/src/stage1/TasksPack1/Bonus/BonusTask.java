package stage1.TasksPack1.Bonus;

public class BonusTask {
    public static void main(String[] args) {

        boolean res = hasOnlyTwoTrue(true, false, true, false);
        System.out.println(res);
    }

    public static boolean hasOnlyTwoTrue(boolean a1, boolean a2, boolean a3, boolean a4) {
        return a1 ^ a2 && a3 ^ a4 || a1 ^ a3 && a2 ^ a4;
    }

}

