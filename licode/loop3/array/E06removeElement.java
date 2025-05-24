public class E06removeElement {
    public int removeElement(int[] nums, int val) {
        //双指针,快指针扫描，慢指针构建
        int s = 0; //新数组的下标
        //快指针寻找满足条件的元素
        for (int f = 0; f < nums.length; f++) {
            if(nums[f] != val){
                nums[s] = nums[f];
                s++;
            }
        }
        return s;
    }
}
