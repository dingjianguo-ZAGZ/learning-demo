import java.lang.reflect.Array;
import java.util.Arrays;

public class E07sortedSquares {
    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        int index = nums.length - 1;
        for (int i = 0,j = nums.length - 1; i <= j;) {
            //最大值在两边，
            if(nums[i] * nums[i] > nums[j] * nums[j]){
                res[index] = nums[i] * nums[i];
                //移动左指针
                i++;
            }else {
                res[index] = nums[j] * nums[j];
                //移动右指针
                j--;
            }
            index--;
        }
        return res;
    }
}
