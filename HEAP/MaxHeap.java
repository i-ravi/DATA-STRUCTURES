/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HEAP;

/**
 *
 * @author ravisharma
 */
public class MaxHeap {
    
    private int capacity;
    private int size;
    private int[] Heap;
    
    MaxHeap(int i){
        
        this.capacity=i;
        this.size=0;
        Heap=new int[this.capacity];
        Heap[0]=Integer.MAX_VALUE;
    }
    private int parent(int i){
        return i/2;
    }
    private int leftChild(int i){
        return 2*i;
    }
    private int rightChild(int i){
        return 2*i+1;
    }
    private void swap(int a,int b){
        int temp=Heap[a];
        Heap[a]=Heap[b];
        Heap[b]=temp;
    }
    private void insert(int value){
        Heap[++size]=value;
        int current =size;
        
        while(Heap[current]>Heap[parent(current)]){
            swap(current,parent(current));
            current=parent(current);
        }
    }
    private boolean leafNode(int i){
        if (i>=size && i<=size) return true;
        return false;
    }
    private void maxheapify(int pos){
        if (!leafNode(pos)){
            if (Heap[pos]<Heap[leftChild(pos)] || Heap[pos]<Heap[rightChild(pos)]){
               if (Heap[pos]<Heap[leftChild(pos)]){
                    swap(pos,leftChild(pos));
                    maxheapify(leftChild(pos));
                }
                else{
                    swap(pos,rightChild(pos));
                    maxheapify(rightChild(pos));
                }   
            }
        }   
    }
    private void heapify(){
        for (int i=size/2;i>0;i--){
            maxheapify(i);
        }
    }
    private int remove(){
        
        int popped=Heap[1];
        Heap[1]=Heap[size--];
        maxheapify(1);
        return popped;
    }
    private void print(){
        for (int i=1;i<=size/2;i++){
            System.out.println(" PARENT : " + Heap[i] 
                             + " LEFT CHILD : " + Heap[2 * i] 
                             + " RIGHT CHILD :" + Heap[2 * i + 1]);
        }
            
    }
    public static void main(String[] args) {
        
        MaxHeap maxheap=new MaxHeap(15);
        maxheap.insert(5); 
        maxheap.insert(3); 
        maxheap.insert(17); 
        maxheap.insert(10); 
        maxheap.insert(84); 
        maxheap.insert(19); 
        maxheap.insert(6); 
        maxheap.insert(22); 
        maxheap.insert(9); 
        maxheap.heapify(); 
  
        maxheap.print(); 
        System.out.println("The Max val is " + maxheap.remove());
    }
}
