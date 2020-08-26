import java.util.LinkedList;

public class client {
    public static void main(String args[]) {
        linkedlist ll = new linkedlist();
        for(int i=0;i<=20;i++){
            ll.addLast(i*10);
        }
        System.out.println(ll);
    }   
}