package combine;

import java.util.ArrayList;
import java.util.List;

public class E03letterCombinations {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return res;
        }
        //数字和字母映射 (下边：输入的数字，值：对应的字母)
        String[] strings = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backtracking(digits,strings,0);
        return res;
    }
    private void backtracking(String digits,String[] strings,int startIndex){
        if(sb.length()==digits.length()){
            res.add(sb.toString());
            return;
        }
        String string = strings[digits.charAt(startIndex) - '0'];
        for (int j = 0; j < string.length(); j++) {
            sb.append(string.charAt(j));
            backtracking(digits, strings, startIndex + 1);
            //回溯
            sb.deleteCharAt(sb.length() - 1);
        }

    }

}
