package doubleIndex;

/**
 * 盛水最多的容器
 */
public class E005maxArea {
    public int maxArea(int[] height) {
        //容量：宽度 * 高度
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right){
            int min = Math.min(height[left],height[right]);
            res = Math.max(min * (right - left),res);
            if(min == height[left]){
                left = left + 1;
            }else {
                right = right - 1;
            }
        }
        return res;
    }
}
