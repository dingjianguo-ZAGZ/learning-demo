package hash;

import java.security.PublicKey;
import java.util.HashSet;

public class E03isHappy {
    public boolean isHappy(int n) {
        //找到true简单，关键在于什么时候返回false
        //无线循环，意味着sum会重复出现
        HashSet<Integer> set = new HashSet<>();

        while (n != 1 && !set.contains(n)) {
            n = getNextNum(n);
            set.add(n);
        }
        //走出循环，此时有两种情况
        //1. n == 1（true）,  2.sum重复(false)
        return n == 1;
    }

    public Integer getNextNum(int n) {
        int sum = 0;
        while (n != 0) {
            int i = n % 10;//获取个位数
            sum += i * i;
            n = n / 10;//去除各位
        }
        return sum;
    }
}
