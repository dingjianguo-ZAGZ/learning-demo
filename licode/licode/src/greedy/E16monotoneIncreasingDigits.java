package greedy;

public class E16monotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int n) {
        //找到第一个不递增的位置
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int flag = chars.length;//记录从哪个位置开始，后面都变成9
        for (int i = chars.length - 2; i >= 0; i--) {
            if(chars[i] > chars[i+1]){
                //将前一位减1，剩余都变成9
                chars[i]--;
                flag = i+1;
            }
        }
        for (int i = flag; i < chars.length; i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}
