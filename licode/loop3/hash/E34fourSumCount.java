package hash;

import java.util.HashMap;
import java.util.Map;

public class E34fourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map = new HashMap<>();
        //分成两组
        for (int i : nums1) {
            for (int j : nums2) {
                map.put(i+j,map.getOrDefault(i+j,0)+1);
            }
        }
        int res = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                res += map.getOrDefault(- (i + j),0);
            }
        }
        return res;
    }
}
