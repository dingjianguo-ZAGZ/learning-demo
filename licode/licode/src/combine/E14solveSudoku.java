package combine;

import java.util.Base64;

public class E14solveSudoku {
    boolean[][] ca = new boolean[9][9]; // 行冲突
    boolean[][] cb = new boolean[9][9]; // 列冲突
    boolean[][] cc = new boolean[9][9]; // 九宫格冲突

    public void solveSudoku(char[][] board) {
        //记录当前数独中已经存在的数字
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {//记录当前数字
                    //当前数字在当前行，当前列，当前九宫格设置为冲突
                    ca[i][c - '1'] = true;
                    cb[j][c - '1'] = true;
                    ca[i / 3 * 3 + j / 3][c - '1'] = true;
                }
            }
        }
        backtracking(board, 0, 0);
    }

    private boolean backtracking(char[][] board, int i, int j) {
        //跳过数独中已有数字的部分
        while (board[i][j] != '.') {
            if (++j >= 9) {
                j = 0;
                i++;
            }
            if (i >= 9) {
                return true;
            }
        }
        //从没有数字的地方从1到9尝试
        for (int x = 1; x <= 9; x++) {
            if (ca[i][x - 1] || cb[j][x - 1] || cc[i / 3 * 3 + j / 3][x - 1]) {
                continue;
            }
            //如果没有冲突，添加数字
            board[i][j] = (char) (x + '0');
            ca[i][x - 1] = cb[j][x - 1] = cc[i / 3 * 3 + j / 3][x - 1] = true;
            //递归
            boolean dfs = backtracking(board, i, j);
            if (dfs) {
                //没有冲突
                return true;
            }
            //有冲突，回溯
            board[i][j] = '.';
            ca[i][x - 1] = cb[j][x - 1] = cc[i / 3 * 3 + j / 3][x - 1] = false;
        }
        return false;
    }
}