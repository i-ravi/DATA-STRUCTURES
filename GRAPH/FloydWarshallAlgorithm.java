/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GRAPH;

/**
 *
 * @author ravisharma
 */
public class FloydWarshallAlgorithm {
    //This Algorithm is used to get distance of all nodes to others nodes
    public static void main(String[] args) {
        long[][] graph={ 
            {0  ,Integer.MAX_VALUE, -2, Integer.MAX_VALUE},
            {4  ,   0,  2,  Integer.MAX_VALUE},
            {Integer.MAX_VALUE, Integer.MAX_VALUE,  0,  2},
            {Integer.MAX_VALUE, -1, Integer.MAX_VALUE,  0}
        };
        int v=graph.length;
       for (int k=0;k<v;k++){
           for (int i=0;i<v;i++){
               for (int j=0;j<v;j++){
                   if (graph[i][j]>graph[i][k]+graph[k][j]){
                       graph[i][j]=graph[i][k]+graph[k][j];
                   }
               }
           }
       }
       
       for (long[] a: graph){
           for (long b: a){
               System.out.print(b+" ");
           }
           System.out.println("");
       }
    }
    
}
