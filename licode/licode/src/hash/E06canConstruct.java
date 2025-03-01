package hash;

import javax.swing.text.StyledEditorKit;
import java.util.HashMap;

public class E06canConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (char c : ransomNote.toCharArray()) {
            arr[c - 'a']++;
        }
        for (char c : magazine.toCharArray()) {
            arr[c - 'a']--;
        }
        for (int i : arr) {
            if(i > 0){
                return true;
            }
        }
        return false;
    }
}
