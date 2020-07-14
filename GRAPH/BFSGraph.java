
package GRAPH;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author ravisharma
 */

//Adjency List representation of Graph
//"Another is Matrix representation"
public class BFSGraph {
    //It is same as the level order traversal of tree the difference 
    //is the cyclic nature can make this traversal for infinite number of times
    //For solving this we keep a boolean array where if we visit any node we make it true
    //And if next time we visit this node and see true value than this node is avoided
    //V = no. of Nodes
    private int V;
    //array of Linked List is maintained
    LinkedList<Integer> adj[];
    //This is conctructor where the array of LinkedList is initialized
    BFSGraph(int v){
        V=v;
        adj=new LinkedList[v];
        for (int i=0;i<v;i++){
            adj[i]=new LinkedList();
        }
    }
    //It adds the edge into the graph
    void addEdge(int v,int w){
        adj[v].add(w);
    }
    
    public static void main(String[] args) {
        BFSGraph g=new BFSGraph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 1);
        g.addEdge(3, 5);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(5, 4);
        g.addEdge(5, 3);
        
        System.out.println("Breadth First Traversal starting from 0");
        g.BFS(0);
    }

    //Prints BFS Traversal
    private void BFS(int s) {
        //Marks all the vertices as not visited (Default)
        boolean[] vis=new boolean[V];
        //queue is maintained for add the node
        LinkedList<Integer> queue=new LinkedList<>();
        //marks the starting node true
        vis[s]=true;
        //adds the node in the queue
        queue.add(s);
        //runs till the queue is not empty
        while(!queue.isEmpty()){
            //removes the starting node
            s=queue.poll();
            
            System.out.print(s+" ");
            //This checks for all the adjacent vertex of the dequeued node
            Iterator<Integer> i=adj[s].listIterator();
            while(i.hasNext()){
                int n=i.next();
                //If the node is not visited
                //Then it marks is as visited and adds in the queue
                if (vis[n]==false){
                    vis[n]=true;
                    queue.add(n);
                }
            }
        }
    }
}
