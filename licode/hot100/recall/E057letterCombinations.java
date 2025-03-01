package recall;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码
 */
public class E057letterCombinations {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0 || digits.isEmpty()){
            return res;
        }
        //定义数字和字母的映射关系，0，1没有映射关系
        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        dfs(digits,map,0);
        return res;
    }

    /**
     * @param digits 数字组合
     * @param map 对应关系
     * @param index 当前处理的数字的下标
     */
    private void dfs(String digits, String[] map, int index) {
        //定义递归头
        if(index == digits.length()){
            //将字符串加入结果集
            res.add(sb.toString());
            return;
        }
        //从映射关系中取出对应的字符串
        String str = map[digits.charAt(index) - '0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            dfs(digits,map,index+1);//取出下一个字符串处理
            //回溯
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
