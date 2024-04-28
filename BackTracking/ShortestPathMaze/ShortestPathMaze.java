/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BACKTRACKING;

import java.util.ArrayList;

/**
 *
 * @author ravisharma
 */
public class ShortestPathMaze {
    public static void main(String[] args) {
        int[][] arr=new int[][]{
        {5,1,2,1,23},
        {1,3,2,1,23},
        {5,3,2,1,23},
        {5,3,2,1,1},
        {5,3,2,1,23},
    };
        long x=shortestPath(arr,0,0,4,4);
        if (x>100000) System.out.println("no path exist");
        else System.out.println(x);
    }
    static long shortestPath(int[][] arr,int i,int j,int x,int y){
        int row=arr.length;
        int col=arr[0].length;
        
        boolean[][] vis=new boolean[row][col];
        
        return arr[i][j]+shortestPath(arr,i,j,x,y,vis);
    }
    static boolean isValid(int arr[][],int i,int j,boolean vis[][]){
        int row=arr.length;
        int col=arr[0].length;
        
        return i>=0 && j>=0 && i<row && j<col && !vis[i][j] ;
        
        //if binary matrix
        //return i>=0 && j>=0 && i<row && j<col && !vis[i][j] && arr[i][j]==1 ;
    }
    static long shortestPath(int[][] arr,int i,int j,int x,int y,boolean vis[][]){
        if (!isValid(arr,i,j,vis)) return Integer.MAX_VALUE;
        if (i==x && j==y) return 0;
        
        vis[i][j]=true;
        
        long up=Integer.MAX_VALUE,down=Integer.MAX_VALUE,left=Integer.MAX_VALUE,right=Integer.MAX_VALUE;
        if(i>0)  up=shortestPath(arr,i-1,j,x,y,vis)+arr[i-1][j];
        if (i<arr.length-1) down=shortestPath(arr,i+1,j,x,y,vis)+arr[i+1][j];
        if (j>0) left=shortestPath(arr,i,j-1,x,y,vis)+arr[i][j-1];
        if (j<arr[0].length-1)  right=shortestPath(arr,i,j+1,x,y,vis)+arr[i][j+1];
        
        //if binary marix
        //up=shortestPath(arr,i-1,j,x,y,vis)+1;
        //down=shortestPath(arr,i+1,j,x,y,vis)+1;
        //left=shortestPath(arr,i,j-1,x,y,vis)+1;
        //right=shortestPath(arr,i,j+1,x,y,vis)+1;
        //this is where backtracking works
        vis[i][j]=false;
        return Math.min(Math.min(left, right),Math.min(up,down));
    }
    
}
