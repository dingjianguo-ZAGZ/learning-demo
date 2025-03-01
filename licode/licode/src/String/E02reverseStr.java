package String;

public class E02reverseStr {
    public static String reverseStr(String s, int k) {
        int length = s.length();
        int k2 = 2 * k;
        //反转前k个
        String reverse = reverse(s, 0, k-1);
        for(int i = k2;i < length;i += k2){
            if(length - i >= k){
                //剩余长度>k，反转前k个
                reverse = reverse(reverse,i,i+k-1);
            }
            if(length - i < k){
                //全部反转
                reverse = reverse(reverse,i,length-1);
            }
        }
        return reverse;
    }
    public static String reverse(String s,int i,int j){
        char[] chars = s.toCharArray();
        while (i<j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        String s1 = reverseStr(s,2);
        System.out.println(s1);
    }
}
