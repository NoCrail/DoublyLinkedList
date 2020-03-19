public class Node<T> {

        protected T data;
        protected Node<T> next;
        protected Node<T> previous;

        public Node(T in, Node<T> next, Node<T> prev) {
            data = in;
            this.next = next;
            this.previous = prev;
        }


    Node() {
    }
}
