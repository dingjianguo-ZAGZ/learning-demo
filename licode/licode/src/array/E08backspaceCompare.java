package array;

import java.security.PublicKey;

public class E08backspaceCompare {
    public static boolean backspaceCompare(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        String ds = delete(sc);
        String ts = delete(tc);
        return ds.equals(ts);


    }
    public static String delete(char[] chars){
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        for (int i = chars.length-1; i >= 0; i--) {
            if(chars[i] != '#' && flag == 0){
                sb.append(chars[i]);
            } else if (chars[i] != '#' && flag > 0) {
                flag--;
            } else {
                flag++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "bxj##tw";
        String t = "bxj###tw";
        boolean b = backspaceCompare(s, t);
        System.out.println(b);
    }
}
