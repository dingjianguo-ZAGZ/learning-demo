package Queue;

import java.util.Stack;

public class E04removeDuplicates {
    public String removeDuplicates(String s) {
        //使用栈数据结构
        /*Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int length = chars.length-1; length >= 0; length--) {
            if(!stack.isEmpty() && chars[length] == stack.peek()){
                stack.pop();
            }else {
                stack.push(chars[length]);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.toString();*/
        //使用双指针
        int l = 0;
        int f = 0;
        char[] chars = s.toCharArray();
        while (f < chars.length){
            //快指针的值覆盖慢指针
            chars[l] = chars[f];
            if(l > 0 && chars[l] == chars[l-1]){
                l--;
            }else {
                l++;
            }
            f++;
        }
        return new String(chars,0,l);

    }
}
