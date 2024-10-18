import java.util.LinkedList;

public class LinkedL {
    public static void main(String[] args) throws Exception {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.offer("A");
        linkedList.offer("B");
        linkedList.offer("C");
        linkedList.offer("D");
        linkedList.offer("E");

        System.out.println(linkedList);

        String s = new String("OP");
        String str = new String("OPe");

        System.out.println(str.compareTo(s));

    }
}
