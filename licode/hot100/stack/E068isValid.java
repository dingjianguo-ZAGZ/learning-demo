package stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 */
public class E068isValid {
    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        //保存对应括号
        Map<Character,Character> map = new HashMap<>();
        LinkedList<Character> stack = new LinkedList<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                //遇到左括号，将对应的右括号入栈
                stack.push(map.get(chars[i]));
            }else {
                //遇到右括号，判断栈顶元素与当前元素是否相同
                Character peek = stack.peek();
                if(!stack.isEmpty() && peek == chars[i]){
                    //匹配，消除
                    stack.pop();
                }else {
                    //不匹配，返回
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(){}[]";
        boolean valid = isValid(s);
        System.out.println(valid);
    }
}
