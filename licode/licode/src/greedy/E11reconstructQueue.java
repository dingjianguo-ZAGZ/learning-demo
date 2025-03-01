package greedy;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class E11reconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        //先确定一个维度：身高，按照身高从大到小排序
        //使用流
        Arrays.sort(people,(a,b)->{
            if(a[0] == b[0]) return a[1] - b[1]; //如果身高相同，则将 k 小的排在前面（升序）
            return b[0] - a[0];//按照身高降序
        });

        LinkedList<int[]> que = new LinkedList<>();
        for (int[] person : people) {
            //进行插入，k 作为下标插入，k 相同时， h 小的后插入，将 h 大的挤走，排在前面，不会影响 h 大的
            que.add(person[1],person);
        }
        return que.toArray(new int[people.length][]);
    }
}
