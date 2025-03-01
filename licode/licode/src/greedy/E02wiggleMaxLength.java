package greedy;

public class E02wiggleMaxLength {
    public static int wiggleMaxLength(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        int preDiff = 0;
        int curDiff = 0;
        int res = 1;//默认最右端为摆动序列
        for (int i = 0; i < nums.length-1; i++) {
            curDiff = nums[i+1]-nums[i];
            if((preDiff <= 0 && curDiff > 0) || (preDiff >= 0 && curDiff < 0)){
                res++;
                preDiff = curDiff;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,17,5,10,13,15,10,5,16,8};
        wiggleMaxLength(nums);
    }
}
