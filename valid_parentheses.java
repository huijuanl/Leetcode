package LeetCode;
//题目：https://www.nowcoder.com/practice/37548e94a270412c8b9fb85643c8ccc2?tpId=46&tqId=29158&tPage=1&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
//链接：https://www.nowcoder.com/questionTerminal/37548e94a270412c8b9fb85643c8ccc2
//来源：牛客网
//* 有效的括号
// * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
// * 有效字符串需满足：
// * 左括号必须用相同类型的右括号闭合。
// * 左括号必须以正确的顺序闭合。
// * 注意空字符串可被认为是有效字符串。
//思路：只能用栈来实现，不能用计数器(如果一个小括号可以用计数器)
import java.util.Stack;
public class valid_parentheses {
    public boolean isValid(String s) {
        if(s==null)
            return false;
        Stack<Character> stack = new Stack<>();
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{')
               stack.push(s.charAt(i));
            else{
                if(stack.isEmpty())
                    return false;
                else {//右括号过多
                    if(s.charAt(i)==')'&&stack.pop()!='(')
                        return false;
                    else if(s.charAt(i)==']'&&stack.pop()!='[')
                        return false;
                    else if(s.charAt(i)=='}'&&stack.pop()!='{')
                        return false;
                }
            }
        }
        if(stack.isEmpty())
            return true;
        else return false;//左括号过多
    }
    //更为巧妙的解法
    //其实和第一种方法差不多啦，这种方法不需要必须掌握
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
    public static void main(String[]args){
        valid_parentheses it = new valid_parentheses();
        String s = "{[}[{}{{({)){[}([]{)}({())[}[}";
        System.out.println(it.isValid(s));

    }
}
