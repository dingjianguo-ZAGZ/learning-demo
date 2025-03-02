package recall;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串
 */
public class E061partition {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        //转换为组合问题，截取不同的字符串，判断是否满足回文
        backTracing(s,0,new StringBuilder());
        return res;
    }
    public void backTracing(String s,int startIndex,StringBuilder sb){
        //定义递归头，当到切割终点时，已经经过提前剪枝，所以字符串是回文串
        if(startIndex == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            //从startIndex开始为新的字符串，对新字符串切割
            sb.append(s.charAt(i));
            if(check(sb)){
                //是回文串，对子串继续切割
                path.add(sb.toString());
                backTracing(s,i+1,new StringBuilder());
                //回溯
                path.remove(path.size()-1);
            }
        }
    }

    private boolean check(StringBuilder sb) {
        //检查是否是回文串
        int r = sb.length()-1;
        for (int l = 0; l < sb.length() / 2; l++) {
            if(sb.charAt(l) != sb.charAt(r)){
                return false;
            }
            r--;
        }
        return true;
    }
}
