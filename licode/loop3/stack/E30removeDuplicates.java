package stack;

import java.util.Stack;

public class E30removeDuplicates {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(stack.isEmpty() || stack.peek() != c){
                stack.push(c);
            }else {
                while (!stack.isEmpty() && stack.peek() == c){
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
