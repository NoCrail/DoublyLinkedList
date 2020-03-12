public interface IList<T> {


    static class Node<T> {
        protected T data;
        protected Node<T> next;
        Node<T> previous;

        public Node(T in, Node<T> next, Node<T> prev) {
            data = in;
            this.next = next;
            this.previous = prev;
        }
    }

    int count();


    default
    boolean isEmpty(){
        return count() == 0;
    }



   // public void add(T value);

    boolean contains(T value);



    int indexOf(T value);

    //public void insert(int index, T value);

    //public void remove(T value);

    //public void removeAt(int index);

    //private

}
