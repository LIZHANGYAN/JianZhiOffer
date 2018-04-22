package completeofcode;

import java.util.Scanner;

class Node{
    String val;
    Node next = null;
    public Node(String val){
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = this;
        while(node!=null){
            sb.append(node.val+"-->");

            node = node.next;
        }
        return sb.toString();
    }
}


public class DeleteNode {

    public static Node deleteNode(Node headNode, Node node){
        if(headNode.next==null)
            return null;
        // 删除中间节点
        if(node.next!=null){
            Node nextNode = node.next;
            node.val = nextNode.val;
            node.next = nextNode.next;
        }else if(headNode == node) { // 只有一个节点
            headNode = null;
        }else{ // 删除尾节点
            Node tempNode = headNode;
            while(tempNode.next.val != node.val){
                tempNode = tempNode.next;
            }
            tempNode.next = null;
        }
        return headNode;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node head = new Node(1+"");
        Node last = head;
//        Node node = new Node(0+"");
//        head.next = node;
//        last = node;
        for (int i = 2; i <= n; i++) {
            Node node = new Node(i+"");
            last.next = node;
            last = node;
        }
        System.out.println(head.toString());
        int m = in.nextInt();
        Node deleteNode = head;

        for (int i = 1; i < m; i++) {
            deleteNode = deleteNode.next;
        }
        head = deleteNode(head, deleteNode);
        System.out.println(head.toString());
    }
}
