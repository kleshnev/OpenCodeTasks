package stage1.TasksPack2.Bonus.Tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import stage1.TasksPack2.Bonus.MyIntList;

import java.util.Arrays;

public class SortTests extends Assert {

    @Test
    @DisplayName("Should sort positive sequences")
    public void sortPositiveSequence() {
        MyIntList myList = new MyIntList();
        int[] testArray = new int[]{10, 7, 5, 3, 2, 1, 100};
        myList.array = Arrays.stream(testArray).toArray();
        myList.sort();
        assertArrayEquals(new int[]{1, 2, 3, 5, 7, 10, 100}, myList.array);
    }

    @Test
    @DisplayName("Should sort negative sequences")
    public void sortNegativeSequence() {
        MyIntList myList = new MyIntList();
        int[] testArray = new int[]{-10, -7, -5, -3, -2, -1, -100};
        myList.array = Arrays.stream(testArray).toArray();
        myList.sort();
        assertArrayEquals(new int[]{-100, -10, -7, -5, -3, -2, -1}, myList.array);
    }
    @Test
    @DisplayName("Should sort sequences with repeated nums")
    public void sortRepeatedNumbers() {
        MyIntList myList = new MyIntList();
        int[] testArray = new int[]{2, 1, 1, 1, 1, 100, 1};
        myList.array = Arrays.stream(testArray).toArray();
        myList.sort();
        assertArrayEquals(new int[]{1, 1, 1, 1, 1, 2, 100}, myList.array);
    }

}