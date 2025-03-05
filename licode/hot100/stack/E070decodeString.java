package stack;

import java.util.LinkedList;
import java.util.List;

public class E070decodeString {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.push(multi);
                stack_res.push(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                //需要加倍
                StringBuilder temp = new StringBuilder();
                Integer cur_multi = stack_multi.pop();
                for (Integer i = 0; i < cur_multi; i++) {
                    temp.append(res);
                }
                res = new StringBuilder(stack_res.pop() + temp);
            } else if (c >= '0' && c <= '9')  multi = multi * 10 + Integer.parseInt(c + "");
            else res.append(c);
        }
        return res.toString();

    }
}
