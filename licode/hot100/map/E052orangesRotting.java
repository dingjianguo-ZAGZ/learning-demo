package map;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 腐烂的橘子
 */
public class E052orangesRotting {
    public int orangesRotting(int[][] grid) {
        int m = grid.length; //图的下边界
        int n = grid[0].length; //图的右边界
        int count = 0;//新鲜橘子的个数
        Queue<int[]> queue = new LinkedList<>();//保存腐烂橘子的位置
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;//新鲜橘子的数量+1
                } else if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int round = 0;//经过的分钟数，也就是层序遍历的层数
        while (!queue.isEmpty() && count > 0) {
            round++;//每经过一层，分钟数 +1
            int size = queue.size();
            //遍历每一层的节点
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int r = poll[0];//当前腐烂的橘子所在行
                int c = poll[1];//当前腐烂的橘子所在列
                //左
                //位置上的橘子在图中，并且有新鲜的橘子
                if(inArea(m,n,r,c-1) && grid[r][c-1] == 1){
                    grid[r][c-1] = 2;//将该位置的橘子标记为腐烂
                    count--;//新鲜橘子数量 -1
                    queue.offer(new int[]{r,c-1});//将该位置放入队列
                }
                //上
                if(inArea(m,n,r-1,c) && grid[r-1][c] == 1){
                    grid[r-1][c] = 2;//将该位置的橘子标记为腐烂
                    count--;//新鲜橘子数量 -1
                    queue.offer(new int[]{r-1,c});//将该位置放入队列
                }
                //右
                if(inArea(m,n,r,c+1) && grid[r][c+1] == 1){
                    grid[r][c+1] = 2;//将该位置的橘子标记为腐烂
                    count--;//新鲜橘子数量 -1
                    queue.offer(new int[]{r,c+1});//将该位置放入队列
                }
                //下
                if(inArea(m,n,r+1,c) && grid[r+1][c] == 1){
                    grid[r+1][c] = 2;//将该位置的橘子标记为腐烂
                    count--;//新鲜橘子数量 -1
                    queue.offer(new int[]{r+1,c});//将该位置放入队列
                }
            }
        }
        //判断是否还有新鲜橘子
        if(count > 0){
            return -1;
        }else {
            return round;
        }
    }

    public boolean inArea(int m, int n, int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }


}
