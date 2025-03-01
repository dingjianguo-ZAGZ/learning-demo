package hash;


/**
 * 字母异位词
 */
public class E01isAnagram {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            arr[index]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            arr[index]--;
        }
        //遍历数组，数组中元素值都为0返回true
        for (int i : arr) {
            if(i != 0){
                return false;
            }
        }
        return true;
    }
}
