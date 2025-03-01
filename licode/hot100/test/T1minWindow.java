//package test;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class T1minWindow {
//    public String minWindow(String s, String t) {
//        int left = 0;
//        int right = 0;
//        int count = 0;
//        Result result = new Result(left, s.length() - 1);
//        int res = right - left;
//        Map<Character, Integer> tMap = new HashMap<>();
//        char[] sCharArray = s.toCharArray();
//        char[] tCharArray = t.toCharArray();
//        for (int i = 0; i < tCharArray.length; i++) {
//            tMap.put(tCharArray[i], tMap.getOrDefault(tCharArray[i], 0) + 1);
//        }
//        while (count != t.length()) {
//            for (int i = left; i < sCharArray.length; i++) {
//                if (tMap.containsKey(sCharArray[i])) {
//                    right++;
//                    if (tMap.get(sCharArray[i]) > 0) {
//                        tMap.put(sCharArray[i], tMap.get(sCharArray[i]) - 1);
//                        count++;
//                    }
//
//                    //记录最小窗口
//                    if (right - left < res) {
//                        result = new Result(left, right);
//                    }
//                    //开始移动窗口
//
//                }
//            }
//        }
//    }
//
//}
//
//class Result {
//    int left;
//    int right;
//
//    public Result(int left, int right) {
//        this.left = left;
//        this.right = right;
//    }
//}
