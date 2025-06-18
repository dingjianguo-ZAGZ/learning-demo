package string;

public class E38reverseString {
    public void reverseString(char[] s) {
        //双指针替换
        int l = 0;
        int r = s.length-1;
        while (l < r){
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
