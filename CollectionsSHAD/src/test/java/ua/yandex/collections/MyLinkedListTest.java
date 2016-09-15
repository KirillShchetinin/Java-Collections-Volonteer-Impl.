package ua.yandex.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Кирилл
 */
public class MyLinkedListTest {

    @Test
    public void testAdd_Object() {
        System.out.println("add");
        Object e = 1;
        MyLinkedList instance = new MyLinkedList();
        instance.add(e);
        Object[] expectedResult = {1};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);

        instance.add(null);
        instance.add(2);
        expectedResult = new Object[]{1, null, 2};
        actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testAdd_int_Object() {
        System.out.println("add");
        int index = 1;
        Object e = "22";
        MyLinkedList instance = new MyLinkedList();
        instance.add(1);
        instance.add(2);
        instance.add(index, e);
        Object[] expectedResult = {1, "22", 2};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test(expected = IllegalListIndexException.class)
    public void testAdd_int_ObjectError() {
        System.out.println("addError");
        int index = 4;
        Object e = "22";
        MyLinkedList instance = new MyLinkedList();
        instance.add(1);
        instance.add(2);
        instance.add(index, e);
        Object[] expectedResult = {1, "22", 2};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddAll_ObjectArr() {
        System.out.println("addAll");
        Object[] c = {2, "3", 4.0};
        MyLinkedList instance = new MyLinkedList();
        instance.addAll(c);
        Object[] expectedResult = c;
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddAll_int_ObjectArr() {
        System.out.println("addAll");
        int index = 1;
        Object[] c = {2, "3", 4.0};
        MyLinkedList instance = new MyLinkedList();
        instance.add(0);
        instance.add(null);
        instance.addAll(index, c);
        Object[] expectedResult = {0, 2, "3", 4.0, null};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testGet() {
        System.out.println("get");
        int index = 2;
        MyLinkedList instance = new MyLinkedList();
        Object[] c = {2, "3", 4.0};
        instance.addAll(c);
        Object expectedResult = 4.0;
        Object actualResult = instance.get(index);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testRemove() {
        System.out.println("remove");
        int index = 0;
        MyLinkedList instance = new MyLinkedList();
        instance.add(1);

        Object expResult = 1;
        Object result = instance.remove(index);
        assertEquals(expResult, result);
        assertEquals(0, instance.size());

        Object[] c = {null, 2, "13"};
        instance.addAll(c);
        index = 1;
        expResult = 2;
        result = instance.remove(index);
        assertEquals(expResult, result);
        assertEquals(2, instance.size());
    }

    @Test
    public void testRemove3() {
        System.out.println("remove3");
        int index = 0;
        MyLinkedList instance = new MyLinkedList();
        instance.add(1);

        Object expResult = 1;
        Object result = instance.remove(index);

        Object[] c = {null, 2, "13", 5};
        instance.addAll(c);
        index = 2;
        expResult = "13";
        result = instance.remove(index);
        assertEquals(expResult, result);
        assertEquals(3, instance.size());
    }

    @Test(expected = IllegalListIndexException.class)
    public void testRemove2() {
        System.out.println("remove2");
        int index = 1;
        MyLinkedList instance = new MyLinkedList();
        instance.add(1);

        Object expResult = 1;
        Object result = instance.remove(index);
    }

    @Test
    public void testSet() {
        System.out.println("set");
        int index = 2;
        Object[] c = {1, 2, 3, 4};
        Object e = 5;
        MyLinkedList instance = new MyLinkedList();
        instance.addAll(c);
        instance.set(index, e);
        Object[] expectedResult = {1, 2, 5, 4};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testIndexOf() {
        System.out.println("indexOf");
        Object[] c = {1, 2, 3, 4};
        Object e = 5;
        MyLinkedList instance = new MyLinkedList();
        instance.addAll(c);
        Object expectedResult = -1;
        Object actualResult = instance.indexOf(e);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testIndexOf2() {
        System.out.println("indexOf2");
        Object[] c = {1, 2, 3, 4};
        Object e = 2;
        MyLinkedList instance = new MyLinkedList();
        instance.addAll(c);
        Object expectedResult = 1;
        Object actualResult = instance.indexOf(e);
        assertEquals(expectedResult, actualResult);
    }
    
    @Test
    public void testSize() {
        System.out.println("size");
        Object[] c = {1, 2, 3, 4};
        MyLinkedList instance = new MyLinkedList();
        instance.addAll(0, c);
        int expResult = 4;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    @Test
    public void testClear() {
        System.out.println("clear");
        Object[] c = {1, 2, 3, 4};
        MyLinkedList instance = new MyLinkedList();
        instance.addAll(0, c);
        instance.clear();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        Object[] expectedResult = {};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        MyLinkedList instance = new MyLinkedList();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);

    }

    @Test
    public void testIsEmpty2() {
        System.out.println("isEmpty2");
        MyLinkedList instance = new MyLinkedList();
        Object[] c = {1, 2, "3", null, 4.0};
        instance.addAll(c);
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);

    }

    @Test
    public void testToArray() {
        System.out.println("toArray");
        MyLinkedList instance = new MyLinkedList();
        instance.add(null);
        Object[] expResult = {null};
        Object[] result = instance.toArray();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testAddFirst() {
        System.out.println("addFirst");
        Object e = null;
        MyLinkedList instance = new MyLinkedList();
        instance.add(1);
        instance.addFirst(e);
        Object[] expectedResult = {null, 1};
        Object[] actualResult = instance.toArray();
    }

    @Test
    public void testAddLast() {
        System.out.println("addLast");
        Object e = null;
        MyLinkedList instance = new MyLinkedList();
        instance.add(1);
        instance.addLast(e);
        Object[] expectedResult = {1, null};
        Object[] actualResult = instance.toArray();
    }

    @Test
    public void testGetFirst() {
        System.out.println("getFirst");
        MyLinkedList instance = new MyLinkedList();
        Object[] c = {1, 2, "3", null, 4.0};
        instance.addAll(c);

        Object expResult = 1;
        Object result = instance.getFirst();
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalListIndexException.class)
    public void testGetFirstError() {
        System.out.println("getFirstError");
        MyLinkedList instance = new MyLinkedList();
        Object[] c = {1, 2, "3", null, 4.0};
        //instance.addAll(c);

        Object expResult = 1;
        Object result = instance.getFirst();
    }

    @Test
    public void testGetLast() {
        System.out.println("getLast");
        MyLinkedList instance = new MyLinkedList();
        Object[] c = {1, 2, "3", null, 4.0};
        instance.addAll(c);

        Object expResult = 4.0;
        Object result = instance.getLast();
        assertEquals(expResult, result);
    }

    @Test
    public void testRemoveFirst() {
        System.out.println("removeFirst");
        MyLinkedList instance = new MyLinkedList();
        instance.add(null);
        Object expResult = null;
        Object result = instance.removeFirst();
        assertEquals(expResult, result);
        assertEquals(0, instance.size());
    }

    @Test
    public void testRemoveLast() {
        System.out.println("removeLast");
        MyLinkedList instance = new MyLinkedList();
        instance.add(null);
        Object expResult = null;
        Object result = instance.removeLast();
        assertEquals(expResult, result);
        assertEquals(0, instance.size());
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        MyLinkedList instance = new MyLinkedList();
        Object[] c = {1, "2", 3.0};
        instance.addAll(c);
        String expectedResult = "[1, 2, 3.0]";
        String actualResult = instance.toString();
        assertEquals(expectedResult, actualResult);
    }
}
