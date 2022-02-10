package stage1.TasksPack1.Task5;

import java.sql.SQLOutput;

public class Task5 {
    public static void main(String[] args) {
        String helloString = "Hello Wolrd!";

        for (int i=0; i<helloString.length(); i++)
        {
            char thisChar = helloString.charAt(i);
            System.out.println(thisChar +" "+(int)thisChar );
        }
    }
}
