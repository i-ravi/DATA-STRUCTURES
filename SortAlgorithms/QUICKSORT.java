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
public class QUICKSORT {
    public static void main(String[] args) {
        int arr[]={12,32,12,1,23,45,121};
        quicksort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void quicksort(int arr[],int start,int end){
        if (start<end){
            int pindex=partition(arr,start,end);
            quicksort(arr,start,pindex-1);
            quicksort(arr,pindex+1,end);
        }
    }

    private static int partition(int[] arr,int start,int end) {
        int pivot=arr[end];
        int pindex=start;
        for (int i=start;i<end;i++){
            if (pivot>=arr[i]){
                int temp=arr[i];
                arr[i]=arr[pindex];
                arr[pindex]=temp;
                pindex++;
            }
        }
        int temp=arr[pindex];
        arr[pindex]=arr[end];
        arr[end]=temp;
        return pindex;
    }
}
