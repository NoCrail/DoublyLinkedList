public interface IList<T> {




    int count();

    void clear();



    default boolean isEmpty() {
        return count() == 0;
    }


    boolean contains(T value);


    int indexOf(T value);

}
