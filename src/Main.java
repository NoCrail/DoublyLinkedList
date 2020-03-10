public class Main {
    public static void main (String[] args)
    {

        DoubleLinkedList<String> list = new DoubleLinkedList<String>();
        list.add("1");
        list.remove("1");
        System.out.println(list.printForward());


       // System.out.println(list.getData());
       // System.out.println(list.getprevData());
    }
}
