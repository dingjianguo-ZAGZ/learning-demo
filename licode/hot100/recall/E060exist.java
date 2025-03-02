package recall;

/**
 * 单词搜索
 */
public class E060exist {
    public boolean exist(char[][] board, String word) {
        //拆分成子问题，判断从一个位置开始，是否能找到以某个字符开头的字符串
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, boolean[][] visited, int i, int j, String word, int k) {
        char c = word.charAt(k);
        if (board[i][j] != c) {
            return false;
        } else if (k == word.length() - 1) {
            //在上面已经将 board[i][j] != c 的情况排除，所以此时
            //是单词最后一个字母，并且找到了，返回true
            return true;
        }
        //找到，但不是最后一个字符
        visited[i][j] = true;
        //对当前位置 的上下左右四个 方向寻找匹配下一个字符的位置
        int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};//向每个方向的偏移量
        //定义返回结果
        boolean res = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            //判断新的位置是否在图中
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length){
                if(!visited[newi][newj]){
                    //这个位置的字符没有被使用过
                    boolean flag = check(board,visited,newi,newj,word,k+1);
                    if(flag){
                        res = true;
                        break;
                    }
                }
            }
        }
        //如果在这一个方向没有找到，则向另一个方向找
        //回溯，清除当前标记
        visited[i][j] = false;
        return res;
    }
}
