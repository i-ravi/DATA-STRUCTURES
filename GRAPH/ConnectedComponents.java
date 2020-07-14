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
public class ConnectedComponents {
    
    int V;
    LinkedList<Integer> adj[];
    
    ConnectedComponents(int v){
        V=v;
        adj=new LinkedList[V];
        for (int i=0;i<V;i++){
            adj[i]=new LinkedList();
        }
    }
    
    void addEdge(int v,int w){
        adj[v].add(w);
        adj[w].add(v);
    }
    
    void connectedDFS(){
        boolean[] vis=new boolean[V];
        int count=0;
        for(int i=0;i<V;i++){
            if(!vis[i]){
                //if we get any unconnected we come here and simply increment the count
                //because all the connected nodes will becomes true
                count++;
                connectedDFSHelper(i,vis);
            }
        }
        System.out.println(count);
    }
    
    void connectedDFSHelper(int v,boolean[] vis){
        vis[v]=true;
        
        Iterator<Integer> it=adj[v].listIterator();
        while(it.hasNext()){
            int u=it.next();
            if(!vis[u]) connectedDFSHelper(u,vis);
        }
    }
    
    public static void main(String[] args) {
        ConnectedComponents g=new ConnectedComponents(11);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        //g.addEdge(3, 6);
        g.addEdge(6, 7);
        g.addEdge(6, 4);
        g.addEdge(6, 5);
        //g.addEdge(1, 9);
        g.addEdge(9, 8);
        g.addEdge(9, 10);
        
        g.connectedDFS();
    }
        
}
