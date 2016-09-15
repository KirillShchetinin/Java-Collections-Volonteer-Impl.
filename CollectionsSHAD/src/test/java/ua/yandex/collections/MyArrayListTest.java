/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.yandex.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Кирилл
 */
public class MyArrayListTest {

    @Test
    public void testMyArrayList() {
        System.out.println("Constructor");
        MyArrayList instance = new MyArrayList();
        int expectedResult = 0;
        int actualResult = instance.size();
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testMyArrayListNonEmptyConstructor() {
        System.out.println("NonEmptyConstructor");
        int initialCapacity = 5;
        MyArrayList instance = new MyArrayList(initialCapacity);
        int expectedResult = 0;
        int actualResult = instance.size();
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testAdd_Object() {
        System.out.println("add");
        Object e = null;
        MyArrayList instance = new MyArrayList();
        instance.add(e);
        Object[] expectedResult = {e};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testAdd_Object2() {
        System.out.println("add2");
        Object e = null;
        MyArrayList instance = new MyArrayList(1);
        instance.add(e);
        instance.add(0);
        Object[] expectedResult = {e, 0};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testAdd_int_Object() {
        System.out.println("addIndex");
        int index = 1;
        Object e = null;
        MyArrayList instance = new MyArrayList();
        instance.add(0);
        instance.add(1);
        instance.add(index, 2);
        Object[] expectedResult = {0, 2, 1};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test(expected = IllegalListIndexException.class)
    public void testAdd_int_Object_Error() {
        System.out.println("addIndexError");
        int index = 3;
        MyArrayList instance = new MyArrayList();
        instance.add(0);
        instance.add(1);
        instance.add(index, 2);
    }

    @Test
    public void testAddAll_ObjectArr() {
        System.out.println("addAll");
        Object[] c = {null, 2, 3};
        MyArrayList instance = new MyArrayList(3);
        instance.add(1);
        instance.addAll(c);
        Object[] expectedResult = {1, null, 2, 3};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult , actualResult);
    }

    @Test
    public void testAddAll_int_ObjectArr() {
        System.out.println("addAllIndex");
        int index = 1;
        Object[] c = {1, 2, 3, 4};
        MyArrayList instance = new MyArrayList(4);
        instance.add(null);
        instance.add(null);
        instance.addAll(index, c);
        Object[] expectedResult = {null, 1, 2, 3, 4, null};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testGet() {
        System.out.println("get");
        int index = 3;
        Object[] c = {0, 1, 2, 3, 4, 5};
        MyArrayList instance = new MyArrayList();
        instance.addAll(c);
        Object expectedResult = 3;
        Object actualResult = instance.get(index);
        assertEquals(expectedResult, actualResult);
    }

    @Test(expected = IllegalListIndexException.class)
    public void testGetError() {
        System.out.println("getError");
        int index = 6;
        Object[] c = {0, 1, 2, 3, 4, 5};
        MyArrayList instance = new MyArrayList();
        instance.addAll(c);
        Object expectedResult = 3;
        Object actualResult = instance.get(index);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testRemove() {
        System.out.println("remove");
        int index = 3;
        Object[] c = {0, 1, 2, 3, 4, 5};
        MyArrayList instance = new MyArrayList();
        instance.addAll(c);
        Object expectedResult = 3;
        Object actualResult = instance.remove(index);
        Object[] expectedArray = {0, 1, 2, 4, 5};
        Object[] actualArray = instance.toArray();
        assertEquals(expectedResult, actualResult);
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testSet() {
        System.out.println("set");
        int index = 3;
        Object e = null;
        Object[] c = {0, 1, 2, 3, 4, 5};
        MyArrayList instance = new MyArrayList();
        instance.addAll(c);
        instance.set(index, e);
        Object[] expectedResult = {0, 1, 2, null, 4, 5};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testIndexOf() {
        System.out.println("indexOf");
        Object e = 4;
        Object[] c = {0, 1, 2, 4, 5, 6};
        MyArrayList instance = new MyArrayList();
        instance.addAll(c);
        Object expectedResult = 3;
        Object actualResult = instance.indexOf(e);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testIndexOf2() {
        System.out.println("indexOf2");
        Object e = 3;
        Object[] c = {0, 1, 2, 4, 5, 6};
        MyArrayList instance = new MyArrayList();
        instance.addAll(c);
        Object expectedResult = -1;
        Object actualResult = instance.indexOf(e);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSize() {
        System.out.println("size");
        MyArrayList instance = new MyArrayList(5);
        Object[] c = {0, 1, 2, 4, 5, 6, null};
        instance.addAll(c);
        int expResult = 7;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    @Test
    public void testClear() {
        System.out.println("clear");
        MyArrayList instance = new MyArrayList();
        Object[] c = {0, 1, 2, 4, 5, 6};
        instance.addAll(c);
        instance.clear();
        Object[] expResult = {};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        MyArrayList instance = new MyArrayList();
        instance.add(null);
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsEmpty2() {
        System.out.println("isEmpty2");
        MyArrayList instance = new MyArrayList();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    @Test
    public void testToArray() {
        System.out.println("toArray");
        MyArrayList instance = new MyArrayList(2);
        instance.add(0);
        Object[] expResult = {0};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        MyArrayList instance = new MyArrayList(2);
        Object[] c = {1, "2", 3.0};
        instance.addAll(c);
        String expectedResult = "[1, 2, 3.0]";
        String actualResult = instance.toString();
        assertEquals(expectedResult, actualResult);
    }
}