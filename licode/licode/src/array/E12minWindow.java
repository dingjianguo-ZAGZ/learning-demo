package array;

public class E12minWindow {
    public static String minWindow(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int[] sCount = new int[128];
        int[] tCount = new int[128];
        int count = 0;
        int counted = 0;//已经满足的条件
        int l = 0;
        int r = 0;
        Result res = null;
        //记录t中每个字符的个数
        for (int i = 0; i < tArr.length; i++) {
            tCount[tArr[i]]++;
        }
        for (int i = 0; i < tCount.length; i++) {
            if (tCount[i] > 0) {
                count++;//记录的是要判断多少种字符，而不是多少个字符
            }
        }
        //滑动窗口 当不满足条件时，r移动，当满足条件时，l移动
        for (; r < sArr.length; r++) {
            sCount[sArr[r]]++;
            if (tCount[tArr[r]] == sCount[sArr[r]]) {
                counted++;
            }
            while (count == counted && l <= r) {
                if (res == null) {
                    res = new Result(l, r);//找到一个则不为null，通过构造方法创建对象
                } else if (r - l < res.r - res.l) {
                    res = new Result(l,r);
                }
                //滑动窗口，移动l
                sCount[sArr[l]]--;
                if(tCount[tArr[l]] > sCount[sArr[l]]){
                    counted--;
                }
                l++;
            }
        }
        return res == null ? "\"\"" : new String(sArr, res.l, res.r - res.l + 1);
    }


    public static class Result {
        private int l;
        private int r;

        public Result(Integer l, Integer r) {
            this.l = l;
            this.r = r;
        }
    }

    public static void main(String[] args) {
        String s = "a";
        String t = "a";
        String r = minWindow(s, t);
        System.out.println(r);
    }

}
