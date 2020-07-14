/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DYNAMIC_PROGRAMMING;

import java.util.Arrays;

/**
 *
 * @author ravisharma
 */
public class LongestIncreasingSubsequence {
    
    static int lis(int[] arr){
        int[] lis=new int[arr.length];
        //take each element
        for (int i = 1; i < arr.length; i++ ) {
            lis[i] = 1;
            //check previous elements if smaller than current 
            //and lis value is greater of that than change the lis value
            for (int j = 0; j < i; j++ )  
                if ( arr[i] > arr[j] && lis[i] < lis[j] + 1) 
                    lis[i] = lis[j] + 1;
        }
        //return the max value from lis array
        return Arrays.stream(lis).max().getAsInt();
    }
    
    public static void main(String[] args) {
        int[] arr={50, 3, 10, 7, 40, 80};
        
        System.out.println(lis(arr));
    }    
}
