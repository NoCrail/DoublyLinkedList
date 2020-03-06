import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest {

    @org.junit.jupiter.api.Test
    void clear() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        for(int i=0; i<100; i++)
        {
            list.Add(i);
        }
        list.Clear();
        assertEquals(true, list.isEmpty());


    }

    @org.junit.jupiter.api.Test
    void count() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        for(int i=0; i<100; i++)
        {
            list.Add(i);
        }
        assertEquals(100,list.Count());
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
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        boolean expected = true;
        boolean actual = true;
        for(int i=0; i<100; i++)
        {
            list.Add(i);
        }
        for(int i=0; i<100; i++)
        {
            if(list.IndexOf(i)!=i)actual=false;
        }
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void insert() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        boolean expected = true;
        boolean actual = true;

        list.Insert(0,-10);
        for(int i=0; i<10; i++)
        {
            list.Add(i);
        }
        for(int i=0; i<10; i++)
        {
            list.Insert(i, -i);
        }
        for(int i=0; i<=10; i++)
        {
            if(!list.Contains(-i))actual=false;
        }
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void remove() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        boolean expected = true;
        boolean actual = true;
        for(int i=0; i<100; i++)
        {
            list.Add(i);
        }
        for(int i=0; i<101; i++)
        {
            list.Remove(i);
            if(list.Contains(i))actual=false;
        }
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void removeAt() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        boolean expected = true;

        for(int i=0; i<100; i++)
        {
            list.Add(i);
        }
        for(int i=0; i<100; i++)
        {
            list.RemoveAt(0);

        }
        //System.out.println(list.PrintForward());
        assertEquals(expected, list.isEmpty());
    }
}