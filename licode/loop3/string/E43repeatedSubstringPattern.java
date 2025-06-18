package string;

public class E43repeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        if(s.length() % 2 != 0) return false;
        int[] lps = new int[s.length()];
        int i = 1;
        int j = 0;
        while (i < s.length()){
            if(s.charAt(i) == s.charAt(j)){
                lps[i] = j + 1;
                i++;
                j++;
            }else if (j == 0){
                i++;
            }else {
                j = lps[j - 1];
            }
        }
        int max = lps[s.length() - 1];
        return max!=0 && s.length() % (s.length() - max) == 0;

    }
}
