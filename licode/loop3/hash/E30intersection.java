package hash;

import java.util.*;

public class E30intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!map.containsKey(nums1[i])){
                map.put(nums1[i],1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if(map.containsKey(nums2[i])){
                res.add(nums2[i]);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
