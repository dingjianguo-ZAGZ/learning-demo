package string;

public class E39reverseStr {
    public String reverseStr(String s, int k) {
        for (int i = 0; i < s.length(); i += 2 * k) {
            if(s.length() - i < k){
                s = reverse(s, i, s.length() - 1);
                break;
            }
            if(s.length() - i >= k){
                s = reverse(s,i,i+k-1);
            }
        }
        return s;


    }
    public String reverse(String s,int i,int j){
        char[] chars = s.toCharArray();
        while (i < j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }
}
