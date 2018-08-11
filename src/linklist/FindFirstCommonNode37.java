package linklist;

public class FindFirstCommonNode37 {
    public static ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2){
        if(pHead1 == null || pHead2 == null)
            return null;
        int len1 = getLength(pHead1);
        int len2 = getLength(pHead2);
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        if(len1>len2){
            int diff = len1 - len2;
            while(diff>0){
                cur1 = cur1.next;
                diff--;
            }
        }else{
            int diff = len2 - len1;
            while(diff>0){
                cur2 = cur2.next;
                diff--;
            }
        }
        while (cur1!=null && cur2!= null){
            if(cur1.val == cur2.val)
                return cur1;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;

    }
    private static int getLength(ListNode head){
        ListNode current = head;
        int length = 0;
        while(current!=null){
            length++;
            current = current.next;
        }
        return length;
    }

}
