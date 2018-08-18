package LeetCode;
//https://www.cnblogs.com/grandyang/p/4444160.html

import java.util.ArrayList;

//题目：
//left:左括号剩余个数
//right:右括号剩余个数
//这道题给定一个数字n，让生成共有n个括号的所有正确的形式，
// 对于这种列出所有结果的题首先还是考虑用递归Recursion来解，
// 由于字符串只有左括号和右括号两种字符，而且最终结果必定是左括号3个，右括号3个，
// 所以我们定义两个变量left和right分别表示剩余左右括号的个数，
// 如果在某次递归时，左括号的个数大于右括号的个数，
// 说明此时生成的字符串中右括号的个数大于左括号的个数，即会出现')('这样的非法串，
// 所以这种情况直接返回，不继续处理。如果left和right都为0，
// 则说明此时生成的字符串已有3个左括号和3个右括号，且字符串合法，则存入结果中后返回。
public class generate_Parenthesis {
    ArrayList<String> res;
    String s;

    public ArrayList<String> generateParenthesis(int n) {//n对括号
        res = new ArrayList<String>();
        if (n < 1)
            return res;
        s = "";
//        process(0, n, n);
        process2(0, n, n);
        return res;
    }

    public void process(int i, int left, int right) {
        if (left > right)
            return;
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        if (left > 0) {
            s = s + '(';
            process(i + 1, left - 1, right);
            s = s.length() == 1 ? "" : s.substring(0, s.length() - 1);
        }
        if (right > 0) {
            s = s + ')';
            process(i + 1, left, right - 1);
            s = s.length() == 1 ? "" : s.substring(0, s.length() - 1);
        }
    }

    //process()和process2()都可以,process简洁一点，process2更好理解一点
    public void process2(int i, int left, int right) {
        if (left < 0 || right < 0 || left > right)
            return;
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }

        s = s + '(';
        process2(i + 1, left - 1, right);
        s = s.length() == 1 ? "" : s.substring(0, s.length() - 1);
        s = s + ')';
        process2(i + 1, left, right - 1);
        s = s.length() == 1 ? "" : s.substring(0, s.length() - 1);
    }

    public static void main(String[] args) {
        generate_Parenthesis it = new generate_Parenthesis();
        ArrayList<String> res = it.generateParenthesis(3);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }

    }
}
