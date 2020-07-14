/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BACKTRACKING;

/**
 *
 * @author ravisharma
 */
public class N_QueenProblem {
    final int N=4;
    public static void main(String[] args) {
        N_QueenProblem Queen = new N_QueenProblem();
        Queen.solveNQ();
    }

    private void solveNQ() {
        int[][] board={
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
        };
        
        if (!solveNQUtil(board,0)){
            System.out.println("Solution does not exist");
            return;
        }
        printSolution(board);
        return;
    }

    private boolean solveNQUtil(int[][] board, int col) {
        if (col>=N) return true;
        
        for (int i=0;i<N;i++){
            if (isSafe(board,i,col)){
                board[i][col]=1;
                if (solveNQUtil(board,col+1)) return true;
                board[i][col]=0;
            }
        }
        return false;
        
    }

    private void printSolution(int[][] board) {
        for (int [] a: board){
            for (int b:a){
                System.out.print(b+" ");
            }
            System.out.println("");
        }
    }

    private boolean isSafe(int[][] board, int row, int col) {
    
        for (int i=0;i<col;i++){
            if (board[row][i] == 1) return false;
        }
        
        for (int i=row,j=col;i>=0 && j>=0;i--,j--){
            if (board[i][j]==1) return false;
        }
        
        for (int i=row,j=col; j>=0 && i<N ;i++,j--){
            if (board[i][j]==1) return false;
        }
        
        return true;
    }
    
}
