package dynamic;

import java.util.ArrayList;
import java.util.List;

public class E081generate {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> generate(int numRows) {
        // 当前元素的值 = 上一行 dp[i-1]+dp[i]
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                //第 i 行 第 j 个数字
                if(j == 0 || j == i) {
                    list.add(1); //每一行第一个 和最后一个元素 元素是 1
                } else {
                    list.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                }
            }
            //处理完一行，加入结果集
            res.add(list);
        }
        return res;
    }
}
