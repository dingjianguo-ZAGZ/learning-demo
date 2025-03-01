package String;

public class E01reverseString {
    public void reverseString(char[] s) {
        /* 时间复杂度较高，想起来简单

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length; i++) {
            stack.push(s[i]);
        }
        for (int i = 0; i < s.length; i++) {
            Character c = stack.pop();
            s[i] = c;
        }*/
        int end = s.length - 1;
        for (int l = 0,r = end;l < r;l++,r--){
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
        }

    }
}
