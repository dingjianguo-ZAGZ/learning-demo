package array;

import java.util.*;

public class E014merge {
    public int[][] merge(int[][] intervals) {
        //定义结果集
        //双向联编，方便从尾部获取值
        LinkedList<int[]> list = new LinkedList<>();
        //按照起始位置排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        //默认加入第一个区间
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            //当有重叠时(后一个区间的左边界，小于前一个区间的右边界)，合并区间
            if(intervals[i][0] <= list.getLast()[1]){
                int left = list.getLast()[0];
                int right = Math.max(list.getLast()[1],intervals[i][1]);
                //移除最后一个区间
                list.removeLast();
                //添加合并后的区间
                list.addLast(new int[]{left,right});
            }else {
                //区间没有重叠，直接添加
                list.addLast(intervals[i]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
