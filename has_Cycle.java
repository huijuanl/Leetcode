package LeetCode;

public class has_Cycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null)
            return false;
        ListNode slow = head;
        ListNode quick = head.next;
        while (slow!=quick){
            if(quick==null||quick.next==null)
                return false;
            slow = slow.next;
            quick = quick.next.next;
        }
        return true;
    }
}
