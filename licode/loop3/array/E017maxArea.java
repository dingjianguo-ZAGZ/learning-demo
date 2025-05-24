import java.net.http.HttpRequest;

/**
 * 盛水最多的容器
 */
public class E017maxArea {
    public int maxArea(int[] height) {
        int res = 0;
        //左右指针
        int l = 0;
        int r = height.length - 1;
        while (l<r){
            res = Math.max(res,(r-l)*Math.min(height[l],height[r]));
            //移动低的挡板
            if(height[l] <= height[r]){
                l++;
            }else {
                r--;
            }
        }
        return res;
    }
}
