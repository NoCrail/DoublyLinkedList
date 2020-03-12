import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MutableSublistTest {

    @Test
    void count() {

    }

    @Test
    void isEmpty() {
    }

    @Test
    void contains() {
    }


    @Test
    void indexOf() {
    }

    @Test
    void clear() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        MutableSublist<Integer> mlist = new MutableSublist<>(list, 0,99);
        mlist.clear();
        assertEquals(mlist.isEmpty(), list.isEmpty());
    }

    @Test
    void add() {
    }

    @Test
    void insert() {
    }

    @Test
    void removeAt() {
    }

    @Test
    void remove() {
    }
}