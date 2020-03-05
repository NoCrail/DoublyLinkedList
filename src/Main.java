public class Main {
    public static void main (String[] args)
    {

        DoubleLinkedList<String> list = new DoubleLinkedList<String>();
        list.Add("1");
        list.Add("2");
        list.Add("3");

        //list.Contains("2");

       System.out.println(list.Contains("3"));
       //list.Clear();
        System.out.println(list.Contains("3"));

       //System.out.println(list.IndexOf("2"));
       // System.out.println(list.IndexOf("1"));
        System.out.println(list.PrintForward());
        //list.Insert(5,"GG");
        list.RemoveAt(1);
        list.RemoveAt(6);
        System.out.println(list.PrintForward());


       // System.out.println(list.getData());
       // System.out.println(list.getprevData());
    }
}
