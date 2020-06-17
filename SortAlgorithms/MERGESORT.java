/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortAlgorithms;

import java.util.Arrays;

/**
 *
 * @author ravisharma
 */
public class MERGESORT {
    public static void main(String[] args) {
        int arr[]={24,35,21,2,1,67,199,21};
        mergesort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void mergesort(int arr[]){
        //n stores the array length of arr
        int n=arr.length;
        // it simply return if the array is of size 1
        if (n<2) return;
        // mid stores to half of array length
        int mid=n/2;
        // array is created to store 1st half of the array
        int[] l=new int[mid];
        // array is created to store the 2nd half  of the array
        int[] r=new int[n-mid];
        //for loop to store the array values in the created arrays
        for (int i=0;i<mid;i++){
            l[i]=arr[i];
        }
        for (int i=mid;i<n;i++){
            r[i-mid]=arr[i];
        }
        //this again recursively divides the left part of array in half
        mergesort(l);
        //this again recursively divides the right part of array in half
        mergesort(r);
        //both the array the passed for merging
        merge(arr,l,r);
    }
    static void merge(int arr[],int l[],int r[]){
        // lenghth of both the array are stored in nl and nr
        int nl=l.length;
        int nr=r.length;
        // i->iterating over array l
        // j->iterating over array r
        // k->iterating over aarray arr
        int i=0,j=0,k=0;
        //runs still the point one of the array gets fully iterated
        while (i<nl && j<nr){
            //compares the value of l and r 
            if (l[i]<=r[j]){
                arr[k++]=l[i++];
            }
            else{
                arr[k++]=r[j++];
            }
        }
        //this is executed when right array was completely iterated so some of the value were remaining in the l array so it will be placed in the array
        while (i<nl){
            arr[k++]=l[i++];
        }
        //this is executed when left array was completely iterated so some of the value were remaining in the r array so it will be placed in the array
        while (j<nr){
            arr[k++]=r[j++];
        }
    }
    
}
