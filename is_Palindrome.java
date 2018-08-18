package LeetCode;
//判断一个链表是否为回文串
//题目:https://leetcode.com/problems/palindrome-linked-list/description/
//思路：
// 设置slow,quick指针，slow最后停止在链表的中点(奇数)或中点的前一个（偶数）
//将链表的后半部分翻转(后半部分指的是slow.next开始到null的这部分)

public class is_Palindrome {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
  public ListNode reverse(ListNode root){
        if(root==null||root.next==null)
            return root;
        ListNode cur = root;
        ListNode pre = null;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
  }
    public boolean isPalindrome(ListNode head) {
     if(head==null||head.next==null)
         return true;
     ListNode slow = head;
     ListNode quick = head.next.next;
     while (quick!=null&&quick.next!=null){
         slow = slow.next;
         quick = quick.next.next;
     }
     ListNode tail = reverse(slow.next);
     while (tail!=null){
         if(tail.val!=head.val)
             return false;
         head = head.next;
         tail = tail.next;
     }
     return true;
    }
    public static void main(String[]args){
        is_Palindrome it = new is_Palindrome();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);
        System.out.println(it.isPalindrome(head));
    }

}
