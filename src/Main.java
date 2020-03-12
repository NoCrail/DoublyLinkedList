public class Main {
    public static void main (String[] args)
    {

        /*DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        Sublist<Integer> slist;
        for(int i =0; i<10; i++){
            list.add(i);
        }
        System.out.println(list.printForward());
        slist = list.createSublist(0,10);
        System.out.println(slist.printForward());*/  // можкет пригодится для тестов
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.add(2);
        System.out.println(list.printForward());
        MutableSublist<Integer> mlist = new MutableSublist<>(list, 0,0);
        mlist.TestParentInsert(5);
        System.out.println(list.printForward());
       // System.out.println(list.getData());
       // System.out.println(list.getprevData());
    }
}
