package string;

import java.util.Stack;

public class E43reverseWords {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] != ' '){
                //排除前导空格
                sb.append(chars[i]);
            }
            if(chars[i] == ' ' && sb.length() > 0){
                //遇到空格，并且sb 有字符，说明拼好一个单词
                stack.push(sb.toString());
                sb.delete(0,sb.length());
            }
        }
        if(sb.length() > 0){
            stack.push(sb.toString());
        }
        while (!stack.isEmpty()){
            res.append(stack.pop());
            if(!stack.isEmpty()){
                res.append(" ");
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "  abb bba  ccd  ";
        String[] s1 = s.split(" ");
        //System.out.print("{");
        for (String string : s1) {
            System.out.println(string);
        }
        //System.out.print("}");
    }
}
