package Queue;

import java.util.Stack;

public class E03isValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        if(chars.length % 2 != 0){
            return false;
        }
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
            }else if(!stack.isEmpty() && stack.peek() == c ){
                stack.pop();
            }else {
                return false;
            }
        }
        boolean isEmpty = stack.isEmpty();
        return isEmpty;
    }
}
