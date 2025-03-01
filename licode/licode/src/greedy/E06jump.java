package greedy;

public class E06jump {
    public int jump(int[] nums) {
        //2 3 1 1 4     3 2 1 0 4
        //解题思路：不用考虑怎么走步数最少，考虑在覆盖范围内步数最小，什么时候步数必须加一
        int res = 0;
        //当前覆盖最远距离下标
        int cover = 0;
        //下一步之后覆盖最远距离下标
        int next = 0;
        for (int i = 0; i < nums.length-1 && i <= cover; i++) {
            //下一步能覆盖的最远距离
            next = Math.max(nums[i] + i,next);//2 4 4
            //下一步能够覆盖直接返回
            if(next >= nums.length){
                res++;
                break;
            }
            //走到覆盖范围的最末尾，必须走下一步
            if(i == cover){
                cover = next;
                res++;//1
            }
        }
        return res;
    }
}
