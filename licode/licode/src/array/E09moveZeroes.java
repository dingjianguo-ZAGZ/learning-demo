package array;

public class E09moveZeroes {
    public void moveZeroes(int[] nums) {
        int f = 0;
        int l = 0;
        for (; f < nums.length; f++) {
            if(nums[f] != 0){
                int temp = nums[l];
                nums[l] = nums[f];
                nums[f] = temp;
                l++;
            }
        }

    }
}
