package LeetCode;
import java.util.HashMap;

//Given a string S and a string T, find the minimum window in S
// which will contain all the characters in T in complexity O(n).
//For example,
//S ="ADOBECODEBANC"
//T ="ABC"
//Minimum window is"BANC".
//解决思路：用一个滑动窗口，两个首尾指针，
//一个哈希表，初始化为待寻找的字符及待寻找的字符数（value表示T的字符次数与滑动窗口中的字符次数的差值）
//滑动窗口一开始在最左边，当没有包含T时，右指针向右移；
//当包含了T时，记录下窗口大小，与Min对比；左指针右移一位，继续循环
//在线做题网址：https://www.nowcoder.com/questionTerminal/c466d480d20c4c7c9d322d12ca7955ac
//
//这道题的思路是：
//1) begin开始指向0， end一直后移，直到begin - end区间包含T中所有字符。
//记录窗口长度d
//2) 然后begin开始后移移除元素，直到移除的字符是T中的字符则停止，此时T中有一个字符没被
//包含在窗口，
//3) 继续后移end，直到T中的所有字符被包含在窗口，重新记录最小的窗口d。
//4) 如此循环知道end到S中的最后一个字符。
//时间复杂度为O(n)
public class Minimum_window_subString {
    public HashMap<Character, Integer> HashChar = new HashMap<Character, Integer>();

    public String minWindow(String S, String T) {
        if (S == null || T == null || S.length() < T.length())
            return "";
        for (int i = 0; i < T.length(); i++) {
            if (!HashChar.containsKey(T.charAt(i)))
                HashChar.put(T.charAt(i), 1);
            else {
                int value = HashChar.get(T.charAt(i));
                HashChar.put(T.charAt(i), value + 1);
            }
        }
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        int remain = T.length();//计数器来显示还有多少字符需要找 (remain==0时表示滑动窗口包含T中所有字符)
        String res = "";
        while (end <= (S.length() - 1)) {
            if (HashChar.containsKey(S.charAt(end))) {
                int value = HashChar.get(S.charAt(end));
                HashChar.put(S.charAt(end), value - 1);
                if (value > 0)//如果窗口滑动后，尾部增加的字符属于T，且检测到窗口中需要找的属于T的该字符的个数还没够，那么remain--
                    remain--;
            }
            while (remain == 0) {
                if (min > end - start + 1) {
                    min = end - start + 1;
                    res = S.substring(start, start + min);
                }

                if (HashChar.containsKey(S.charAt(start))) {
                    int value = HashChar.get(S.charAt(start));
                    HashChar.put(S.charAt(start), value + 1);
                    if (value == 0)
                        remain++;
                }
                start++;

            }
            end++;

        }
        return res;

    }

    public static void main(String[] args) {
        String S = "cabwefgewcwaefgcf";
        String T = "cae";
        System.out.println(new Minimum_window_subString().minWindow(S, T));
    }

}
