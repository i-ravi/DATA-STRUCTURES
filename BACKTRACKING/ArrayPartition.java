package BACKTRACKING;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ravisharma
 */
public class ArrayPartition {
    public static void main(String[] args) {
        int[] arr={2,1,2,3,4,8};
        //stream functions can be used to find array sum
        int sum=Arrays.stream(arr).sum();
        //this stores an array of element having element sum as half of whole array
        ArrayList<Integer> a =new ArrayList<Integer>();
        //this checks if the sum of array is even or not and calls the partition method
        boolean isPossible= (sum&1)==0 && partition(arr,sum/2,0,a);
        if (isPossible){
            for (int i:a) System.out.print(i+" ");
        }
        else{
            System.out.println("not possible");
        }
         
    }
    static boolean partition(int[] arr,int sum,int i,ArrayList<Integer> a){
        //base condition when we step out of the array or sum becomes negative if any of the condition is true it return FALSE
        if (i>=arr.length || sum<0) return false;
        //if the sum is 0 we have succesfully partioned the array
        if (sum==0) return true;
        a.add(arr[i]);
        //checks if it is ppossible to add the current element or not
        boolean leftPossible=partition(arr,sum-arr[i],i+1,a);
        //if possible it returns TRUE
        if (leftPossible) return true;
        //Else we remove the current element and move ahead
        //this makes backtracking possible
        a.remove(a.size()-1);
        return partition(arr,sum,i+1,a);
    }
}
