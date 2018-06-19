package linklist;

import java.util.Random;
import java.util.Scanner;

/**
 * 题目26：
 * 复杂链表的复制
 */
public class ComplexListCopy26 {

    private static RandomListNode clone(RandomListNode pHead){
        if(pHead == null)
            return null;
        RandomListNode cloneHead = null;
        RandomListNode cloneNode = null;
        RandomListNode pNode = pHead;
        while(pNode != null){
            RandomListNode clone = new RandomListNode(pNode.label);
            clone.next = pNode.next;
            clone.random = null;
            pNode.next = clone;
            pNode = clone.next;
        }
        pNode = pHead;
        while(pNode != null){
            RandomListNode clone = pNode.next;
            if(pNode.random != null){
                clone.random = pNode.random.next;
            }
            pNode = clone.next;
        }
        pNode = pHead;
        cloneHead = pNode.next;
        cloneNode = cloneHead;
        pNode.next = cloneNode.next;
        pNode = pNode.next;
        while(pNode != null){
            cloneNode.next = pNode.next;
            cloneNode = cloneNode.next;
            pNode.next = cloneNode.next;
            pNode = pNode.next;
        }

        return cloneHead;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            RandomListNode head = new RandomListNode(n);
            RandomListNode currentNode = null;
            RandomListNode last = null;
            //head.next = currentNode;
            last = head;
            for (int i = 1; i <= n; i++) {
                currentNode = new RandomListNode(i);
                last.next = currentNode;
                last = currentNode;
            }
            Random rand = new Random();
            RandomListNode node = head.next;
            while(node != null){
                int label = rand.nextInt(n)+1;
                RandomListNode temp = head.next;
                while(temp != null){
                    if(temp.label == label){
                        node.random = temp;
                        break;
                    }
                    temp = temp.next;
                }
                node = node.next;
            }
            node = head.next;
            while (node != null){
                System.out.println(String.format("label=%d,random label=%d\n", node.label, node.random.label));
                node = node.next;
            }
            System.out.println("--------------------------------------");
            RandomListNode cloneNode = clone(head.next);
            while(cloneNode!=null){
                System.out.println(String.format("label=%d,random label=%d\n", cloneNode.label, cloneNode.random.label));
                cloneNode = cloneNode.next;
            }

        }
    }
}
