package LeetCode;

import java.util.Stack;

//Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
// determine if the input string is valid.
public class is_Valid {
    public boolean isValid(String s) {
        Stack <Character>stack = new Stack();
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }
            else if(stack.isEmpty())
                return false;
            else{
                char cur = stack.pop();
                if(s.charAt(i)==')'){
                    if(cur!='(')
                        return false;
                }
                else if(s.charAt(i)==']'){
                    if(cur!='[')
                        return false;
                }
                else if(s.charAt(i)=='}'){
                    if(cur!='{')
                        return false;
                }
            }

        }
        if(stack.isEmpty())//这个判断条件一定不能丢
            return true;
        else return false;
    }
    public static void main(String[]args){
        is_Valid it = new is_Valid();
        boolean res = it.isValid("{{[]}");
        System.out.println(res);

    }
}
