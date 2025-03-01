package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class E02intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i],1);
        }
        for (int i = 0; i < nums2.length; i++) {
            boolean bool = map.containsKey(nums2[i]);
            if(bool){
                set.add(nums2[i]);
            }

        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}
