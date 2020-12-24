package old.day0412;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wings
 * @description 51题N皇后问题
 */
public class Lc51Nqueen {

    public static void main(String[] args) {
        int a = 2;
        int b = a++ << ++a + ++a;
        System.out.println(b);
    }
}

class Solution {
    public List<String[]> solveNQueens(int n) {
        List<String[]> res = new ArrayList<>();
        // 用一维数组标记二维数组的元素时需要换算，所以boolean[]的长度为2*n
        helper(0, new boolean[n], new boolean[2 * n], new boolean[2 * n], new String[n], res);
        return res;
    }

    /**
     * @param y     棋盘横轴
     * @param cols
     * @param d1
     * @param d2
     * @param board
     * @param res
     */
    private void helper(int y, boolean[] cols, boolean[] d1, boolean[] d2, String[] board, List<String[]> res) {
        // 递归结束条件
        if (y == board.length) res.add(board.clone());
        else {
            // x棋盘纵轴
            for (int x = 0; x < board.length; x++) {
                // 计算当前坐标的撇捺索引
                int na = y - x + board.length, pie = 2 * board.length - y - x - 1;
                // 如果当前列，左上方右上方都没有皇后
                if (!cols[x] && !d1[na] && !d2[pie]) {
                    char[] row = new char[board.length];
                    // 初始化当前行，向数组中传送'.'
                    Arrays.fill(row, '.');
                    // 在该位置放置皇后
                    row[x] = 'Q';
                    // 将当前行赋值到二维数组对应位置
                    board[y] = new String(row);
                    // 将三个方向置标记为皇后攻击区
                    cols[x] = true;
                    d1[na] = true;
                    d2[pie] = true;
                    // 递归找下一行皇后位置
                    helper(y + 1, cols, d1, d2, board, res);
                    // 回溯，撤销该皇后攻击区的标记
                    cols[x] = false;
                    d1[na] = false;
                    d2[pie] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().solveNQueens(4).toArray()));
    }
}
