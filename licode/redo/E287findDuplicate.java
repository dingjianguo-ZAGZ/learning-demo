public class E287findDuplicate {
    public int findDuplicate(int[] nums) {
        //构建循环链表，将元素值作为索引
        int s = 0;
        int f = 0;
        do{
            s = nums[s];
            f = nums[nums[f]];
        }while (s != f);
        //s == f，找环的入口
        s = 0;
        while (s!=f){
            s= nums[s];
            f = nums[f];
        }
        return nums[s];

    }
}
