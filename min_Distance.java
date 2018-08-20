package LeetCode;

//Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same,
// where in each step you can delete one character in either string.
//给定两个字符串，删除这两个字符串的任意个字符后，使得剩下的字符串相等
//求要删多少步（最小步数）
//这道题其实是一个最长公共子序列的问题
//可用动态规划来做
//用DP求出两个单词最长的相同子序列的长度，并乘以2，被两个单词的长度之和减，就是最少步数了
public class min_Distance {
    //动态规划
    public int minDistance(String word1, String word2) {
        int res = 0;
        if (word1.length() == 0)
            return word2.length();
        if (word2.length() == 0)
            return word1.length();
        int[][] dp = new int[word1.length()][word2.length()];
        if (word1.charAt(0) == word2.charAt(0))
            dp[0][0] = 1;
        else dp[0][0] = 0;
        for (int j = 1; j < word2.length(); j++) {
            if (word1.charAt(0) == word2.charAt(j))
                dp[0][j] = 1;
            else dp[0][j] = dp[0][j - 1];

        }
        for (int i = 1; i < word1.length(); i++) {
            if (word1.charAt(i) == word2.charAt(0))
                dp[i][0] = 1;
            else dp[i][0] = dp[i - 1][0];

        }

        //dp[i][j]表示str1[0...i]和str2[0...j]上的最长公共子序列长度
        for (int i = 1; i < word1.length(); i++)
            for (int j = 1; j < word2.length(); j++) {
                if (word1.charAt(i) != word2.charAt(j)) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        res = dp[word1.length() - 1][word2.length() - 1];
        return word1.length() + word2.length() - 2 * res;
    }

    public static void main(String[] args) {
        min_Distance it = new min_Distance();
        String word1 = "set";
        String word2 = "eat";
        int res = it.minDistance(word1, word2);
        System.out.print(res);
    }
}
