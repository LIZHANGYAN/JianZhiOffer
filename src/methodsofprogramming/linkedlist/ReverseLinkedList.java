package methodsofprogramming.linkedlist;

import java.util.Scanner;

/**
 * 翻转单链表
 */
public class ReverseLinkedList {

    public static Node reverseLinkedList(Node first){
        Node prev = null;
        Node cur = first;
        while (cur != null){
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static Node reverseLinkedList2(Node node, Node prev){
        if(node.next == null){
            node.next = prev;
            return node;
        }
        Node re = reverseLinkedList2(node.next, node);
        re.next = prev;
        return re;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            Node head = Node.createSingleLinkedList(arr);
            Node temp = head.next;
//            Node result = reverseLinkedList(temp);
//            temp = head.next;
            Node result2 = reverseLinkedList(temp);
            System.out.println();
        }
    }
}
