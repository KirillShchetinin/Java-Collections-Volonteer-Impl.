package ua.yandex.collections;

/**
 *
 * @author Кирилл
 */
public class MyLinkedList implements MyList {

    private static class Node {

        private Object element;
        private Node next;

        Node() {
            next = null;
        }

        Node(Object e) {
            next = null;
            element = e;
        }

        Node(Object e, Node n) {
            element = e;
            next = n;
        }

    }

    private Node begin;
    private int size;

    MyLinkedList() {
        begin = null;
        size = 0;
    }

    private Node getNode(int index) {
        Node it = begin;
        for (int number = index; number > 0; number--) {
            it = it.next;
        }
        return it;
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

    @Override
    public void add(Object e) {
        if (size == 0) {
            begin = new Node(e);
        } else {
            Node end = getNode(size - 1);
            end.next = new Node(e);
        }
        size++;
    }

    @Override
    public void add(int index, Object e) {
        checkBoarderForAdd(index);
        if (index == 0) {
            Node temp = new Node(e, begin);
            begin = temp;
            size++;
        } else {
            Node it = getNode(index - 1);
            if (it.next == null) {
                add(e);
            } else {
                Node temp = new Node(e, it.next);
                it.next = temp;
                size++;
            }
        }
    }

    @Override
    public void addAll(Object[] c) {
        if (c.length == 0) {
            return;
        }
        int from = 0;
        if (size == 0) {
            add(c[from++]);
        }
        Node end = getNode(size - 1);
        for (int i = from; i < c.length; i++) {
            end.next = new Node(c[i]);
            end = end.next;
            size++;
        }
    }

    @Override
    public void addAll(int index, Object[] c) {
        checkBoarderForAdd(index);
        if (c.length == 0) {
            return;
        }
        int from = 0;
        int insertIndex = index;
        if (insertIndex == 0) {
            add(insertIndex++, c[from++]);
        }
        Node it = getNode(insertIndex - 1);
        Node tail = it.next;
        for (int i = from; i < c.length; i++) {
            it.next = new Node(c[i]);
            it = it.next;
            size++;
        }
        it.next = tail;
    }

    @Override
    public Object get(int index) {
        checkBoarder(index);
        Node it = getNode(index);
        return it.element;
    }

    @Override
    public Object remove(int index) {
        checkBoarder(index);

        Object e;
        if (index == 0) {
            e = begin.element;
            begin = begin.next;
        } else {
            Node it = getNode(index - 1);
            e = it.next.element;
            it.next = it.next.next;
        }
        size--;
        return e;
    }

    @Override
    public void set(int index, Object e) {
        checkBoarder(index);
        Node it = getNode(index);
        it.element = e;
    }

    @Override
    public int indexOf(Object o) {
        Node it = begin;
        for (int index = 0; index < size; index++) {
            if ((o == null && it.element == null)
                    || (o != null && it.element.equals(o))) {
                return index;
            }
            it = it.next;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        begin = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] tempList = new Object[size];
        Node it = begin;
        for (int i = 0; i < size; i++) {
            tempList[i] = it.element;
            it = it.next;
        }
        return tempList;
    }

    @Override
    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("[");
        Node it = begin;
        for (int i = 0; i < size; i++) {
            stringBuff.append(it.element.toString());
            it = it.next;
            if (i + 1 < size) {
                stringBuff.append(", ");
            }
        }
        stringBuff.append("]");
        return stringBuff.toString();
    }

    public void addFirst(Object e) {
        begin = new Node(e, begin);
    }

    public void addLast(Object e) {
        add(e);
    }

    public Object getFirst() {
        if (size == 0) {
            throw new IllegalListIndexException("List is empty");
        }
        return begin.element;
    }

    public Object getLast() {
        if (size == 0) {
            throw new IllegalListIndexException("List is empty");
        }
        Node end = getNode(size - 1);
        return end.element;
    }

    public Object removeFirst() {
        return remove(0);
    }

    public Object removeLast() {
        return remove(size - 1);
    }

}
