/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GRAPH;

/**
 *
 * @author ravisharma
 */
public class TravellingSalesmanProblem {
    
    static int tsp(boolean[] vis,int[][] arr,int currPos,int n,int count,int cost, int ans){
        if (count==n && arr[currPos][0]>0){
            ans=Math.min(ans, cost+arr[currPos][0]);
            return ans;
        }
        for (int i=0;i<n;i++){
            if (!vis[i] && arr[currPos][i]>0){
                vis[i]=true;
                ans=tsp(vis,arr,i,n,count+1,arr[currPos][i]+cost,ans);
                vis[i]=false;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        
        int n=4;
        
        int[][] arr =   {
            {0,10,15,20},
            {10,0,35,25},
            {15,35,0,30},
            {20,25,30,0}
        };
        
        boolean[] vis=new boolean[n];
        
        vis[0]=true;
        
        int ans=Integer.MAX_VALUE;
        
        ans=tsp(vis,arr,0,n,1,0,ans);
        
        System.out.println(ans);
    }
}
