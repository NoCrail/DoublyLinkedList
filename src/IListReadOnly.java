public interface IListReadOnly<T> {


    int count();


    default boolean isEmpty() {
        return count() == 0;
    }


    boolean contains(T value);


    int lastIndexOf(T value);
}
