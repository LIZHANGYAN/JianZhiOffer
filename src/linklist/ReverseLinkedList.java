package linklist;

import java.util.Scanner;

public class ReverseLinkedList {

    public static ListNode ReverseList(ListNode node){
        if(node==null) // 空链表
            return null;
        if(node.next == null){ // 只有一个节点
            return node;
        }
        ListNode rehead = null;
        ListNode preNode = null;
        ListNode currentNode = node;

        while(currentNode != null){
            ListNode nextNode = currentNode.next;
            if(nextNode==null)
                rehead = currentNode;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
        }

        return rehead;
    }

    // 递归方法
    public static ListNode ReverseList2(ListNode head){
        if(head == null)
            return null;
        if(head.next == null)
            return head;

        ListNode rehead = ReverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return rehead;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int N = in.nextInt();
            ListNode head = new ListNode(N);
            ListNode last = null;
            ListNode node = new ListNode(1);
            head.next = node;
            last = node;
            for (int i = 2; i <= N; i++) {
                node = new ListNode(i);
                last.next = node;
                last = node;
            }

            ListNode link = head.next;
            while (link != null) {
                System.out.print(link.val + "-->");
                link = link.next;
            }
            System.out.println();
//            ListNode newNode = ReverseList(head.next);
//            link = newNode;
//            while (link != null) {
//                System.out.print(link.val + "-->");
//                link = link.next;
//            }
//            System.out.println();

            ListNode newNode = ReverseList2(head.next);

            link = newNode;
            while (link != null) {
                System.out.print(link.val + "-->");
                link = link.next;
            }
            System.out.println();
        }
    }
}
