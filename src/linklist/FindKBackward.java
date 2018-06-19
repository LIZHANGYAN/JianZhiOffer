package linklist;

import java.util.Scanner;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKBackward {

    public static ListNode FindKthToTail(ListNode head, int k){

        if(head == null || k<=0)
            return null;
        ListNode link = head;
        int length = 0;
        while(link.next!=null){
            link = link.next;
            length++;
        }
        if(length<k)
            return null;


        int local = length - k + 1;
        link = head;
        while(local>=1){
            link = link.next;
            local--;
        }
        return link;
    }

    public static ListNode FindKthToTail2(ListNode head, int k){
        if(head==null || k<=0)
            return null;
        ListNode p = head;
        ListNode q = p;
        while(k>1 && p!=null){
            p = p.next;
            k--;
        }
        if(p==null) {
            System.out.println("k大于链表长度");
            return null;
        }
        while(p.next!=null){
            p = p.next;
            q = q.next;
        }

        return q;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int N = in.nextInt();
            ListNode head = new ListNode(N);
            ListNode last = null;
            ListNode node = new ListNode(1);
            head.next = node;
            last = node;
            for(int i=2; i<=N; i++){
                node = new ListNode(i);
                last.next = node;
                last = node;
            }

            ListNode link = head.next;
            while(link!=null){
                System.out.print(link.val+"-->");
                link = link.next;
            }
            System.out.println();
            int k = in.nextInt();
            System.out.println(FindKthToTail(head,k)==null?"空":FindKthToTail(head,k).val);
            System.out.println(FindKthToTail2(head,k)==null?"空":FindKthToTail(head,k).val);
            ListNode q = FindKthToTail2(head, k);
            while(q!=null){
                System.out.print(q.val+"-->");
                q = q.next;
            }
            System.out.println();
        }
    }
}
