import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest {

    @Test
    void clear() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        list.clear();
        assertTrue(list.isEmpty());


    }

    @Test
    void count() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        assertEquals(100, list.count());
    }

    @Test
    void isEmpty() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        assertFalse(list.isEmpty());
    }


    @Test
    void add() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        StringBuilder expected = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            list.add(i);
            expected.append(i).append(" ");
        }
        assertEquals(expected.toString(), list.printForward());
    }

    @Test
    void contains() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        boolean actual = true;
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        for (int i = 0; i < 100; i++) {
            if (!list.contains(i)) {
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
            list.add(i);
        }
        for (int i = 0; i < 100; i++) {
            if (list.indexOf(i) != i) actual = false;
        }
        assertTrue(actual);
    }

    @Test
    void insert() {             //Adding to list with elements
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        boolean actual = true;

        for (int i = 0; i < 10; i++) {
            list.add(i);
            list.insert(i, i);
        }

        for (int i = 0; i < 10; i++) {
            if (!list.contains(i)) actual = false;
        }
        assertTrue(actual);
    }

    @Test
    void insertToEmpty() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        boolean actual;

        list.insert(1, 1);
        list.insert(0, 0);

        actual = (list.contains(1) && list.contains(0));
        assertTrue(actual);
    }

    @Test
    void insertToBorders() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        boolean actual;
        list.add(0);
        list.insert(1, 1);
        list.insert(0, 2);
        actual = (list.contains(1) && list.contains(2));
        assertTrue(actual);
    }


    @Test
    void remove() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        boolean actual = true;
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        for (int i = 0; i < 100; i++) {
            list.remove(i);
            if (list.contains(i)) actual = false;
        }
        assertTrue(actual);
    }

    @Test
    void removeAt() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        for (int i = 0; i < 100; i++) {
            list.removeAt(0);
        }
        assertTrue(list.isEmpty());
    }
}