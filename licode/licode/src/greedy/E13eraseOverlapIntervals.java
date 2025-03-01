package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 *435 无重叠区间
 */
public class E13eraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        //逆向思维，找到无重复区间的个数
        int res = 1;//无重复区间的个数，最后总会留下一个
        Arrays.sort(intervals, Comparator.comparingInt(a->a[1]));//按照区间右边界升序排序
        int x = intervals[0][1];//第一个右边界
        for (int[] interval : intervals) {
            if(interval[0] >= x){
                //当前区间的左边界大于当前有边界，说明找到了一个无重复区间
                x = interval[1];
                res++;
            }
        }
        //区间总数 - 无重复区间的个数 = 需要移除的区间个数
        return intervals.length-res;
    }
}
