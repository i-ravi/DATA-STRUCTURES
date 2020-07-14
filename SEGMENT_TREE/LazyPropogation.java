/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SEGMENT_TREE;

import java.util.Arrays;

/**
 *
 * @author ravisharma
 */
public class LazyPropogation {
    
    int[] st;
    int[] lazy;
    
    LazyPropogation(int[] arr,int n){
        int x=(int)Math.ceil(Math.log(n)/Math.log(2));
        x=2*(int)Math.pow(2, x)-1;
        
        st=new int[x];
        lazy=new int[x];
        
        buildTree(arr,0,n-1,0);
        
    }
    
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8};
        
        LazyPropogation l=new LazyPropogation(arr,arr.length);
        System.out.println(Arrays.toString(arr));
        l.print();
        
        System.out.println(l.query(arr.length,0,5));
        
        l.rangeUpdate(0,0,arr.length-1,3,4,5);
        l.querySumLazy(0,5,arr.length);
        l.print();
        
        l.rangeUpdate(0, 0, arr.length-1, 2, 7, 0-5);
        l.querySumLazy(0, 5, arr.length);
        l.print();
    }

    private void print(){
        System.out.println(Arrays.toString(st));
    }
    private int buildTree(int[] arr, int ss, int se,int si) {
        
        if (ss==se){
            st[si]=arr[ss];
            return st[si];
        }
        
        int mid=ss+(se-ss)/2;
        
        int l=buildTree(arr,ss,mid,2*si+1);
        int r=buildTree(arr,mid+1,se,2*si+2);
        
        return st[si]=l+r;
    }

    private int query(int n,int qs, int qe) {
        return queryUtil(0,n-1,qs,qe,0);
    }

    private int queryUtil(int ss, int se, int qs, int qe, int si) {
        
        if (qs>se || qe<ss){
            return 0;
        }
        
        if (qs<=ss &&  qe>=se) return st[si];
        
        int mid=ss+(se-ss)/2;
        
        int l=queryUtil(ss,mid,qs,qe,2*si+1);
        int r=queryUtil(mid+1,se,qs,qe,2*si+2);
        
        return l+r;
    }

    private void rangeUpdate(int si, int ss, int se, int qs, int qe, int val) {
        
        if (lazy[si]!=0){
            st[si]+=(se-ss+1)*lazy[si];
            if (ss!=se){
                lazy[2*si+1]+=lazy[si];
                lazy[2*si+2]+=lazy[si];
            }
            
            lazy[si]=0;
        }
        
        if (qe<ss || qs>se) {
            return;
        }
        
        if (ss>=qs && se<=qe){
            st[si]+=(se-ss+1)*val;
            if (ss!=se){
                lazy[2*si+1]+=lazy[si];
                lazy[2*si+2]+=lazy[si];
            }
            return;
        }
        
        int mid=ss+(se-ss)/2;
        rangeUpdate(2*si+1,ss,mid,qs,qe,val);
        rangeUpdate(2*si+2,mid+1,se,qs,qe,val);
        st[si]=st[2*si+1]+st[2*si+2];
                
    }
    
    private int querySumLazy(int si,int ss,int se,int qs,int qe){
        if(lazy[si]!=0){
            st[si]+=(se-ss+1)*lazy[si];
            if (ss!=se){
                lazy[2*si+1]=lazy[si];
                lazy[2*si+2]=lazy[si];
            }
            lazy[si]=0;
        }
        
        if (qe<ss || qs>se) return 0;
        
        if (qs<=ss && qe>=se) return st[si];
        
        int mid=ss+(se-ss)/2;
        return (querySumLazy(2*si+1,ss,mid,qs,qe))+querySumLazy(2*si+2,mid+1,se,qs,qe);
        
    }

    private void querySumLazy(int a, int b,int n) {
        System.out.println(querySumLazy(0,0,n-1,a,b));
    }
    
}
