package stack;

import java.lang.reflect.WildcardType;
import java.time.chrono.IsoChronology;
import java.util.Currency;
import java.util.LinkedList;

public class E072largestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if(len == 0) return 0;
        LinkedList<Integer> stack = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && (heights[i] < heights[stack.peek()])){
                //遇到了有边界，可以算出上一个的最大面积
                int height = heights[stack.pop()]; //当前高度
                int width;
                if(stack.isEmpty()){
                    width = i;
                }else {
                    width = i - stack.peek() - 1;
                }
                res = Math.max(res,height*width);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int height = heights[stack.pop()]; //当前高度
            int width;
            if(stack.isEmpty()){
                width = len;
            }else {
                width = len - stack.peek() - 1;
            }
            res = Math.max(res,height*width);
        }
        return res;
    }
}
    