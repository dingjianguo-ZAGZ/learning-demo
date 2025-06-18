package string;

public class E42strStr {
    public int strStr(String haystack, String needle) {
        int[] lps = lps(needle);
        char[] hc = haystack.toCharArray();
        char[] nc = needle.toCharArray();
        int i = 0; //文本串
        int j = 0; //匹配串
        while (hc.length - i >= nc.length - j){
            if(hc[i] == nc[j]){
                i++;
                j++;
            }else if (j == 0){
                i++;
            }else {
                //j回退
                j = lps[j-1];
            }
            if(j == nc.length){
                return i-j; //文本串下标减去匹配的长度，是起始下标
            }
        }
        return -1;



    }

    /**
     * 获得前缀表
     *
     * @param s
     * @return
     */
    public int[] lps(String s) {
        int[] lps = new int[s.length()];
        char[] chars = s.toCharArray();
        //长度为 1 的字符串 最长相等前后缀长度是1
        int i = 1; //后缀字符串位置
        int j = 0; //前缀字符串位置，同时也是长度
        while (i < s.length()) {
            if (chars[i] == chars[j]) {
                lps[i] = j + 1;
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = lps[j - 1]; //j 向回找
            }
        }
        return lps;
    }
}
