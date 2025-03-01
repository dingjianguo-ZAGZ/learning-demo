package String;

public class E05strStr {
    public int strStr(String haystack, String needle) {
        int sublen = needle.length();
        for (int i = 0; i < haystack.length() - sublen; i++) {
            String substring = haystack.substring(i, i + sublen);
            if(substring.equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
