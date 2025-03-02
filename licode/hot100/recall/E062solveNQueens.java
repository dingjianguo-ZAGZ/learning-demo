package recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E062solveNQueens {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    boolean[] column;
    boolean[] left;
    boolean[] right;
    char[][] chessBoard;

    public List<List<String>> solveNQueens(int n) {
        //因为是按照行的顺序进行放置，所以行冲突不用记录
        column = new boolean[n];//记录列冲突
        left = new boolean[2 * n - 1];//一共有2*n-1条左斜线，记录第几条左斜线有冲突
        right = new boolean[2 * n - 1];//记录右斜线冲突
        chessBoard = new char[n][n];//棋盘
        //填充棋盘
        for (char[] chars : chessBoard) {
            Arrays.fill(chars, '.');
        }
        dfs(0, n);
        return res;
    }

    /**
     * @param i 第几行
     * @param n 棋盘大小
     */
    public void dfs(int i, int n) {
        //定义递归头
        if (i == n) {
            //所有皇后都放完
            for (char[] chars : chessBoard) {
                StringBuilder sb = new StringBuilder();
                for (char c : chars) {
                    sb.append(c);
                }
                path.add(sb.toString());
            }
            res.add(new ArrayList<>(path));
            path.clear();
        }
        //对列遍历，判断在这一行应该放在哪个位置
        for (int j = 0; j < n; j++) {
            if (column[j] || left[i + j] || right[n - 1 - (i - j)]) {
                //发生冲突
                continue;
            }
            //放置皇后
            chessBoard[i][j] = 'Q';
            //记录冲突
            column[j] = left[i + j] = right[n - 1 - (i - j)] = true;
            //放置下一行
            dfs(i + 1, n);
            //回溯
            chessBoard[i][j] = '.';
            //删除冲突记录
            column[j] = left[i + j] = right[n - 1 - (i - j)] = false;
        }

    }
}
