package SEGMENT_TREE;

import java.util.Arrays;

/**
 *
 * @author ravisharma
 */
public class Implementation {
    int[] st,st1,st2;
    Implementation(int[] arr, int n) {
        int x=(int)(Math.ceil(Math.log(n)/Math.log(2)));
        
        int size=2*(int)Math.pow(2, x)-1;
        
        st=new int[size];
        st1=new int[size];
        st2=new int[size];
        
        constructMin(arr,0,n-1,0);
        constructSum(arr,0,n-1,0);
        constructMax(arr,0,n-1,0);
        
    }
    
    
    public static void main(String[] args) {
        
        int arr[]={1,2,3,4,5,6,7,8};
        int n=arr.length;
        Implementation i=new Implementation(arr,n);
        i.print();
        //System.out.println(Arrays.toString(st));
        
        //System.out.println(i.queryMin(0, 0, n-1, 2, 6));
        //System.out.println(i.querySum(0, 0, n-1, 2, 6));
        //System.out.println(i.queryMax(0, 0, n-1, 2, 6));
        System.out.println("After Update");
        i.updateValueSum(arr,arr.length,2,10);
        i.updateBoth(arr,n);
        i.print();
        //System.out.println(Arrays.toString(arr));
        
    }

    private void updateBoth(int[] arr,int n){
        constructMin(arr,0,n-1,0);
        constructMax(arr,0,n-1,0);
        
    }
    private int constructMin(int[] arr, int ss, int se, int si) {
        if (ss==se) {st[si]=arr[ss]; return st[si];}
        
        int mid=ss+(se-ss)/2;
        
        st[si]=Math.min(constructMin(arr,ss,mid,2*si+1),constructMin(arr,mid+1,se,2*si+2));
        
        return st[si];
    }

    private int queryMin(int si, int ss, int se, int qs, int qe) {
        if (se<qs || qe<ss) 
            return Integer.MAX_VALUE;
        
        if (qs<=ss && qe>=se) 
            return st[si];
        
        int mid=ss+(se-ss)/2;
        
        int l=queryMin(2*si+1,ss,mid,qs,qe);
        int r=queryMin(2*si+2,mid+1,se,qs,qe);
        return Math.min(l, r);
    }
    
    private void print() {
        System.out.println(Arrays.toString(st));
        System.out.println(Arrays.toString(st1));
        System.out.println(Arrays.toString(st2));
    }

    private int constructSum(int[] arr, int ss, int se, int si) {
        if (ss==se) {
            st1[si]=arr[ss];
            return st1[si];
        }
        
        int mid=ss+(se-ss)/2;
        
        st1[si]=constructSum(arr,ss,mid,2*si+1)+
                constructSum(arr,mid+1,se,2*si+2);
        
        return st1[si];
    }
    
    private int querySum(int si, int ss, int se, int qs, int qe) {
        
        if (qs>se || qe<ss) 
            return 0;
        
        if (qs<=ss && qe>=se) 
            return st1[si];
        
        int mid=ss+(se-ss)/2;
        
        int l=querySum(2*si+1,ss,mid,qs,qe);
        int r=querySum(2*si+2,mid+1,se,qs,qe);
        
        return l+r;
    }

    private void updateValueSum(int[] arr, int n,int i,int value) {
        if (i<0 || i>n-1) 
            System.out.println("INVALID RANGES");
        
        int diff=value-arr[i];
        arr[i]=value;
        updateValueSumHelper(i,0,0,n-1,diff);
    }

    private void updateValueSumHelper(int i,int si, int ss, int se, int diff) {
        
        if (i>se || i<ss) return;
        
        st1[si]+=diff;
        
        if (ss!=se){
            int mid=ss+(se-ss)/2;
            updateValueSumHelper(i,2*si+1,ss,mid,diff);
            updateValueSumHelper(i,2*si+2,mid+1,se,diff);
        }
    }
    
    private int constructMax(int[] arr, int ss, int se, int si) {
        if(ss==se){
            st2[si]=arr[ss];
            return st2[si];
        }
        
        int mid=ss+(se-ss)/2;
        
        st2[si]=Math.max(constructMax(arr,ss,mid,2*si+1), 
                constructMax(arr,mid+1,se,2*si+2));
        
        return st2[si];
    }

    private int queryMax(int si, int ss, int se, int qs, int qe) {
        
        if (qs>se || qe<ss) 
            return Integer.MIN_VALUE;
        
        if (qs<=ss && qe>=se)
            return st2[si];
        
        int mid=ss+(se-ss)/2;
        
        int l=queryMax(2*si+1,ss,mid,qs,qe);
        int r=queryMax(2*si+2,mid+1,se,qs,qe);
        
        return Math.max(l, r);
    }    
}
