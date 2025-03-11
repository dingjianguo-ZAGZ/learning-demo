package heart;

public class E078jump {
    public int jump(int[] nums) {
        //局部最优：在局部最优中 找到下一个局部最优
        //局部最优，找到最长的覆盖范围，没有到达终点，再走下一步
        int range = 0; //当前覆盖最远下标
        int next = 0; //下一次覆盖最远下标
        int count = 0;
        int i = 0;
        while (i <= range && range < nums.length){
            next = Math.max(next,i+nums[i]);
            if(next >= nums.length){
                count++;
                break;
            }
            if(i == range){
                //移动下标等于当前覆盖的最远下标，不管是否是终点，直接count++
                //要实现这样的效果，让移动下标的最远 = num.length - 2
                range = next;
                count++;
            }
            i++;
        }
        return count;
    }
}
