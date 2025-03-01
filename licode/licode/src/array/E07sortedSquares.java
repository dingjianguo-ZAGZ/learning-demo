package array;

public class E07sortedSquares {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i]=nums[i]*nums[i];
        }
        // 16 1 0 9 100
        //       9 16  100
        int low = 0;
        int high = nums.length-1;
        int[] arr = new int[nums.length];
        int x = arr.length-1;
        while(low<=high){
            if(nums[low]<nums[high]){
                arr[x] = nums[high];
                high--;
            }else {
                arr[x] = nums[low];
                low++;
            }
            x--;
        }

        return arr;
    }
}
