package stack;

import java.util.*;

public class E29isValid {
    public boolean isValid(String s) {
        //定义规则
        Map<Character, Character> map = new HashMap<>();
        map.put('{','}');
        map.put('(',')');
        map.put('[',']');
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(map.containsKey(c)){
                //左括号，入栈
                stack.push(c);
            }else {
                //右括号
                if(stack.isEmpty() || map.get(stack.peek()) != c){
                    return false;
                }else {
                    //匹配，出栈
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
