public class DoubleLinkedList<T>
{
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

    public int count() { return count; }

    public boolean isEmpty() { return count == 0; }

    public void addtohead(T el)
    {
        Node<T> temp = new Node<T>(el, head, null);
        if(head!=null) head.prev = temp;
        head = temp;
        if(tail==null) {tail = temp;}
        count++;

    }

    public void printForward(){

        Node tmp = head;
        while(tmp != null){
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

}
