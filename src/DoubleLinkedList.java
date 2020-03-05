
public class DoubleLinkedList<T>  {
    private class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T in, Node<T> next, Node<T> prev)
        {
            data = in;
            this.next = next;
            this.prev = prev;
        }


    }


    private Node<T> head;
    private Node<T> tail;
    private int count;


    public void Clear()
    {
        head = null;
        tail = null;
        count = 0;
    }

    public int Count() { return count; }

    public boolean isEmpty() { return count == 0; }

    public void Add(T el)       //AddToTail
    {   try {
        if (el == null) throw new IllegalArgumentException();
            Node<T> temp = new Node<T>(el, null, tail);
            if (tail != null) tail.next = temp;
            tail = temp;
            if (head == null) {
                head = temp;
            }
            count++;

    } catch (Exception ex)
    {
        System.out.println(ex.toString());
    }
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

    public String PrintForward()
    {
        String s="";
        Node tmp = head;
        while(tmp != null){
            s+=tmp.data+" ";
            //System.out.println(tmp.data);
            tmp = tmp.next;
        }
        return s;
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
        /*while(i!=index)
        {
            i++;
            cur = cur.next;
        }*/
        cur = SearchByIndex(index);
        Node tmp = new Node(cur.data, cur.next, cur);
        cur.data = el;
        cur.next = tmp;
        count++;
    }

    public void Remove(T el)
    {
        int index = IndexOf(el);
        Node cur = SearchByIndex(index);
           if (cur == null) throw new IndexOutOfBoundsException();  //System.out.println("Тут должна быть нормальная обработка исключения, но обобщенный класс запрещает так что вот смайлик :-)"); else {
           CollapseForRemove(cur);
    }

    private Node<T> SearchByIndex(int index)
    {
        int i=0;
        Node cur = head;
        while (cur != null && i!=index) {
        i++;
        cur = cur.next;
        }
        return cur;
    }

    public void RemoveAt(int index)
    {

        Node cur = SearchByIndex(index);
        if (cur == null) throw new IndexOutOfBoundsException();//System.out.println("Тут тоже должна быть нормальная обработка исключения, но обобщенный класс запрещает так что вот смайлик :-)");
        CollapseForRemove(cur);
    }

    void CollapseForRemove(Node<T> cur){
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
