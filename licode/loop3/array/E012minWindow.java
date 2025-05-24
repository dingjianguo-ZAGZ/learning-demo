public class E012minWindow {
    public static String minWindow(String s, String t) {
        Result res = null;
        //滑动窗口
        int[] countT = new int[128]; //目标串
        char[] ts = t.toCharArray();
        int[] countS = new int[128]; //原始串
        char[] ss = s.toCharArray();
        //统计目标串需要出现的字符次数
        for (char c : ts) {
            countT[c]++;
        }
        //需要满足的条件数
        int count = 0;
        for (int i : countT) {
            if(i > 0) count++;
        }
        int counted = 0; //已经满足条件数
        int l = 0;
        for (int r = 0; r < ss.length; r++) {
            char c = ss[r];
            countS[c]++;
            //原始串中字符出现次数和目标串相等
            if(countS[c] == countT[c]) counted++;
            //所有字符满足，移动左指针
            while (counted == count && l <= r){
                if(res == null){
                    res = new Result(l,r);
                }else {
                    //寻找最短
                    if((r - l) < (res.right - res.left)){
                        res = new Result(l,r);
                    }
                }
                //移动左指针
                char lC = ss[l];
                countS[lC]--;
                if(countS[lC] < countT[lC]) counted--;
                l++;
            }
        }
        return res == null ? "" : new String(ss, res.left, res.right - res.left + 1);
    }
    static class Result{
        int left;
        int right;

        public Result(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String s1 = minWindow(s, t);
        System.out.println(s1);
    }
}
