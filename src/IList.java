public interface IList<T> {
    public void clear();

    public int count();

    public boolean isEmpty();

    public void Add(T value);

    public boolean contains(T value);

    public String printForward();

    public int indexOf();

    public void insert(int index, T value);

    public void remove(T value);

    public void removeAt(int index);

    //private

}
