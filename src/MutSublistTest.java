import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MutSublistTest {


    @Test
    void count() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        DoubleLinkedList<Integer> mlist = list.createMutableSublist(0,99);
        assertEquals(100, mlist.count());
    }

    @Test
    void contains() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        //MutableSublist<Integer> mlist = new MutableSublist<>(list, 0, 99);
        DoubleLinkedList<Integer> mlist = list.createMutableSublist(0,99);
        boolean actual = true;
        for (int i = 0; i < 100; i++) {
            if (!mlist.contains(i)) {
                actual = false;
            }
        }
        assertTrue(actual);
    }

    @Test
    void indexOf() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        DoubleLinkedList<Integer> mlist = list.createMutableSublist(0,9);

        assertEquals(list.indexOf(0), mlist.indexOf(0));
    }

    @Test
    void clear() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        DoubleLinkedList<Integer> mlist = list.createMutableSublist(0,0);
        mlist.clear();
        boolean actual = true;
        for (int i = 1; i < 10; i++) {
            if(!list.contains(i)){
                actual=false;
            };
        }
        assertTrue(actual);
    }

    @Test
    void add() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        DoubleLinkedList<Integer> mlist = list.createMutableSublist(0,99);

        mlist.add(-5);
        assertEquals(mlist.contains(-5), list.contains(-5));
    }

    @Test
    void insert() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        DoubleLinkedList<Integer> mlist = list.createMutableSublist(0,9);
        mlist.insert(2, -5);
        assertEquals(mlist.contains(-5), mlist.indexOf(-5) == 2);

    }

    @Test
    void removeAt() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);

        }
        DoubleLinkedList<Integer> mlist = list.createMutableSublist(0,9);
        mlist.removeAt(1);
        assertEquals(mlist.contains(1), list.contains(1));

    }

    @Test
    void remove() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);

        }
        boolean actual = true;
        DoubleLinkedList<Integer> mlist = list.createMutableSublist(0,9);
        for (int i = 0; i < 10; i++) {
            mlist.remove(i);
            if (mlist.contains(i)) {
                actual = false;
            }
        }
        assertTrue(actual);
    }
}
