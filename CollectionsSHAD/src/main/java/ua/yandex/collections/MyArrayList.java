package ua.yandex.collections;

/**
 *
 * @author Кирилл
 */
public class MyArrayList implements MyList {

    private static final int DEFAULT_CAPACITY = 10;
    private static final int INCREASE_CAPACITY = 1;

    private Object[] arrayList;
    private int size;

    public MyArrayList() {
        arrayList = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyArrayList(int initialCapacity) {
        arrayList = new Object[initialCapacity];
        size = 0;
    }

    public void ensureCapacity(int newCapacity) {
        assert size <= arrayList.length;

        Object[] tempList = new Object[arrayList.length];
        System.arraycopy(arrayList, 0, tempList, 0, size);
        arrayList = new Object[newCapacity];
        System.arraycopy(tempList, 0, arrayList, 0, size);
    }

    private void checkBoarderForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IllegalListIndexException(
                    "index does not belong to [0,size]");
        }
    }

    private void checkBoarder(int index) {
        checkBoarderForAdd(index);
        if (index == size) {
            throw new IllegalListIndexException(
                    "index does not belong to [0,size-1]");
        }
    }

    private int getIncreaseCoef(int expectedLength) {
        int increase = 0;
        while (expectedLength >= arrayList.length << increase) {
            increase++;
        }
        return increase;
    }

    @Override
    public void add(Object e) {
        if (size >= arrayList.length) {
            ensureCapacity(arrayList.length << INCREASE_CAPACITY);
        }
        arrayList[size++] = e;
    }

    @Override
    public void add(int index, Object e) {
        // index must belong to [0,size]. "index = size" -
        //means you push element into tail of the array
        checkBoarderForAdd(index);

        if (size >= arrayList.length) {
            ensureCapacity(arrayList.length << INCREASE_CAPACITY);
        }
        for (int i = size; i > index; i--) {
            arrayList[i] = arrayList[i - 1];
        }
        arrayList[index] = e;
        size++;
    }

    @Override
    public void addAll(Object[] c) {
        int increase = getIncreaseCoef(size + c.length);
        if (increase > 0) {
            ensureCapacity(arrayList.length << increase);
        }
        System.arraycopy(c, 0, arrayList, size, c.length);
        size += c.length;
    }

    @Override
    public void addAll(int index, Object[] c) {
        checkBoarderForAdd(index);
        int increase = getIncreaseCoef(size + c.length);
        if (increase > 0) {
            ensureCapacity(arrayList.length << increase);
        }
        for (int i = size - 1; i >= index; i--) {
            arrayList[i + c.length] = arrayList[i];
        }
        int number = index;
        for (Object e : c) {
            arrayList[number++] = e;
        }
        size += c.length;
    }

    @Override
    public Object get(int index) {
        checkBoarder(index);
        return arrayList[index];
    }

    @Override
    public Object remove(int index) {
        checkBoarder(index);

        Object result = get(index);
        for (int i = index; i < size; i++) {
            arrayList[i] = arrayList[i + 1];
        }
        size--;
        if ((size << INCREASE_CAPACITY) <= arrayList.length
                && arrayList.length > DEFAULT_CAPACITY) {
            ensureCapacity(Math.min(DEFAULT_CAPACITY, arrayList.length >> 1));
        }
        return result;
    }

    @Override
    public void set(int index, Object e) {
        checkBoarder(index);
        arrayList[index] = e;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if ((o == null && arrayList[i] == null)
                    || (o != null && arrayList[i].equals(o))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        arrayList = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] tempList = new Object[size];
        System.arraycopy(arrayList, 0, tempList, 0, size);
        return tempList;
    }

    @Override
    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append('[');
        for (int i = 0; i < size; i++) {
            stringBuff.append(arrayList[i].toString());
            if (i + 1 < size) {
                stringBuff.append(", ");
            }
        }
        stringBuff.append(']');
        return stringBuff.toString();
    }

}
