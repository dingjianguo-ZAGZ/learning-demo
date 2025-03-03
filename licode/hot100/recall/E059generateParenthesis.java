package recall;

import java.util.*;

/**
 * 括号生成
 */
public class E059generateParenthesis {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder("(");

    public List<String> generateParenthesis(int n) {
        //必须以“（ ”开头
        backtrack(n, 0, 0);
        return res;
    }

    /**
     * @param n 每种括号的总数
     * @param l 已经使用左括号数量
     * @param r 已经使用右括号数量
     */
    private void backtrack(int n, int l, int r) {
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }
        if (l < n) {
            //可以放左括号
            sb.append("(");
            backtrack(n, l + 1, r);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (r < l) {
            //可以放右括号
            sb.append(")");
            backtrack(n, l, r + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}