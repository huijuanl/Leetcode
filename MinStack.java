package LeetCode;

import java.util.Stack;

public class MinStack {
    Stack<Integer> dataStack;
    Stack<Integer> minStack ;

    public MinStack() {
         dataStack = new Stack<>();
         minStack = new Stack<>();
    }

    public void push(int x) {
        if(dataStack.isEmpty()){
            dataStack.push(x);
            minStack.push(x);
        }
        else {
            dataStack.push(x);
            minStack.push(Math.min(minStack.peek(),x));
        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
