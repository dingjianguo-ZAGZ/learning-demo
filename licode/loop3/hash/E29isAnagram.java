package hash;

public class E29isAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int[] hash = new int[26];
        for (int i = 0; i < sc.length; i++) {
            hash[sc[i]-'0']++;
            hash[tc[i]-'0']--;
        }
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != 0){
                return false;
            }
        }
        return true;
    }
}
