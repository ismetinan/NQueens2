public class Solution {
    public int totalNQueens(int n) {
        int[][] board = new int[n][n];

        
        int check = 0;
        
        return solveNQueens(board, 0, 0, check,0,-1);

    }

    private int solveNQueens(int[][] board, int row, int num,int check,int column,int prevColumn) {
        if (check == board.length) {
            num++;
            check = 0;
        }
        if (row == board.length) {
            return num;
        }
        for (int i = column ; i < board.length; i++) {
            if (!attacks(board, row, i) && i != prevColumn) {
                board[row][i] = 1;
                
                num = solveNQueens(board, row + 1, num, check + 1,0,prevColumn);
                board[row][i] = 0;
            }
            if (i == board.length - 1 && row > 0 && prevColumn >= 0) {
                board[row - 1][prevColumn] = 0;
                num = solveNQueens(board, row - 1, num, check,column + 1,prevColumn);
            }
        }
        return num;
    }
    private boolean attacks(int[][] board, int i, int j) {
        int n = board.length;
        // check row and column
        for (int k = 0; k < n; k++) {
            if (board[i][k] == 1 || board[k][j] == 1) {
                return true;
            }
        }
        //check diagonals
        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                if ((k + l == i + j || k - l == i - j) && board[k][l] == 1) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.totalNQueens(5));
    }
}