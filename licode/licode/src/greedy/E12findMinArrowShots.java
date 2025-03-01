package greedy;

import java.lang.annotation.Retention;
import java.util.Arrays;
import java.util.Comparator;

public class E12findMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparing(a->a[1]));//按照右边界升序排序
        int res = 1;
        int x = points[0][1];//第一箭从第一个球最有边界射出
        for (int[] point : points) {
            if(point[0] > x){
                x = point[1]; //如果气球的开始大于这一箭，则需要新的一箭，并且从该气球最右射出
                res++;
            }
        }
        return res;
    }
}
