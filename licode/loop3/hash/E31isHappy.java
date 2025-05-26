package hash;

import java.util.HashMap;
import java.util.Map;

public class E31isHappy {
    Map<Integer, Integer> map = new HashMap<>();
    public boolean isHappy(int n) {
        int sum = 0;
        while (n != 1 && !map.containsKey(n)) {
            map.put(n, 1);
            n = getNum(n);
        }
        //退出循环
        //1. 出现重复
        //2. n==1
        return n == 1;
    }
    public int getNum(int n) {
        int sum = 0;
        while (n != 0) {
            int num = n % 10;
            sum += num * num;
            n = n / 10;
        }
        return sum;
    }
}
