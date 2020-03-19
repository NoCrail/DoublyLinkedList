public interface IListRO<T> {


    int count();


    default boolean isEmpty() {
        return count() == 0;
    }


    boolean contains(T value);


    int indexOf(T value);
}
