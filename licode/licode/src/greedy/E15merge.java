package greedy;

import java.util.*;

public class E15merge {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        //按照起始位置进行升序排序
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        //先将第一个区间放入
        res.addLast(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            //当前区间的起点小于集合中最后一个区间的终点，需要将当前区间合并入最后一个区间
            if(intervals[i][0] <= res.getLast()[1]){
                //重新设置起点和终点，起点，不变，终点，当前区间和原来区间的最大值
                int start = res.getLast()[0];
                int end = Math.max(intervals[i][1],res.getLast()[1]);
                //将最后一个区间移除
                res.removeLast();
                //重新加入
                res.addLast(new int[]{start,end});
            }else {
                //不重叠，直接加入
                res.addLast(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
