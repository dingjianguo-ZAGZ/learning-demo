package Queue;

import java.lang.annotation.ElementType;
import java.util.Stack;

public class E05evalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if(s.equals("+")){
                stack.push(stack.pop()+stack.pop());
            } else if (s.equals("-")) {
                stack.push(-stack.pop()+stack.pop());
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }else if (s.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);
            }else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String s = "+";
        String s1 = "1";
        String s2 = "1";
        System.out.println(1+1);
    }
}
