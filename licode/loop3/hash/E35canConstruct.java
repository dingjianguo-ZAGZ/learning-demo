package hash;

import java.util.HashMap;
import java.util.Map;

public class E35canConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] mc = magazine.toCharArray();
        int[] map = new int[26];
        for (int i = 0; i < mc.length; i++) {
            map[mc[i] - 'a'] += 1;
        }
        char[] rc = ransomNote.toCharArray();
        for (int i = 0; i < rc.length; i++) {
            if(map[rc[i] - 'a'] <= 0){
                return false;
            }
            map[rc[i] - 'a']--;
        }
        return true;
    }
}
