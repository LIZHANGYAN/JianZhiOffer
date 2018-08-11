package methodsofprogramming.linkedlist;

/**
 * 单链表节点
 */
public class Node {
    int val;
    Node next;

    public Node(int val){
        this.val = val;
    }

    static Node createSingleLinkedList(int[] arr){
        Node head = new Node(arr.length);
        Node tail = head;
        tail.next = null;
        for (int i = 0; i < arr.length; i++) {
            Node cur = new Node(arr[i]);
            tail.next = cur;
            tail = cur;
        }
        return head;
    }
}
