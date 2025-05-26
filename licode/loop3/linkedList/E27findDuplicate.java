package linkedList;

public class E27findDuplicate {
    public int findDuplicate(int[] nums) {
        //构建链表
        //数组值作为下标 寻找next节点
        int s = 0,f = 0;
        do {
            s = nums[s];
            f = nums[nums[f]];//注意：值作为下标
        }while (s != f);
        // 找到环入口
        // 相遇后，慢指针回起点
        s = 0;
        while (s != f){
            s = nums[s];
            f = nums[f];
        }
        return s;

    }
}
