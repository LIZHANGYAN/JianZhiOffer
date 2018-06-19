import linklist.ListNode;
import linklist.PrintList;
import string.ReplaceSpace;

public class main {
    public static void main(String[] args){

        ListNode head = new ListNode(1);
        ListNode listnode = head;
        for(int i=2; i<10;i++){
            ListNode node = new ListNode(i*2);
            listnode.next = node;
            listnode=node;
        }
        listnode.next=null;
        PrintList pl = new PrintList();
        System.out.println(pl.printListFromTailToHead(head).toString());
    }
}
