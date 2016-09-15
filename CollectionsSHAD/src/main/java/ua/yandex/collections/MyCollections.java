package ua.yandex.collections;

import java.util.Comparator;

public class MyCollections {

    // Reverses the order of the elements in the specified list
    public static void reverse(MyList list) {
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            Object firstToSwap = list.get(i);
            Object secondToSwap = list.get(j);
            list.set(i, secondToSwap);
            list.set(j, firstToSwap);
        }
    }

    //Реализует рекурсивный поиск в отсортированном массиве методом бисекции.
    public static int binarySearch(MyList list, Object key) {
        if (list.isEmpty()) {
            return -1;
        }

        int index = binarySearch(list, key, 0, list.size() - 1);

        if (index < list.size()
                && ((Comparable) list.get(index)).compareTo(key) == 0) {
            return index;
        }
        return -index - 1;
    }

    private static int binarySearch(MyList list, Object key,
            int low, int high) {
        if (high - low <= 1) {
            int index = low;
            if (((Comparable) list.get(index)).compareTo(key) < 0) {
                index++;
            }
            return index;
        }
        int middle = (low + high) >> 1;
        int lessThan = ((Comparable) list.get(middle)).compareTo(key);
        if (lessThan < 0) {
            return binarySearch(list, key, middle, high);
        } else {
            return binarySearch(list, key, low, middle);
        }
    }

    //Реализует рекурсивный поиск в отсортированном массиве методом бисекции.
    public static int binarySearch(MyList list, Object key, Comparator cp) {
        if (list.isEmpty()) {
            return -1;
        }

        int index = binarySearch(list, key, cp, 0, list.size() - 1);

        if (index < list.size() && cp.compare(list.get(index), key) == 0) {
            return index;
        }
        return -index - 1;
    }

    private static int binarySearch(MyList list, Object key,
            Comparator cp, int low, int high) {
        if (high - low <= 1) {
            int index = low;
            if (cp.compare(list.get(index), key) < 0) {
                index++;
            }
            return index;
        }
        int middle = (low + high) >> 1;
        int lessThan = cp.compare(list.get(middle), key);
        if (lessThan < 0) {
            return binarySearch(list, key, cp, middle, high);
        } else {
            return binarySearch(list, key, cp, low, middle);
        }
    }
}
