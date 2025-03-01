package string;

/**
 * 最小覆盖子串
 */
public class E012minWindow {
    public String minWindow(String s, String t) {
        //目标串
        char[] tChars = t.toCharArray();
        int[] tCount = new int[128];
        //原始串
        char[] sChars = s.toCharArray();
        int[] sCount = new int[128];
        for (char tChar : tChars) {
            tCount[tChar]++;
        }
        //需要满足的条件数
        int count = 0;
        //已经满足的条件数
        int counted = 0;
        //计算需要满足的条件数
        for (int i : tCount) {
            if (i > 0) count++;
        }
        //定义结果，并初始化
        Result res = null;
        //定义结果字符串的起始位置
        int left = 0;
        for (int right = 0; right < sChars.length; right++) {
            char sChar = sChars[right];
            sCount[sChar]++;
            //字符数相同，则满足一个条件
            if(sCount[sChar] == tCount[sChar]) {
                counted++;
            }
            //当所有条件都满足，开始移动 left，缩小窗口。同时 left 不能超过 right
            while (left <= right && count == counted) {
                if(res == null) {
                    res = new Result(left, right);
                }else {
                    if((right - left) < (res.right - res.left)) {
                        //更新结果集
                        res = new Result(left,right);
                    }
                }
                //移动left
                char leftChar = sChars[left];
                sCount[leftChar]--;
                //更新counted的值
                if(sCount[leftChar] < tCount[leftChar]) {
                    counted--;
                }
                left++;
            }
        }
        return res == null ? "":new String(sChars,res.left,res.right - res.left + 1);
    }

    /**
     * 用来存储结果字符串的起始和结束位置
     */
    static class Result{
         int left;
         int right;

        public Result(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
