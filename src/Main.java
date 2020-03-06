public class Main {
    public static void main (String[] args)
    {

        DoubleLinkedList<String> list = new DoubleLinkedList<String>();
        list.Add("1");
        list.Remove("1");
        System.out.println(list.PrintForward());


       // System.out.println(list.getData());
       // System.out.println(list.getprevData());
    }
}
