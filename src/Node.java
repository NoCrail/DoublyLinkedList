public class Node<T> {
    T data;
    Node<T> next;
    Node<T> prev;

    public Node(T in, Node<T> next, Node<T> prev)
    {
        data = in;
        this.next = next;
        this.prev = prev;
    }


}

