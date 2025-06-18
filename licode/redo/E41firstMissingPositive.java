import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class E41firstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        //数组流处理，进行去重排序
        nums = Arrays.stream(nums).distinct().filter(x -> x > 0).sorted().toArray();

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1){
                return i+1;
            }
        }
        return nums.length+1;
    }

    public static void main(String[] args) {
        //数组流处理，进行去重排序
        int[] array = Arrays.stream(new int[]{6,3,4,8,2,2,-1,-2,9}).distinct().filter(x -> x > 0).sorted().toArray();

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
