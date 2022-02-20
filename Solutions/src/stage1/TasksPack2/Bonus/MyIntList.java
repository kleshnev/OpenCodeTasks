package stage1.TasksPack2.Bonus;

public class MyIntList {
    private int[] array = new int[0];

    public int getLength() {
        return array.length;
    }


    public void add(int num) {
        expandArray();
        array[array.length - 1] = num;
    }

    /* Элемент вставляется по индексу(pos), и все элементы после номера pos двигаются вправо.
     *  insert можно применить для вставки в конец, для этого номер позиции должен быть array.length+1
     *  Индексация идет уже у расширенного массива, а не исходного, поэтому IndexOutOfBounds не будет.
     *  Вставка в середину:
     *  Для четного исходного массива - pos = array.length/2
     *  Для нечетного - (array.length+1)/2 -1
     */
    public void insert(int element, int pos) {
        if (pos > array.length + 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        expandArray();
        if (array.length - 1 - pos >= 0)
            System.arraycopy(array, pos, array, pos + 1, array.length - 1 - pos);
        array[pos] = element;
    }


    public void remove(int removedIdx) {
        System.arraycopy(array, 0, array, 0, removedIdx);
        System.arraycopy(array, removedIdx + 1, array, removedIdx, array.length - 1 - removedIdx);
        decreaseArray();
    }

    public void clear() {
        array = new int[0];
    }

    public boolean compareTo(MyIntList myList) {
        if (array.length != myList.array.length) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != myList.array[i]) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        int listSize = array.length;
        for (int i = 0; i < listSize; i++) {
            builder.append(array[i]);
            if (i != listSize - 1)
                builder.append(" ");
        }
        return builder.toString();
    }

    public void sort() {
        /* Сортировка выбором */
        for (int i = 0; i < array.length; i++) {

            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
    }

    private void expandArray() {
        int[] tempArray = new int[array.length + 1];
        System.arraycopy(array, 0, tempArray, 0, array.length);
        array = tempArray;
    }

    private void decreaseArray() {
        if (array.length == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int[] tempArray = new int[array.length - 1];
        System.arraycopy(array, 0, tempArray, 0, tempArray.length);
        array = tempArray;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] newArray) {
        array = newArray;
    }
}
