
package DYNAMIC_PROGRAMMING;

/**
 *
 * @author ravisharma
 */
public class MatrixChainMultiplication {
    
    public static void main(String[] args) {
        int[] arr={40,20,30,10,30};
        
        int[][] dp=new int[arr.length][arr.length];
        for (int i=0;i<dp.length;i++) for (int j=0;j<dp[0].length;j++) dp[i][j]=-1;
        System.out.println(MCM(1,4,arr,dp));
    }

    static int MCM(int i, int j, int[] arr,int[][] dp) {
        if (i==j) return 0;
        
        int min=Integer.MAX_VALUE;
        
        if (dp[i][j]!=-1) return dp[i][j];
        
        for (int k=i;k<j;k++){
            int count=MCM(i,k,arr,dp)+MCM(k+1,j,arr,dp)+arr[i-1]*arr[k]*arr[j];
            if (min>count) min=count;
            
        }
        return dp[i][j]=(int)min;
    }
    
}
