package linklist;

import java.util.Scanner;

/**
 * 输入两个递增排列的链表，合并这两个链表并使新链表中的节点仍然递增排序
 */

class Node{
    int val;
    Node next;
    public Node(int val){
        this.val = val;
        this.next = null;
    }
}

public class CombineSortedLinkList {

    public static ListNode sort1(ListNode list1, ListNode list2){
        if(list1 == null && list2 != null)
            return list2;
        if(list2 == null && list1 != null)
            return list1;
        if(list1 == null && list2 == null)
            return null;

        ListNode newLink = null;

        if(list1.val < list2.val) {
            newLink = list1;
            newLink.next = sort1(list1.next, list2);
        }else {
            newLink = list2;
            newLink.next = sort1(list1, list2.next);
        }


        return newLink;
    }
    public static ListNode sort2(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        ListNode newLink = null;
        ListNode currentNode = null;
        while(list1!=null && list2!=null){
            if(list1.val < list2.val){
                if(newLink == null){
                    newLink = list1;
                    currentNode = list1;
                }else{
                    currentNode.next = list1;
                    currentNode = currentNode.next;
                }
                list1 = list1.next;
            }else{
                if(newLink == null){
                    newLink = list2;
                    currentNode = list2;
                }else{
                    currentNode.next = list2;
                    currentNode = currentNode.next;
                }
                list2 = list2.next;
            }
        }
        if(list1 == null)
            currentNode.next = list2;
        if(list2 == null)
            currentNode.next = list1;
        return newLink;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n1 = in.nextInt();
        ListNode head1 = new ListNode(n1);
        ListNode last1 = head1;
        for (int i = 0; i < n1; i++) {
            ListNode node = new ListNode(in.nextInt());
            last1.next = node;
            last1 = node;
        }
        int n2 = in.nextInt();
        ListNode head2 = new ListNode(n2);
        ListNode last2 = head2;
        for (int i = 0; i < n2; i++) {
            ListNode node = new ListNode(in.nextInt());
            last2.next = node;
            last2 = node;
        }
        ListNode link1 = head1.next;
        ListNode link2 = head2.next;
        while(link1!=null){
            System.out.print(link1.val+"-->");
            link1 = link1.next;
        }
        System.out.println();
        while(link2!=null){
            System.out.print(link2.val+"-->");
            link2 = link2.next;
        }
        System.out.println();

        ListNode newLink = sort2(head1.next, head2.next);
        while(newLink!=null){
            System.out.print(newLink.val+"-->");
            newLink = newLink.next;
        }
        System.out.println();

    }
}
