
public class Sublist<T> implements IList<T> {





    protected Node<T> head;
    protected Node<T> tail;
    protected int count;
//интерфейс сделать тк длолжен появится метод sublist с 3 по 8 элементы список и этот подсписок sublis mutable



    public int count() {
        return count;
    }



    /**
     * @param element - input parameter
     * @throws IllegalArgumentException - in case of an argument value is null.
     */
    protected void add(T element) throws IllegalArgumentException {      //AddToTail
        if (element == null) throw new IllegalArgumentException();
        Node<T> temp = new Node<>(element, null, tail);
        if (tail != null) tail.next = temp;
        tail = temp;
        if (head == null) {
            head = temp;
        }
        count++;
    }
 //add
    public boolean contains(T element) {
        return (indexOf(element)!=-1);
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


}
