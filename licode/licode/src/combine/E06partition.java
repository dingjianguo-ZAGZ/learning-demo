package combine;

import java.util.ArrayList;
import java.util.List;

public class E06partition {
    List<List<String>> res = new ArrayList<>();
    List<String> strings = new ArrayList<>();
    public List<List<String>> partition(String s) {
        StringBuilder sb = new StringBuilder();
        backtracking(s,0,sb);
        return res;
    }
    private void backtracking(String s,int index,StringBuilder sb){
        if(index == s.length()){
            res.add(new ArrayList<>(strings));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            sb.append(c);
            boolean check = check(sb);
            if(check){
                strings.add(sb.toString());
                backtracking(s,i+1,new StringBuilder());
                strings.remove(strings.size()-1);
            }
        }
    }
    private boolean check(StringBuilder sb){
        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
