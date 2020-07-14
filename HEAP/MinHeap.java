/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HEAP;

import java.util.Arrays;

/**
 *
 * @author ravisharma
 */
public class MinHeap {
    
    private int[] Heap;
    private int size;
    private int maxsize;
    private MinHeap(int i) {
        //size of heap with max elements
        this.maxsize=i;
        //current size of heap
        this.size=0;
        //heap array
        Heap=new int[this.maxsize+1];
        Heap[0]=Integer.MIN_VALUE;
    }
    
    private void swap(int a,int b){
        int temp=Heap[a];
        Heap[a]=Heap[b];
        Heap[b]=temp;
    }
    //returns the index of parent
    private int parent(int i){
        return i/2;
    }
    //returns the index of left child
    private int leftChild(int i){
        return 2*i;
    }
    //returns the index of right child
    private int rightChild(int i){
        return 2*i+1;
    }
    //inserting an element
    private void insert(int value){
        //if the heap is full and cannot be increased
        if (size>=maxsize){
            return;
        }
        //insert the value at last of the array
        Heap[++size]=value;
        //see the current index of the inserted element
        int current=size;
        //swap with the parent if it is smaller than parent
        while(Heap[current]<Heap[parent(current)]){
            swap(current,parent(current));
            current=parent(current);
        }
    }
    //to check if the index sent is a leaf node or not
    private boolean isLeaf(int pos){
        
        if (pos>=size/2 && pos<=size) return true;
        return false;
    }
    //heapify finction
    private void minHeapify(int pos){
        //if it is not a leaf it gets executed
        if (!isLeaf(pos)){
            if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]){
                
                if (Heap[pos]>Heap[leftChild(pos)]){
                    swap(pos,leftChild(pos));
                    minHeapify(leftChild(pos));
                }
                
                else{
                    swap(pos,rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }
    
    private void minHeap(){
        
        for (int pos=size/2;pos>=1;pos--){
            minHeapify(pos);
        }
    }
    
    private void print(){
        for (int i=1;i<=size/2;i++){
            System.out.print("PARENT: "+Heap[i]+" Left: "+Heap[2*i] +" Right: "+Heap[2*i+1]);
            System.out.println("");
        }
        
        System.out.println(Arrays.toString(Heap));
    }
    //remove the peek of the heap
    private int remove(){
        
        int popped=Heap[1];
        Heap[1] = Heap[size--];
        minHeapify(1);
        return popped;
        
    }
    public static void main(String[] args) {
        
        System.out.println("This is a Min Heap");
        
        MinHeap minheap=new MinHeap(15);
        minheap.insert(5);
        minheap.insert(3); 
        minheap.insert(17); 
        minheap.insert(10); 
        minheap.insert(84); 
        minheap.insert(19); 
        minheap.insert(6); 
        minheap.insert(22); 
        minheap.insert(9);
        minheap.minHeap();
        
        minheap.print();
        
        System.out.println(minheap.remove());
    }
    
}
