package LeetCode;

import java.util.Stack;

//给出一个括号串，求一个最长合法的连续括号子串。
//https://github.com/Leetcode-Tutorial/Tutorial/tree/master/32-longestValidParentheses
//维护一个栈，里面保存'('的下标，每次进入一个')'时，栈弹出
//stack中保存左括弧的index
//last变量保存上一个不合法的位置下标
//动态规划:https://segmentfault.com/a/1190000011778547
public class longest_valid_parentheses {
    public int longestValidParentheses(String s) {
        int maxLen = 0;//记录最长合法区间
        if (s == null)
            return maxLen;
        Stack<Integer> stack = new Stack<>();
        int last = -1;//last记录上一个不合法的位置 ))))()()
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (str[i] == '(') {
                stack.add(i);//保存的是'('的下标
            } else if (!stack.isEmpty()) {
                stack.pop();
                if (!stack.isEmpty())//(()左边括号多
                    maxLen = Math.max(i - stack.peek(), maxLen);
                else maxLen = Math.max(i - last, maxLen);//)))(()) 右边括号多的情况
            } else {
                if (stack.isEmpty()) {
                    last = i;
                }

            }
        }
        return maxLen;
    }
    public int longestValidParentheses2(String s) {
        int[] dp = new int[s.length()];
        char[]str = s.toCharArray();
        int maxLen = 0;
        //dp[i]表示以s[i]结尾的合法区间的长度
        //如果s[i]为'('，合法区间长度为0
        //如果s[i]为')'，若s[i-1]为'('，合法区间长度为dp[i-2]+2
        //如果s[i]为')'，若s[i-1]为')', 若 s[i-dp[i-1]-1]='('，则dp[i] = dp[i-1]+2+dp[i-dp[i-1]-2];若若 s[i-dp[i-1]-1]=')'，为0
        for(int i = 1 ;i<dp.length;i++){
              if(str[i]=='(')
                  dp[i] = 0;
              else if(str[i-1]=='('){
                  if((i-2)>=0)
                      dp[i]=dp[i-2]+2;
                  else  dp[i] = 2;
              }
              else {
                  if(str[i-1]==')'){
                      if((i-dp[i-1]-1>=0)&&(str[i-dp[i-1]-1]=='(')) {
                          if ((i - dp[i - 1] - 2) >= 0)
                              dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                          else dp[i] = dp[i - 1] + 2;
                      }
                      else dp[i]=0;
                  }
                  else dp[i] = 0;
              }
              maxLen = Math.max(maxLen,dp[i]);

        }
        return maxLen;

    }
    public static void main(String[] args) {
        String s = "())";
        longest_valid_parentheses it = new longest_valid_parentheses();
        System.out.println(it.longestValidParentheses2(s));

    }
}
