package LeetCode;

import java.util.HashMap;
//最长不重复子串
//Input: "abcabcbb"
//Output: 3
public class lengthOfLongestUnRepeatedSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        char[] arr = s.toCharArray();
        HashMap<Character, Integer> res = new HashMap<>();
        int maxLen = 0;
        int start = 0;//起始下标
        for (int i = 0; i < arr.length; i++) {
            if (!res.containsKey(arr[i]) || res.get(arr[i]) < start)
                maxLen = Math.max(maxLen, i - start + 1);
            else
                start = res.get(arr[i]) + 1;
            res.put(arr[i], i);
        }
        return maxLen;

    }

    public static void main(String[] args) {
        String s = "aab";
        lengthOfLongestUnRepeatedSubstring it = new lengthOfLongestUnRepeatedSubstring();
        int res = it.lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
