package LeetCode;
//Given a linked list, remove the n-th node from the end of list and return its head.
//用三个指针Pre,slow,quick来做，慢指针指向倒数第N个结点
//也可以只用两个指针来做,慢指针指向倒数第N+1个结点,快指针一开始多走了N步
public class removeNth_FromEnd {
     public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode quick = head;
        for (int i = 0; i < n; i++) {//快指针先走N步
                quick = quick.next;
        }
        if(quick==null)
            return head.next;
        while (quick.next != null) {
            slow = slow.next;
            quick = quick.next;
        }//quick最终指向最后一个元素,slow指向倒数第N+1个结点
        slow.next = slow.next.next;//删除倒数第N个结点
        return head;
    }
    public static void main(String[]args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        removeNth_FromEnd it = new removeNth_FromEnd();
        ListNode res = it.removeNthFromEnd(head,1);
        while (res!=null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
