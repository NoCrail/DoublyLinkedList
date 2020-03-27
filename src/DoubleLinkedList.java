public class DoubleLinkedList<T> extends Sublist<T>  implements IList<T> {






//интерфейс сделать тк длолжен появится метод sublist с 3 по 8 элементы список и этот подсписок sublis mutable




    public IList<T> createMutableSublist(int start, int finish) throws IndexOutOfBoundsException{
        DoubleLinkedList<T> mlist = new DoubleLinkedList<>();


        if((start<0)||(finish>count)) throw new IndexOutOfBoundsException();

        Node<T> tmp = head;
        int i=0;
        mlist.count=0;
        boolean counter = false;
        while (tmp != null) {
            if (i==start) {
                mlist.head=tmp;
                counter=true;

            }
            if (i==finish) {
                mlist.tail=tmp;
                mlist.count++;
                counter = false;
            }
            if(counter) mlist.count++;
            tmp = tmp.next;
            i++;
        }
        return mlist;
    }


    public IListReadOnly<T> createSublist(int start, int finish) throws IndexOutOfBoundsException {

        if (finish < start) {
            int a = finish;
            finish = start;
            start = a;
        }
        if ((start > count) || (finish > count)) throw new IndexOutOfBoundsException();

        Node<T> tmphead = null;
        Node<T> tmptail = null ;
        Node<T> tmp = head;
        boolean counter = false;
        int i = 0;
        while (tmp!=null){
            if (i==start){
                counter=true;
                tmphead=tmp;
            }
            if (i==finish){
                tmptail=tmp;
                i++;
                counter=false;

            }
            if(counter){
                i++;

            }
            tmp = tmp.next;
        }

        return new Sublist<T>(tmphead, tmptail, i);
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



    public boolean contains(T element) {
        return (lastIndexOf(element)!=-1);
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
    public int lastIndexOf(T element) {    //последнее вхождение
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

    public void insert(int index, T element) throws IndexOutOfBoundsException {

        if(index>count) throw new IndexOutOfBoundsException();

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

        int index = lastIndexOf(element);
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
