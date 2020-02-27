import java.io.IOException;

public class DoubleLinkedList<T> {
    Node<T> head;
    Node<T> tail;
    int count;

    /*public void Add(T data)
    {
        Node<T> node = new Node<T>(data);

        if(head == null)
            head = node;
        else
        {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
        count++;
    }*/

    public void Clear()
    {
        head = null;
        tail = null;
        count = 0;
    }

    public int Count() { return count; }

    public boolean isEmpty() { return count == 0; }

    public void Add(T el)       //AddToTail
    {
        Node<T> temp = new Node<T>(el, null, tail);
        if(tail!=null) tail.next = temp;
        tail = temp;
        if(head==null) {head = temp;}
        count++;
    }

    public boolean Contains(T el)
    {
        Node tmp = head;
        while(tmp != null){
            if (tmp.data == el) return true;
            tmp = tmp.next;
        }
        return false;
    }

    public void PrintForward(){

        Node tmp = head;
        while(tmp != null){
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    public int IndexOf(T el)
    {
        int res = -1;
        int i = 0;
        Node tmp = head;
        while(tmp != null){
            if(tmp.data == el) res=i;
            tmp = tmp.next;
            i++;
        }
        return res;
    }

    public void Insert(int index, T el)
    {
        int i = 0;
        Node cur = head;
        while(i!=index)
        {
            i++;
            cur = cur.next;
        }
        Node tmp = new Node(cur.data, cur.next, cur);
        cur.data = el;
        cur.next = tmp;
        count++;
    }

    public void Remove(T el)
    {

            Node cur = head;
            while (cur != null && cur.data != el) {

                cur = cur.next;
            }
           if (cur == null) System.out.println("Тут должна быть нормальная обработка исключения, но обобщенный класс запрещает так что вот смайлик :-)"); else {
               Node prevtmp = cur.prev;
               Node nexttmp = cur.next;
               //System.out.println(prevtmp.data)
               if (prevtmp != null && nexttmp != null) {
                   prevtmp.next = nexttmp;
                   nexttmp.prev = prevtmp;
                   System.out.println("case1");
               }
               if (prevtmp == null) {
                   //prevtmp.next = nexttmp;
                   nexttmp.prev = null;
                   head = nexttmp;
                   System.out.println("case2");
               }
               if (nexttmp == null) {
                   //prevtmp.next = nexttmp;
                   prevtmp.next = null;
                   System.out.println("case3");
               }
               count--;
           }
    }

    public void RemoveAt(int index)
    {
        int i = 0;
        Node cur = head;
        while (cur != null && i!=index) {
            i++;

            cur = cur.next;
        }
        if (cur == null) System.out.println("Тут тоже должна быть нормальная обработка исключения, но обобщенный класс запрещает так что вот смайлик :-)"); else {
            Node prevtmp = cur.prev;
            Node nexttmp = cur.next;
            if (prevtmp != null && nexttmp != null) {
                prevtmp.next = nexttmp;
                nexttmp.prev = prevtmp;
            }
            if (prevtmp == null) {
                //prevtmp.next = nexttmp;
                nexttmp.prev = null;
                head = nexttmp;
            }
            if (nexttmp == null) {
                //prevtmp.next = nexttmp;
                prevtmp.next = null;
            }
            count--;
        }
    }

}
