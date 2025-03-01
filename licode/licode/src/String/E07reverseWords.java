package String;

import java.util.Stack;

public class E07reverseWords {
    public String reverseWords(String s) {
        //使用栈数据结构
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            //不拼接空格，解决了每一个单词前面空格的问题
            if(c != ' '){
                sb.append(c);
            }
            if(c == ' '&& sb.length() > 0){
                //sb长度 > 0,此时遇到了空格,说明存入了一个单词，放入栈中
                stack.push(sb.toString());
                sb.delete(0,sb.length());
            }
        }
        //如果最后一个单词后面没有空格，则不满足第二个判断，没有被放入栈中，要特殊处理
        if(sb.length() > 0){
            stack.push(sb.toString());
        }
        StringBuilder res = new StringBuilder();
        //将栈中的单词依次弹出，并加上空格分割
        while (!stack.isEmpty()){
            res.append(stack.pop());
            //如果弹出之后不为空，加上空格
            if(!stack.isEmpty()){
                res.append(" ");
            }
        }
        return res.toString();


    }

    public static void main(String[] args) {
        String s = " hello world ";
        String[] split = s.split(" ");
        System.out.println(split.length);
        for (String string : split) {
            System.out.println(string+1);
        }

    }
}
