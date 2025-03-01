package String;

public class E06repeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        // 根据字符串s计算得出前缀表数组next
        int[] next = getNext(s);
        // 前缀表数组中最后一位即为对整个字符串的最长相等前缀数
        int max = next[len - 1];
        // 数组长度减去最长相同前后缀的长度相当于是第一个周期的长度，
        // 也就是一个周期的长度，如果这个周期可以被整除，就说明整个数组就是这个周期的循环。
        return max != 0 && len % (len - max) == 0;

    }
    public int[] getNext(String s){
        char[] chars = s.toCharArray();
        int[] next = new int[chars.length];
        //j表示前缀末尾，前缀从0开始,也表示最长相等前后缀长度
        int j = 0;
        //i表示后缀末尾，如果字串长度为1，那么没有前后缀，所以i从1开始
        next[0] = 0;//可以不写，不初始化值，默认值为 0
        for (int i = 1; i < chars.length; i++) {
            while (j > 0 && chars[i] != chars[j]){
                j = next[j-1];
            }
            if(chars[i] == chars[j]){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
