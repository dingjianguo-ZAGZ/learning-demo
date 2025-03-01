package combine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E13solveNQueens {
    List<List<String>> res = new ArrayList<>();
    List<String> list = new ArrayList<>();
    //行递增填写，行不会冲突
    boolean[] currCol; // 列冲突
    boolean[] leftSlash; // 左斜线冲突(代表第几条斜线)
    boolean[] rightSlash; // 右斜线冲突
    char[][] chessBoard; // 棋盘
    public List<List<String>> solveNQueens(int n) {
        currCol = new boolean[n];
        leftSlash = new boolean[2*n - 1];
        rightSlash = new boolean[2*n - 1];
        chessBoard = new char[n][n];
        for (char[] chars : chessBoard) {
            Arrays.fill(chars,'.');
        }
        backtracking(n,0);
        return res;
    }
    private void backtracking(int n,int i){
        if(i == n){
            for (char[] chars : chessBoard) {
                StringBuilder sb = new StringBuilder();
                for (char c : chars) {
                    sb.append(c);
                }
                list.add(sb.toString());
            }
            res.add(new ArrayList<>(list));
            list.clear();
        }
        for (int j = 0; j < n; j++) {
            //遍历列
            if(currCol[j] || leftSlash[i+j] || rightSlash[n - 1 - (i - j)]){
                continue;
            }
            chessBoard[i][j] = 'Q';
            currCol[j] = leftSlash[i+j] = rightSlash[n - 1 - (i - j)] = true;//设置冲突
            backtracking(n,i+1);
            chessBoard[i][j] = '.';//回溯撤销皇后
            currCol[j] = leftSlash[i+j] = rightSlash[n - 1 - (i - j)] = false;//撤销冲突
        }
    }

}
