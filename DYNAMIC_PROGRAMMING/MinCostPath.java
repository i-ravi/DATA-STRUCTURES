
package DYNAMIC_PROGRAMMING;
/**
 *
 * @author ravisharma
 */
public class MinCostPath {
    static int MCP(int i,int j,int[][] mat,int[][] dp){
        //if we reach the destination simply return the value
        if (i==mat.length-1 && j==mat[0].length-1) return mat[mat.length-1][mat[0].length-1];
        //base condition when we reach a point which is outside the matrix
        if (i>=mat.length || j>=mat[0].length) return 25000;
        //check if we have visited or not
        if (dp[i][j]!=-1) return dp[i][j];
        //right-> j+1
        //down->  i+1
        int right=mat[i][j]+MCP(i,j+1,mat,dp);
        int down=mat[i][j]+MCP(i+1,j,mat,dp);
        //return the min value
        return dp[i][j]=Math.min(right, down);
    }
    
    public static void main(String[] args) {
        int[][] mat={
            {1,2,3},
            {4,8,2},
            {1,5,3}
        };
        int[][] dp=new int[mat.length][mat[0].length];
        for (int i=0;i<dp.length;i++) for (int j=0;j<mat[0].length;j++) dp[i][j]=-1;
        System.out.println(MCP(0,0,mat,dp));
        for (int[] a:dp){
            for (int b:a) System.out.print(b+" ");
            System.out.println("");
        }
    }
}
