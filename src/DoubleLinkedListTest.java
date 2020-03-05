import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest {

    @org.junit.jupiter.api.Test
    void clear() {

    }

    @org.junit.jupiter.api.Test
    void count() {
    }

    @org.junit.jupiter.api.Test
    void isEmpty()
    {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        for(int i=0; i<100; i++)
        {
            list.Add(i);
        }
        assertEquals(false, list.isEmpty());
    }



    @org.junit.jupiter.api.Test
    void add() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        String expected = "";
        for(int i=0; i<100; i++)
        {
            list.Add(i);
            expected+=i+" ";
        }
        assertEquals(expected, list.PrintForward());
    }

    @org.junit.jupiter.api.Test
    void contains() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        boolean expected = true;
        boolean actual = true;
        for(int i=0; i<100; i++)
        {
            list.Add(i);
        }
        for(int i=0; i<100; i++)
        {
            if(!list.Contains(i))actual=false;
        }
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void printForward() {
    }

    @org.junit.jupiter.api.Test
    void indexOf() {
    }

    @org.junit.jupiter.api.Test
    void insert() {
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }

    @org.junit.jupiter.api.Test
    void removeAt() {
    }
}