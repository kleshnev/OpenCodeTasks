package stage1.TasksPack2.Bonus.Tests;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import stage1.TasksPack2.Bonus.MyIntList;

import java.util.Arrays;

public class MyListTests extends Assert {

    @Nested
    class SortTests extends Assert {
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
        @DisplayName("Should sort sequences with repeated numbers")
        public void sortRepeatedNumbers() {
            MyIntList myList = new MyIntList();
            int[] testArray = new int[]{2, 1, 1, 1, 1, 100, 1};
            myList.array = Arrays.stream(testArray).toArray();
            myList.sort();
            assertArrayEquals(new int[]{1, 1, 1, 1, 1, 2, 100}, myList.array);
        }
    }

    @Nested
    class AddTests extends Assert {
        @Test
        @DisplayName("Should add elements")
        public void addNumbersToList() {
            MyIntList myList = new MyIntList();
            myList.add(1);
            myList.add(2);
            myList.add(3);
            assertArrayEquals(new int[]{1, 2, 3}, myList.array);
        }
    }

    @Nested
    class RemoveTests extends Assert {
        @Test
        @DisplayName("Should remove specified element")
        public void removeNumbersFromList() {
            MyIntList myList = new MyIntList();
            int[] testArray = new int[]{1, 2, 3, 4, 5};
            myList.array = Arrays.stream(testArray).toArray();
            myList.remove(3);
            assertArrayEquals(new int[]{1, 2, 3, 5}, myList.array);
        }
    }

    @Nested
    class InsertTests extends Assert {
        @Test
        @DisplayName("Should insert to the MIDDLE of the given array")
        public void insertElementToMiddleOfArray() {
            MyIntList myList = new MyIntList();
            int[] testArray = new int[]{1, 2, 3, 4, 5, 6};
            myList.array = Arrays.stream(testArray).toArray();
            myList.insert(999, 3);
            assertArrayEquals(new int[]{1, 2, 3, 999, 4, 5, 6}, myList.array);
        }

        @Test
        @DisplayName("Should insert to the START of the given array")
        public void insertElementToStartOfArray() {
            MyIntList myList = new MyIntList();
            int[] testArray = new int[]{1, 2, 3, 4, 5, 6};
            myList.array = Arrays.stream(testArray).toArray();
            myList.insert(999, 0);
            assertArrayEquals(new int[]{999, 1, 2, 3, 4, 5, 6}, myList.array);
        }

        @Test
        @DisplayName("Should insert to the END of the given array")
        public void insertElementToEndOfArray() {
            MyIntList myList = new MyIntList();
            int[] testArray = new int[]{1, 2, 3, 4, 5, 6};
            myList.array = Arrays.stream(testArray).toArray();
            myList.insert(999, myList.array.length);
            assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 999}, myList.array);
        }
    }

    @Nested
    class ClearTests extends Assert {
        @Test
        @DisplayName("Array should be empty after clear() is called")
        public void clearArrayShouldBeEmpty() {
            MyIntList myList = new MyIntList();
            int[] testArray = new int[]{1, 2, 3};
            myList.array = Arrays.stream(testArray).toArray();
            myList.clear();
            assertArrayEquals(new int[]{}, myList.array);
        }
    }

    @Nested
    class CompareTests extends Assert {
        @Test
        @DisplayName("Different arrays should return FALSE")
        public void differentArraysReturnFalse() {
            MyIntList myList = new MyIntList();
            MyIntList myList2 = new MyIntList();
            myList.add(2);
            myList.add(1);

            myList2.add(1);
            myList2.add(2);
            assertFalse(myList.compareTo(myList2));
        }

        @Test
        @DisplayName("Identical arrays should return TRUE")
        public void identicalArraysReturnTrue() {
            MyIntList myList = new MyIntList();
            MyIntList myList2 = new MyIntList();
            myList.add(1);
            myList.add(2);
            myList2.add(1);
            myList2.add(2);
            assertTrue(myList.compareTo(myList2));
        }
    }

    @Nested
    class ToStringTests extends Assert {
        @Test
        @DisplayName("Empty list should return empty string")
        public void emptyListToStringPrintsEmptyLine() {
            MyIntList myList = new MyIntList();
            assertEquals("", myList.toString());
        }

        @Test
        @DisplayName("List should return string of elements with space" +
                " delimiters without space char at the end.")
        public void listToStringPrintsCorrectLine() {
            MyIntList myList = new MyIntList();
            myList.add(1);
            myList.add(2);
            myList.add(3);
            assertEquals("1 2 3", myList.toString());
        }

    }
}