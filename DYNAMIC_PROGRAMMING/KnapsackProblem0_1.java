/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DYNAMIC_PROGRAMMING;

/**
 *
 * @author ravisharma
 */
public class KnapsackProblem0_1 {
    public static void main(String[] args) {
        int[] wt={1,1,1};
        int[] val={10,20,30};
        int W=2;
        int[][] dp=new int[wt.length][W+1];
        for (int i=0;i<dp.length;i++) for (int j=0;j<dp[0].length;j++) dp[i][j]=-1;
        System.out.println(kp(0,wt,val,W,dp));
    }

    private static int kp(int i,int[] wt, int[] val, int W,int[][] dp) {
        //base case 1 when we face ArrayIndexOutOfBound Exception
        if (i>=wt.length) return 0;
        //base case 2 when we have completed the weight
        if (W==0) return 0;
        //to check if visited of not
        if (dp[i][W]!=-1) return dp[i][W];
        
        else{
        //if the current element weight is less tha or equal to total Weight
        if (wt[i]<=W){
            //take the current element, add its value and subtract it from the total Weight
            int left=val[i]+kp(i+1,wt,val,W-wt[i],dp);
            //dont take the current element
            int right=kp(i+1,wt,val,W,dp);
            return dp[i][W]=Math.max(left, right);
        }
        //if not go to next element
        else{
            return dp[i][W]=kp(i+1,wt,val,W,dp);
        }}
    }
    
}
