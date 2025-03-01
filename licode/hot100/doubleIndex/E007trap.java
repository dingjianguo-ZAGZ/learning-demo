package doubleIndex;

/**
 * 接雨水
 */
public class E007trap {
    public int trap(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right){
            rightMax = Math.max(height[right],rightMax);
            leftMax = Math.max(height[left],rightMax);
            if(height[left] >= height[right]){
                res += rightMax - height[right];
                right--;
            }else {
                res += leftMax - height[left];
                left++;
            }
        }
        return res;
    }
}
