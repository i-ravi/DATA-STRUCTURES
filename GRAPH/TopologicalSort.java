/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GRAPH;
import java.util.*;
/**
 *
 * @author ravisharma
 */
public class TopologicalSort {
    
    static int V;
    static LinkedList<Integer> adj[];
    static Stack<Integer> st=new Stack<>();
    
     TopologicalSort(int v){
        V=v;
        adj=new LinkedList[v];
        for (int i=0;i<v;i++)
            adj[i]=new LinkedList();
    }
    
    static void addEdge(int v,int w){
        adj[v].add(w);
    }
    
    static void Sort(){
        boolean[] vis=new boolean[V];
        for (int i=0;i<V;i++)
            if (!vis[i])
                SortHelper(vis,i);
    }
    
    static void SortHelper(boolean[] vis,int v){
        vis[v]=true;
        
        Iterator<Integer> it=adj[v].listIterator();
        while(it.hasNext()){
            int i=it.next();
            if (!vis[i])
                SortHelper(vis,i);
        }
        st.push(v);
    }
    
    public static void main(String[] args) {
        TopologicalSort g=new TopologicalSort(6);
        addEdge(5, 2);  
        addEdge(5, 0);  
        addEdge(4, 0);  
        addEdge(4, 1);  
        addEdge(2, 3);  
        addEdge(3, 1);  
        
        Sort();
        System.out.println(st.size());
        while(st.empty()==false){
            int t=st.pop();
            System.out.print(t+" ");
        }
        //System.out.println(st);
        
    }
        
}
