public class MutableSublist<T> implements IList<T> {
    @Override
    public int count() {
        return finish-start+1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(T value) {
        int position = parentList.indexOf(value);
        if((position<=finish)&&(position>=start)) {
            return parentList.contains(value);
        }
        else return false;
    }

    @Override
    public String printForward() {
        Sublist<T> slist = parentList.createSublist(start, finish);
        return slist.printForward();
    }


    /**
     * @param a  - current number
     * @param start - left border of segment
     * @param finish - right border of segment
     * @return true if a located between start and finish, false if no
     */
    private boolean between(int a, int start, int finish){
        if(start>finish){
            int tmp = finish;
            finish = start;
            start = tmp;
        }
        return ((a<=finish)&&(a>=start));
    }

    @Override
    public int indexOf(T value) {
       int position = parentList.indexOf(value);
        if(between(position,start,finish)){
            return position-start;
        } else return -1;
    }





    private DoubleLinkedList<T> parentList;
    private int start;
    private int finish;


    public MutableSublist(DoubleLinkedList<T> list, int start, int finish)
    {
        parentList = list;
        this.start = start;
        this.finish = finish;
    }

    public void TestParentInsert(T el){
        parentList.add(el);
    }

    public void clear(){
        for(int i = start; i<=finish; i++){
            parentList.removeAt(i);
        }
    }





}
