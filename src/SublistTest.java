import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SublistTest {

    @Test
    void count() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        IListReadOnly<Integer> slist = list.createSublist(0, 99);
        assertEquals(100, slist.count());
    }

    @Test
    void isEmpty() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        IListReadOnly<Integer> slist = list.createSublist(0, 99);
        assertFalse(slist.isEmpty());
    }

    @Test
    void contains() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        IListReadOnly<Integer> slist = list.createSublist(0, 9);
        boolean actual = true;
        for (int i = 0; i < 10; i++) {
            if (!slist.contains(i)) {
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
        IListReadOnly<Integer> slist = list.createSublist(0, 99);
        for (int i = 0; i < 100; i++) {
            if (slist.lastIndexOf(i) != i) actual = false;
        }
        assertTrue(actual);
    }
}