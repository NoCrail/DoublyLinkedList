public class DoubleLinkedList<T> extends Sublist<T>  implements IList<T> {


    DoubleLinkedList(T in, Node<T> next, Node<T> prev) {
        super(in, next, prev);
    }

    DoubleLinkedList(){}

//интерфейс сделать тк длолжен появится метод sublist с 3 по 8 элементы список и этот подсписок sublis mutable




    public DoubleLinkedList<T> createMutableSublist(int start, int finish) throws IndexOutOfBoundsException{
        DoubleLinkedList<T> mlist = new DoubleLinkedList<>();
        mlist.head=this.head;
        mlist.tail=this.tail;

        Node<T> tmp = head;
        int i=0;
        mlist.count=finish-start+1;
        while (tmp != null) {
            if (i==start) {
                mlist.head=tmp;
            }
            if (i==finish) {
                mlist.tail=tmp;
            }
            tmp = tmp.next;
            i++;
        }
        return mlist;
    }


    public Sublist<T> createSublist(int start, int finish) throws IndexOutOfBoundsException {
        Sublist<T> slist = new Sublist<>();
        if ((start > count) || (finish > count)) throw new IndexOutOfBoundsException();
        if (finish < start) {
            int a = finish;
            finish = start;
            start = a;
        } //поменять местами если перепутаны границы
        Node<T> tmp = head;
        int i = 0;

        while (tmp != null) {
            if ((i <= finish) && (i >= start)) {
                slist.add(tmp.data);
            }
            tmp = tmp.next;
            i++;
        }


        return slist;
    }

   /* public int count() {
        return count;
    }*/


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

    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    @Override
    public boolean isEmpty() {
        return count==0;
    }

    public boolean contains(T element) {
        return (indexOf(element)!=-1);
    }




    public String printForward() {
        String s = "";
        StringBuilder sb = new StringBuilder(s);
        Node<T> tmp = head;

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

    protected Node<T> searchByIndex(int index) {
        if (index < count) {
            int i = 0;
            Node<T> current = head;
            while (current != null && i != index) {
                i++;
                current = current.next;
            }

            return current;
        } else return null;

    }

    /*protected T getNodeData(Node<T> node){
        return node.data;
    }*/ //getnodedata сли ничо не упадет УДАЛИТЬ


    /**
     * @param index - int number of element in List
     * @throws IndexOutOfBoundsException - if input index > size of list
     */
    public void removeAt(int index) throws IndexOutOfBoundsException {
        Node<T> current = searchByIndex(index);
        if (current == null)
            throw new IndexOutOfBoundsException();//System.out.println("Тут тоже должна быть нормальная обработка исключения, но обобщенный класс запрещает так что вот смайлик :-)");
        collapseForRemove(current);
    }

    private void collapseForRemove(Node<T> current) {
        Node<T> prevtmp = current.previous;
        Node<T> nexttmp = current.next;
        if (prevtmp != null && nexttmp != null) {
            prevtmp.next = nexttmp;
            nexttmp.previous = prevtmp;
        }
        if (prevtmp == null && nexttmp != null) {
            nexttmp.previous = null;
            head = nexttmp;
        }
        if (nexttmp == null && prevtmp != null) {
            prevtmp.next = null;
        }
        if (nexttmp == null && prevtmp == null) {
            clear();
        }
        if (count != 0) {
            count--;
        }
    }


}
