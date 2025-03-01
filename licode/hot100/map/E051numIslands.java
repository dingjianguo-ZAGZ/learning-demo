package map;

/**
 * 岛屿数量
 */
public class E051numIslands {
    public int numIslands(char[][] grid) {
        //定义岛屿的数量
        int res = 0;
        //两个for循环，利用i,j来确定陆地的位置
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    //依次对每个陆地进行深度优先搜索
                    dfs(grid, i, j);
                    //对一个节点进行深度优先搜索后，会将与其相邻的所有陆地标记为 2，此时形成了一块岛屿
                    //由于已经被标记为 2，所以不会重复遍历
                    //岛屿数量+1
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        //定义递归头
        //当下标越界或者当前的位置是海洋 或 已经遍历过（已经和其他陆地连成了岛屿）
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        //将遍历过的节点标记为 2，防止重复遍历和循环遍历
        grid[i][j] = '2';
        //对这个节点进行深度优先搜索
        //按照左上右下的顺序
        dfs(grid,i,j-1);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i+1,j);
    }
}
