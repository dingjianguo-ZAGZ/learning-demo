package stack;

import java.util.LinkedList;

public class E071dailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        //维护当前没有找到下一个温度的下标
        LinkedList<Integer> stack_index = new LinkedList<>();
        int[] res = new int[temperatures.length]; //数组元素默认为0
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack_index.isEmpty() && temperatures[stack_index.peek()] < temperatures[i]){
                Integer preIndex = stack_index.pop();
                res[preIndex] = i - preIndex;
            }
            stack_index.push(i);
        }
        return res;
    }
}
