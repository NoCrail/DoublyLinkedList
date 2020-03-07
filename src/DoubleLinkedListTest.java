import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest {

    @Test
    void clear() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.Add(i);
        }
        list.Clear();
        assertTrue(list.isEmpty());


    }

    @Test
    void count() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.Add(i);
        }
        assertEquals(100, list.Count());
    }

    @Test
    void isEmpty() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.Add(i);
        }
        assertFalse(list.isEmpty());
    }


    @Test
    void add() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        StringBuilder expected = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            list.Add(i);
            expected.append(i).append(" ");
        }
        assertEquals(expected.toString(), list.PrintForward());
    }

    @Test
    void contains() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        boolean actual = true;
        for (int i = 0; i < 100; i++) {
            list.Add(i);
        }
        for (int i = 0; i < 100; i++) {
            if (!list.Contains(i)) {
                actual = false;
            }
        }
        assertTrue(actual);
    }


    @Test
    void indexOf() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        boolean actual = true;
        for (int i = 0; i < 100; i++) {
            list.Add(i);
        }
        for (int i = 0; i < 100; i++) {
            if (list.IndexOf(i) != i) actual = false;
        }
        assertTrue(actual);
    }

    @Test
    void insert() {             //Adding to list with elements
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        boolean actual = true;

        for (int i = 0; i < 10; i++) {
            list.Add(i);
            list.Insert(i,i);
        }

        for (int i = 0; i < 10; i++) {
            if (!list.Contains(i)) actual = false;
        }
        assertTrue( actual);
    }

    @Test
    void insertToEmpty(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        boolean actual;

        list.Insert(1, 1);
        list.Insert(0,0);

        actual=(list.Contains(1)&&list.Contains(0));
        assertTrue( actual);
    }

    @Test
    void insertToBorders(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        boolean actual;
        list.Add(0);
        list.Insert(1,1);
        list.Insert(0, 2);
        actual=(list.Contains(1)&&list.Contains(2));
        assertTrue( actual);
    }


    @Test
    void remove() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        boolean actual = true;
        for (int i = 0; i < 100; i++) {
            list.Add(i);
        }
        for (int i = 0; i < 101; i++) {
            list.Remove(i);
            if (list.Contains(i)) actual = false;
        }
        assertTrue( actual);
    }

    @Test
    void removeAt() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.Add(i);
        }
        for (int i = 0; i < 101; i++) {
            list.RemoveAt(0);
        }
        assertTrue(list.isEmpty());
    }
}