import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MutSublistTest {


    @Test
    void count() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        IList<Integer> mlist = list.createMutableSublist(0,99);
        assertEquals(100, mlist.count());
    }

    @Test
    void wrongBoundsTest() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        //DoubleLinkedList<Integer> mlist = list.createMutableSublist(-1,110);
        assertThrows( IndexOutOfBoundsException.class, () -> list.createMutableSublist(-1,110));
    }

    @Test
    void contains() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        //MutableSublist<Integer> mlist = new MutableSublist<>(list, 0, 99);
        IList<Integer> mlist = list.createMutableSublist(0,99);
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

        IList<Integer> mlist = list.createMutableSublist(0,9);

        assertEquals(list.lastIndexOf(0), mlist.lastIndexOf(0));
    }

    @Test
    void clear() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        IList<Integer> mlist = list.createMutableSublist(0,0);
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
        IList<Integer> mlist = list.createMutableSublist(0,99);

        mlist.add(-5);
        assertEquals(mlist.contains(-5), list.contains(-5));
    }

    @Test
    void insert() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        IList<Integer> mlist = list.createMutableSublist(0,9);
        mlist.insert(2, -5);
        assertEquals(mlist.contains(-5), mlist.lastIndexOf(-5) == 2);

    }

    @Test
    void removeAt() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);

        }
        IList<Integer> mlist = list.createMutableSublist(0,9);
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
        IList<Integer> mlist = list.createMutableSublist(0,9);
        for (int i = 0; i < 10; i++) {
            mlist.remove(i);
            if (mlist.contains(i)) {
                actual = false;
            }
        }
        assertTrue(actual);
    }
}
