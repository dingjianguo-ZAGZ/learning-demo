package stack;

import java.util.LinkedList;

class E069MinStack {
    //利用辅助栈，存最小元素
    LinkedList stack;
    LinkedList minStack;

    public E069MinStack() {
        minStack = new LinkedList();
        stack = new LinkedList();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);

        int peek = (int) minStack.peek();
        if (peek > val) {
            minStack.push(val);
        } else {
            minStack.push(peek);
        }

    }

    public void pop() {
        stack.pop();
        //出栈当前元素存在的栈的最小值
        minStack.pop();
    }

    public int top() {
        return (int) stack.peek();
    }

    public int getMin() {
        return (int) minStack.peek();
    }
}
