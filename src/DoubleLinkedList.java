
public class DoubleLinkedList<T> {
    private static class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T in, Node<T> next, Node<T> prev) {
            data = in;
            this.next = next;
            this.prev = prev;
        }


    }


    private Node<T> head;
    private Node<T> tail;
    private int count;
//интерфейс сделать тк длолжен появится метод sublist с 3 по 8 элементы список и этот подсписок sublis mutable

    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    public int count() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * @param element - input parameter
     * @throws IllegalArgumentException - in case of an argument value is null.
     */


    public void add(T element) throws IllegalArgumentException {      //AddToTail
        if (element == null) throw new IllegalArgumentException();
        Node<T> temp = new Node<>(element, null, tail);
        if (tail != null) tail.next = temp;
        tail = temp;
        if (head == null) {
            head = temp;
        }
        count++;
    }

    public boolean contains(T element) {
        Node<T> tmp = head;

        while (tmp != null) {
            if (tmp.data.equals(element)) return true;
            tmp = tmp.next;
        }
        return false;
    }

    public String printForward() {
        String s = "";
        Node<T> tmp = head;
        StringBuilder sb = new StringBuilder(s);
        while (tmp != null) {
            sb.append(tmp.data).append(" ");
            tmp = tmp.next;
        }
        return sb.toString();
    }

    /**
     * @param element value to find
     * @return int number of last element in list or -1 if value not found
     */
    public int indexOf(T element) {    //последнее вхождение
        int result = -1;
        int i = 0;
        Node<T> tmp = head;
        while (tmp != null) {
            if (tmp.data.equals(element)) {
                result = i;
            }
            tmp = tmp.next;
            i++;
        }
        return result;
    }

    public void insert(int index, T element) {

        Node<T> current;
        Node<T> tmp;

        current = searchByIndex(index);
        if (current != null) {
            tmp = new Node<>(current.data, current.next, current);
            current.data = element;
            current.next = tmp;
            count++;
        } else add(element);
    }

    public void remove(T element) {

            int index = indexOf(element);
            Node<T> current = searchByIndex(index);
            if (current == null)
                throw new IndexOutOfBoundsException();  //System.out.println("Тут должна быть нормальная обработка исключения, но обобщенный класс запрещает так что вот смайлик :-)"); else {
            collapseForRemove(current);

    }

    private Node<T> searchByIndex(int index) {
        if (index < count) {
            int i = 0;
            Node<T> current = head;
            while (current != null && i != index) {
                i++;
                current = current.next;
            }

            return current;
        } else return null; //переделать

    }

    public void removeAt(int index) {
        try {
            Node<T> current = searchByIndex(index);
            if (current == null)
                throw new IndexOutOfBoundsException();//System.out.println("Тут тоже должна быть нормальная обработка исключения, но обобщенный класс запрещает так что вот смайлик :-)");
            collapseForRemove(current);
        } catch (Exception ex) {
            System.out.println(ex.toString() + index);
        }

    }

    private void collapseForRemove(Node<T> current) {
        Node<T> prevtmp = current.prev;
        Node<T> nexttmp = current.next;
        if (prevtmp != null && nexttmp != null) {
            prevtmp.next = nexttmp;
            nexttmp.prev = prevtmp;
        }
        if (prevtmp == null && nexttmp != null) {
            nexttmp.prev = null;
            head = nexttmp;
        }
        if (nexttmp == null && prevtmp != null) {
            prevtmp.next = null;
        }
        if (nexttmp == null && prevtmp == null) {
            clear();
        }
        if(count!=0){
            count--;
        }
    }
}
