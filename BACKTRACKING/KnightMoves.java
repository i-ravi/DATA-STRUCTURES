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

public class KnightMoves {
    static int N=8;
    public static void main(String[] args) {
        solveKT();
    }

    static boolean solveKT() {
        
        int sol[][] =new int[8][8];
        
        for(int i=0;i<N;i++) 
            for(int j=0;j<N;j++) 
                sol[i][j]=-1;
        
        int[] xMove={2,1,-1,-2,-2,-1,1,2};
        int[] yMove={1,2,2,1,-1,-2,-2,-1};
        
        sol[0][0]=0;
                
        if (!solveKTUtil(0,0,1,sol,xMove,yMove)){
            System.out.println("Solution doesn't exist");
            return false;}
        else 
            printSolution(sol);
        
        return true;
        
    }

    static boolean solveKTUtil(int x, int y, int move, int[][] sol, int[] xMove, int[] yMove) {
        
        int next_x,next_y;
        
        if (move == N*N) 
            return true;
        
        for (int k=0;k<N;k++){
            
            next_x=x+xMove[k];
            next_y=y+yMove[k];
            
            if (isSafe(next_x,next_y,sol)){
                
                sol[next_x][next_y] = move;
                
                if (solveKTUtil(next_x,next_y,move+1,sol,xMove,yMove)) 
                    return true;
                else 
                    sol[next_x][next_y]=-1;
            }
                
        }
        return false;
    }

    static boolean isSafe(int x, int y,int[][] sol) {
        return (x >= 0 && x < N && y >= 0 &&  y < N && sol[x][y] == -1); 
    }
    
    static void printSolution(int[][] sol) {
        for (int x = 0; x < N; x++) { 
            for (int y = 0; y < N; y++) 
                System.out.print(sol[x][y] + " "); 
            System.out.println(); 
        }
    }
    
}


