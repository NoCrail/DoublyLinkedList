public class Main {
    public static void main (String[] args)
    {

        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        Sublist<Integer> slist = new Sublist<>();
        for(int i =0; i<10; i++){
            list.add(i);
        }
        System.out.println(list.printForward());
        slist = list.createSublist(0,10);
        System.out.println(slist.printForward());
       // System.out.println(list.getData());
       // System.out.println(list.getprevData());
    }
}
