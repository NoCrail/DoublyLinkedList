public interface IList<T> extends IListReadOnly<T> {




    //int count();

    void clear();

    void insert(int index, T element);

    /*default boolean isEmpty() {
        return count() == 0;
    }*/


    //boolean contains(T value);


    //int indexOf(T value);

    void add(T element);

    IListReadOnly<T> createSublist(int start, int finish);

    void removeAt(int index);

    void remove(T element);

}
