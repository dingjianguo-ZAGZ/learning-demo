public class E08backspaceCompare {
    public boolean backspaceCompare(String s, String t) {
        String s1 = newStr(s);
        String s2 = newStr(t);
        return s1.equals(s2);
    }
    public String newStr(String s){
        int skip = 0;
        StringBuilder sb = new StringBuilder();
        //逆序，计数需要删除字符的数量
        for (int j = s.length() - 1; j >= 0; j--) {
            if(s.charAt(j) == '#'){
                skip++;
            }else {
                if(skip == 0){
                    //拼接当前字符
                    sb.append(s.charAt(j));
                }else {
                    //当前字符不拼接
                    skip--;
                }
            }
        }
        return sb.toString();
    }
}
