/**
 * 题目描述：
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * *************************************
 * 我的方法：
 * 从头到尾遍历存入ArrayList中，再交换ArrayList中的元素
 * 网上方法：
 * 递归，这个方法好
 */
package linklist;

import java.util.ArrayList;

public class PrintList {
    ArrayList<Integer> printList = new ArrayList<Integer>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){

        if(listNode!=null){
            this.printListFromTailToHead(listNode.next);
            printList.add(listNode.val);
        }
        return this.printList;
//        ArrayList<Integer> printList = new ArrayList<Integer>();
//        ListNode node = listNode;
//        while(node!=null){
//            printList.add(node.val);
//            node = node.next;
//        }
//        int length = printList.size();
//        System.out.println(length);
//        int i=0;
//        int j=length-1;
//        while(i<j){
//            int temp = printList.get(i);
//            printList.set(i,printList.get(j));
//            printList.set(j,temp);
//            i++;
//            j--;
//        }
//        return printList;
    }

    public static void main(String[] args) {

    }
}
