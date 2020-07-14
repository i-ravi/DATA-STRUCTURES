package DYNAMIC_PROGRAMMING;

/**
 *
 * @author ravisharma
 */
public class LongestCommonSubsequence {  
    
    public static void main(String[] args) {
        String s1="ACD";
        String s2="CED";
        
        int[][] dp=new int[s1.length()][s2.length()];
        for (int i=0;i<dp.length;i++){
            for (int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(LCS(0,0,s1,s2));
        System.out.println(LCS(0,0,s1,s2,dp));
        for (int[] a:dp){
            for (int b:a)
                System.out.print(b+" ");
            System.out.println("");}
    }

    static int LCS(int i,int j,String s1,String s2){
        //base case
        if (i>=s1.length()||j>=s2.length()) return 0;
        //if our character matches
        if (s1.charAt(i)==s2.charAt(j)) return 1+LCS(i+1,j+1,s1,s2);
        
        else{
            //if our character not matches
            int left=LCS(i+1,j,s1,s2);
            int right=LCS(i,j+1,s1,s2);
            return Math.max(left, right);
        }
    }
    
    private static int LCS(int i, int j, String s1, String s2, int[][] dp) {
        //base case
        if (i>=s1.length() || j>=s2.length())  return 0;
        //we see if it is visited earlier or not
        if (dp[i][j]!=-1) return dp[i][j];
        //if our character macthes
        if (s1.charAt(i)==s2.charAt(j)) return 1+LCS(i+1,j+1,s1,s2,dp);
        
        //if our character not matches
        else{
            int left=LCS(i+1,j,s1,s2,dp);
            int right=LCS(i,j+1,s1,s2,dp);
            //store it in the dp
            return dp[i][j]=Math.max(left, right);
        }
    }
    
}
