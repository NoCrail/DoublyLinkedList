
public class Sublist<T>  implements IListReadOnly<T> {


    protected Node<T> head;
    protected Node<T> tail;
    protected int count;



    Sublist() {
        head=null;
        tail=null;
        count=0;
    }


//интерфейс сделать тк длолжен появится метод sublist с 3 по 8 элементы список и этот подсписок sublis mutable


    public int count() {
        return count;
    }

    protected Sublist(Node<T> start, Node<T> finish, int size){
        head = start;
        tail = finish;
        count = size;
    }

    /**
     * @param element - input parameter
     * @throws IllegalArgumentException - in case of an argument value is null.
     */

    public boolean contains(T element) {
        return (lastIndexOf(element) != -1);
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


}
