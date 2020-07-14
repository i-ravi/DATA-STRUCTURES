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
public class CoinChangingProblem {
    
    public static void main(String[] args) {
        int[] arr={1,2,3};
        int sum=4;
        int[][] dp=new int[arr.length][sum+1];
        
        for (int i=0;i<dp.length;i++) for (int j=0;j<dp[0].length;j++) dp[i][j]=-1;
        System.out.println(coin(0,sum,arr,dp));
        
        
    }

    private static int coin(int i, int sum, int[] arr,int[][] dp) {
        //base case 1 if sum becomes 0
        if (sum==0) return 1;
        //base case 2 handling ArrayIndexOutOfBound and when sum becomes negative
        if (i>=arr.length || sum<0) return 0;
        //we see if it is already visited or not
        if (dp[i][sum]!=-1) return dp[i][sum];
        else{
            //we take value and subtract it from sum
            int left=coin(i,sum-arr[i],arr,dp);
            //we dont take the value 
            int right=coin(i+1,sum,arr,dp);
            return dp[i][sum]=left+right;
        }
    }
    
}
