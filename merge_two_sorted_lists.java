package LeetCode;
//合并两个有序链表
//这个题比较简单，类似于归并排序
//注意head可以使用头结点,变得更简洁
public class merge_two_sorted_lists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        ListNode head = new ListNode(0);//头结点，这样就不用有额外的a,b指针了
        ListNode tail = head;
        while (l1 != null && l2 != null) {
            tail.next = l1.val < l2.val ? l1 : l2;
            tail = tail.next;
            if (l1.val < l2.val)
                l1 = l1.next;
            else l2 = l2.next;
        }
        if (l1 != null) {
            tail.next = l1;
        } else tail.next = l2;

        return head.next;
    }
    public static void main(String[]args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);
        merge_two_sorted_lists it = new merge_two_sorted_lists();
        ListNode head = it.mergeTwoLists(l1,l2);
        while (head!=null) {
            System.out.println(head.val+" ");
            head = head.next;
        }
    }
}
