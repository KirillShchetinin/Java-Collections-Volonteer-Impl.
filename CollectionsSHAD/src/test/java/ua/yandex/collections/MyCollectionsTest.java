package ua.yandex.collections;

import java.util.Comparator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Кирилл
 */
public class MyCollectionsTest {

    public class MyTestComparator implements Comparator {
    
        @Override
        public int compare(Object a, Object b) {
            return (((Comparable) a).compareTo(b));
        }
    }
    
    @Test
    public void testReverseArray() {
        System.out.println("reverseArray");
        Object[] c = {1, 2, "3", 4.0, null};
        MyList list = new MyArrayList();
        list.addAll(c);

        MyCollections.reverse(list);
        Object[] expectedResult = {null, 4.0, "3", 2, 1};
        Object[] actualResult = list.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testReverseLinked() {
        System.out.println("reverseLinked");
        Object[] c = {1, 2, "3", 4.0, null};
        MyList list = new MyLinkedList();
        list.addAll(c);

        MyCollections.reverse(list);
        Object[] expectedResult = {null, 4.0, "3", 2, 1};
        Object[] actualResult = list.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testBinarySearch_MyList_Object() {
        System.out.println("binarySearch");
        MyList list = new MyArrayList();
        Object[] c = {1, 2, 4, 5, 6};
        list.addAll(c);
        Object key = 4;
        int expResult = 2;
        int result = MyCollections.binarySearch(list, key);
        assertEquals(expResult, result);
    }

    @Test
    public void testBinarySearch_MyList_Object_NonFound() {
        System.out.println("binarySearchNonFound");
        MyList list = new MyArrayList();
        Object[] c = {1, 2, 4, 5, 6};
        list.addAll(c);
        Object key = 3;
        int expResult = -3;
        int result = MyCollections.binarySearch(list, key);
        assertEquals(expResult, result);
    }

    @Test
    public void testBinarySearch_MyList_Object_Linked() {
        System.out.println("binarySearchLinked");
        MyList list = new MyLinkedList();
        Object[] c = {1, 2, 4, 5, 6};
        list.addAll(c);
        Object key = 4;
        int expResult = 2;
        int result = MyCollections.binarySearch(list, key);
        assertEquals(expResult, result);
    }

    @Test
    public void testBinarySearch_MyList_Object_NonFound_Linked() {
        System.out.println("binarySearchNonFoundLinked");
        MyList list = new MyLinkedList();
        Object[] c = {1, 2, 4, 5, 6};
        list.addAll(c);
        Object key = 3;
        int expResult = -3;
        int result = MyCollections.binarySearch(list, key);
        assertEquals(expResult, result);
    }

    @Test
    public void testBinarySearch_MyList_Object_NonFound_Linked_Empty() {
        System.out.println("binarySearchNonFoundLinkedEmpty");
        MyList list = new MyLinkedList();

        Object key = 3;
        int expResult = -1;
        int result = MyCollections.binarySearch(list, key);
        assertEquals(expResult, result);
    }

    @Test
    public void testBinarySearch_3args_MyList_Object() {
        System.out.println("binarySearch3args");
        MyList list = new MyArrayList();
        Object[] c = {1, 2, 4, 5, 6};
        list.addAll(c);
        Object key = 4;
        int expResult = 2;
        MyTestComparator cp = new MyTestComparator();
        int result = MyCollections.binarySearch(list, key, cp);
        assertEquals(expResult, result);
    }

    @Test
    public void testBinarySearch_3args_MyList_Object_NonFound() {
        System.out.println("binarySearch3argsNonFound");
        MyList list = new MyArrayList();
        Object[] c = {1, 2, 4, 5, 6};
        list.addAll(c);
        Object key = 3;
        int expResult = -3;
        MyTestComparator cp = new MyTestComparator();
        int result = MyCollections.binarySearch(list, key, cp);
        assertEquals(expResult, result);
    }

    @Test
    public void testBinarySearch_3args_MyList_Object_Linked() {
        System.out.println("binarySearch3argsLinked");
        MyList list = new MyLinkedList();
        Object[] c = {1, 2, 4, 5, 6};
        list.addAll(c);
        Object key = 4;
        int expResult = 2;
        MyTestComparator cp = new MyTestComparator();
        int result = MyCollections.binarySearch(list, key, cp);
        assertEquals(expResult, result);
    }

    @Test
    public void testBinarySearch_3args_MyList_Object_NonFound_Linked() {
        System.out.println("binarySearch3args_NonFoundLinked");
        MyList list = new MyLinkedList();
        Object[] c = {1, 2, 4, 5, 6};
        list.addAll(c);
        Object key = 3;
        int expResult = -3;
        MyTestComparator cp = new MyTestComparator();
        int result = MyCollections.binarySearch(list, key, cp);
        assertEquals(expResult, result);
    }

    @Test
    public void testBinarySearch_3args_MyList_Object_NonFound_Linked_Empty() {
        System.out.println("binarySearchNonFoundLinkedEmpty");
        MyList list = new MyLinkedList();

        Object key = 3;
        int expResult = -1;
        MyTestComparator cp = new MyTestComparator();
        int result = MyCollections.binarySearch(list, key, cp);
        assertEquals(expResult, result);
    }

}
