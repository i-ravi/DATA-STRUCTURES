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
public class Rat_In_A_Maze {
    static int N;
    public static void main(String[] args) {
        Rat_In_A_Maze rat=new Rat_In_A_Maze();
        
        int maze[][] ={
            {1, 0, 0, 1, 0},
            {1, 1, 0, 1, 0},
            {0, 1, 0, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1}
        };
        
        N=maze.length;
        rat.solveMaze(maze);
    }

    private void solveMaze(int[][] maze) {
        int solve[][] =new int[N][N];
        
        if (!solveMazeUtil(maze,0,0,solve)){
            System.out.println("Solution does't exist");
            return;
        }
        printSolution(solve);
        return;
    }

    private boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol) {
        if (x==N-1 && y==N-1 && maze[x][y]==1){
            sol[x][y]=1;
            return true;
        }
        if (isSafe(maze,x,y)){
            sol[x][y]=1;
            if (solveMazeUtil(maze,x+1,y,sol)) return true;
            if (solveMazeUtil(maze,x,y+1,sol)) return true;
            
            sol[x][y]=0;
            return false;
        }
        return false;
    }

    private boolean isSafe(int[][] maze, int x, int y) {
        if (x>=0 && y>=0 && x<N && y<N & maze[x][y]==1) return true;
        return false;
    }

    private void printSolution(int[][] solve) {
        for (int[] a:solve){
            for (int b: a){
                System.out.print(b+" ");
            }
            System.out.println("");
        }
    }
    
}
