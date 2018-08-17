package LeetCode;

//给定两个链表，返回其相加的结果。注意链表是倒序的，即第一个节点是个位。
//https://www.cnblogs.com/4everlove/p/3641252.html
//https://www.nowcoder.com/practice/56f8d422eae04f129c8e5a05299ae275?tpId=46&tqId=29174&tPage=1&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
public class add_Two_Numbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);//用一个头结点
        ListNode tail = head;
        int add = 0;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + add;
            add = val / 10;
            tail.next = new ListNode(val % 10);
            tail = tail.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int val = l1.val + add;
            add = val / 10;
            tail.next = new ListNode(val % 10);
            tail = tail.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int val = l2.val + add;
            add = val / 10;
            tail.next = new ListNode(val % 10);
            tail = tail.next;
            l2 = l2.next;
        }
        if (add == 1) //这儿要注意，当head1==null&&head2==null，可能add==1，也就是存在进位 1+99 这种情况
            tail.next = new ListNode(1);

        return head.next;
    }

    //这种方法比第一种方法精炼一点，但是复杂度是一样的
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = new ListNode(0);
        ListNode tail = head;
        int add = 0;
        while (l1 != null || l2 != null || add != 0) {
            if (l1 != null) {
                add += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                add += l2.val;
                l2 = l2.next;
            }

            tail.next = new ListNode(add % 10);
            tail = tail.next;
            add /= 10;//最后更新add
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(9);
        head2.next = new ListNode(9);
        add_Two_Numbers it = new add_Two_Numbers();
        ListNode res = it.addTwoNumbers(head1, head2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
