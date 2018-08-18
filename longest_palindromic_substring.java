package LeetCode;

//最长回文字符串
//试着用动态规划做一下
//DP 思路：P[i][j]是记录i到j子串是不是回文串。P(i,j)={true,if the substring Si…Sj is a palindrome;false,if the substring Si…Sj is not a palindrome}。那么可以得到：
//P(i,j)=(P(i+1,j−1) && Si==Sj)(j在外层，i在内层)
//中心扩展法:就是把给定的字符串的每一个字母当做中心，向两边扩展，这样来找最长的子回文串。算法复杂度为O(N^2)。
public class longest_palindromic_substring {
    //我们可以用蛮力计算出 O(N^3)中最长的回文连续子串,在牛客网上会超时
    //动态规划 时间复杂度O(n^2),空间复杂度O(n^2)

    public String longestPalindrome(String s) {
        if (s == null || s.equals(""))
            return "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxlen = 0;
        String res = s.substring(0, 1);
        //dp[i][j]为true表示下标i~j的子串为回文串，false相反
        for (int j = 0; j < s.length(); j++) {
            dp[j][j] = true;
            for (int i = 0; i < j; i++) {
                dp[i][j] = ((j - i) < 2 || dp[i + 1][j - 1]) && (s.charAt(i) == s.charAt(j));
                //dp[i + 1][j - 1]必须满足(i+1)<(j-1)
                if (dp[i][j] && maxlen <= (j - i + 1)) {
                    maxlen = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }

        }
        return res;
    }

    //中心扩展法：时间复杂度O(n^2),空间复杂度O(n)
    // 就是把给定的字符串的每一个字母当做中心，向两边扩展，这样来找最长的子回文串。算法复杂度为O(N^2)。
    //要分回文串为奇数和为偶数的情况
    public String longestPalindrome2(String s) {
        if (s == null || s.equals(""))
            return "";
        int maxlen = 0;
        String res = s.substring(0, 1);
        //回文串为奇数的情况
        for (int i = 1; i < s.length(); i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (maxlen < right - left + 1) {
                    maxlen = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }
        //回文串为偶数的情况
        for (int i = 1; i < s.length(); i++) {
            int left = i - 1;
            int right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (maxlen < right - left + 1) {
                    maxlen = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        longest_palindromic_substring it = new longest_palindromic_substring();
        System.out.print(it.longestPalindrome2("abbacdc"));

    }
}
