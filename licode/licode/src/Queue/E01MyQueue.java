package Queue;

import java.util.Stack;

class E01MyQueue {
    Stack<Integer> stack1 = new Stack();
    Stack<Integer> stack2 = new Stack();


    public E01MyQueue() {

    }

    public void push(int x) {
        //清空stake2存入stake1
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(x);
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }

    public int pop() {
        int a = stack2.pop();
        return a;
    }

    public int peek() {
        int i = stack2.peek();
        return i;
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}