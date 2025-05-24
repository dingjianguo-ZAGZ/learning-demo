import java.util.Arrays;

public class E019firstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        //使用数组本身当哈希表，1放到0位置，如果0位置没有1 ，说明缺失的就是1，以此类推
        int[] array = Arrays.stream(nums)
                .distinct()//去重
                .filter(x -> x > 0)
                .sorted()
                .toArray();
        for (int i = 0; i < array.length; i++) {
            if(array[i] - 1 != i){
                // i = 1 如果array[1]-1 !=  1，说明array[1]位置不是2，缺少2
                return i+1;
            }
        }
        return array.length+1;
    }
}
