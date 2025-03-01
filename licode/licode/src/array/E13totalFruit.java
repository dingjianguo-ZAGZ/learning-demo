package array;

import java.util.HashMap;
import java.util.Map;

public class E13totalFruit {
    public static int totalFruit(int[] fruits) {
        //map用来存储水果的种类和对应数量
        Map<Integer,Integer> map = new HashMap<>();
        int l = 0;
        int count = 0;

        int result = 0;
        for (int r = 0; r < fruits.length; r++) {
            //当前树的水果种类
            int type = fruits[r];
            map.put(type,map.getOrDefault(type,0)+1);
            while(map.size()>2){
                //开始滑动窗口
                int lCount = map.get(fruits[l])-1;
                map.put(fruits[l],lCount);
                //当此时该种水果的数量为0，则从map中移除
                if(lCount == 0){
                    map.remove(fruits[l]);
                }
                l++;
            }
            result = Math.max(result,r-l+1);
        }
        return result;
    }
    /*public int totalFruit(int[] fruits) {
        int len = fruits.length;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0; // 滑动窗口的起始位置
        int result = 0;
        for (int right = 0; right < len; right++) { // 滑动窗口的终止位置
            // 使用哈希表存储这个窗口内的数以及出现的次数 【出现的数-出现的次数】
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) { // 因为果篮只有两个，当出现的数超过三个，就需要移动起始位置，缩小窗口
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) { // 如果窗口的起始位置移动到某个数全部的右面，从哈希表删除这个数
                    map.remove(fruits[left]);
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }*/

    public static void main(String[] args) {
        int[] f = new int[]{3,3,3,1,2,1,1,2,3,3,4};
        int i = totalFruit(f);
        System.out.println(i);
    }
}
