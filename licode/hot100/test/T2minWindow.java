package test;

import jdk.swing.interop.SwingInterOpUtils;

public class T2minWindow {
    public static class Result {
        int left;
        int right;

        public Result() {
        }

        public Result(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        String s = new T2minWindow().minWindow("a", "a");
        System.out.println(s);
    }

    public String minWindow(String s, String t) {
        Result result = null;
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        int[] tArr = new int[128];
        int[] sArr = new int[128];
        for (char c : tCharArray) {
            tArr[c]++;
        }
        int count = 0; // t字符串中字符的种类
        for (int i : tArr) {
            if (i > 0) {
                count++;
            }
        }
        int left = 0;
        int counted = 0; // 现在已经满足的条件数
        for (int right = 0; right < s.length(); right++) {

            char ch = sCharArray[right];
            sArr[ch]++;
            if (sArr[ch] == tArr[ch]) {
                counted++;
            }
            while (left <= right && count == counted) {
                if (result == null) {
                    result = new Result(left, right);
                } else {
                    if (result.right - result.left > right - left) {
                        result = new Result(left, right);
                    }
                }
                char ch2 = sCharArray[left];
                sArr[ch2]--;
                left++;
                if ( sArr[ch2]<tArr[ch2]) {
                    counted--;
                }
            }
        }

        return result == null ? "" : new String(sCharArray, result.left, result.right - result.left + 1);
    }
}
