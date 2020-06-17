package BSTTREE;
/**
 *
 * @author ravisharma
 */
class BSTNode {
    private int data;
    private BSTNode left;
    private BSTNode right;
 //Searching in BST time complexity = O(logn)   
    public BSTNode get(int value){
        //returns the node if we get the value in our BST
        if (data ==value){
            return this;
        }
        else{
            //goes to the left node if the node->data in greater than the value
            if (data>value){
                if (left!=null){
                    return left.get(value);
                }
            }
            //goes to the right node if the node->data in smaller than the value
            if (data<value){
                if (right!=null){
                    return right.get(value);
                }
            }
        }
        //returns null if the value is not in our BST
        return null;
    }

    @Override
    public String toString() {
        return "BSTNode{" + "data=" + data +'}';
    }
//Inserting in BST time complexity = O(logn)
    public void insert(int value){
        //goes to the left node if the node->data in greater than or equal to the value
        if (data>=value){
            //if get the node where left node doesnot exist it creates a new node and inserts tha value in that
            if (left==null){
                left =new BSTNode(value);
            }
            //this is called till the point we dont get the node->left as null
            else{
                left.insert(value);
            }
        }
        //goes to the left node if the node->data in greater than the value
        else{
            //if get the node where right node doesnot exist it creates a new node and inserts tha value in that
            if (right==null){
                right =new BSTNode(value);
            }
            //this is called till the point we dont get the node->left as null
            else{
                right.insert(value);
            }
        }
    }
//Traverse Inorder is an efficient way to sort the values 
//Inorder ~  Left,Root,Right
    public void traverseInorder(){
        //first the left node values are printed or traversed
        if (left!=null){
            left.traverseInorder();
        }
        //used to print all the value Inorder 
        System.out.print(data+", ");
        //lastly the right node value are printed or traversed
        if (right!=null){
            right.traverseInorder();
        }
    }
//Preorder ~  Root,Left,Right
    public void traversePreorder(){
        //used to print all the value 
        System.out.print(data+", ");
        //first the left node values are printed or traversed
        if (left!=null){
            left.traversePreorder();
        }
        //lastly the right node value are printed or traversed
        if (right!=null){
            right.traversePreorder();
        }
    }
//Preorder ~  Left,Right,Root
    public void traversePostorder(){
        //first the left node values are printed or traversed
        if (left!=null){
            left.traversePostorder();
        }
        //lastly the right node value are printed or traversed
        if (right!=null){
            right.traversePostorder();
        }
        //used to print all the value 
        System.out.print(data+", ");
    }
//In BST leftmost leaf node always has the minimum value    
    public int min(){
        if (left==null){
            return data;
        }
        else {
            return left.min();
        }
    }
//In BST rightmost leaf node always maximum value
    public int max(){
        if (right==null){
            return data;
        }
        else{
            return right.max();
        }
    }
    
// these are the getters and setters
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }
    
    public BSTNode(int data){
        this.data=data;
    }
    
}

class BST {
    private BSTNode root;
   
    public void insert(int value){
        //if the root is null it makes a new root node
        if (root == null){
            root=new BSTNode(value);
        }
        //if the root node is not null it calls BSTNode class to insert the value in BST
        else{
            root.insert(value);
        }
    }

    //if the root node is not null it calls BSTNode class to traverse the value in BST
    public void traverseInorder(){
        if (root!=null){
            root.traverseInorder();
        }
    }
    //if the root node is not null it calls BSTNode class to get the value from BST
    public BSTNode get(int value){
        if (root!=null){
            return root.get(value);
        }
        //returns null if root is also null
        return null;
    }
    
    public int min(){
        //returns -1 when root node is null
        if(root==null){
            return -1;
        }
        //if the root node is not null it calls BSTNode class to get the minimum value from BST
        else{
            return root.min();
        }
    }
    
    public int max(){
        //returns -1 when root node is null
        if (root==null){
            return -1;
        }
        //if the root node is not null it calls BSTNode class to get the maximum value from BST
        else{
            return root.max();
        }
    }
    
    public void delete(int value){
        root=delete(root,value);
    }
    
    private BSTNode delete(BSTNode node,int value){
        if(node==null){
            return node;
        }
        if (node.getData()>value){
            node.setLeft(delete(node.getLeft(),value));
        }
        else if (node.getData()<value){
            node.setRight(delete(node.getRight(),value));
        }
        else{
            //CASE 1 & 2 having 0 & 1 node as children
            if (node.getLeft()==null){
                return node.getRight();
            }
            else if (node.getRight()==null){
                return node.getLeft();
            }
            //CASE 3 having 2 nodes
            //In CASE 3 there are two options that we can do for deleting the node
            //1- we can set the node->data with the maximum number from its left subtree
            // and delete the maximum value node as it will be always a 0 child node
            //2- we can set the node->data with the minimum number from its right subtree
            // and delete the minimum value node as it will be always a 0 child node
            
            
            //gets the maximum number from the left subtree
            node.setData(node.getLeft().max());
            //deletes the node that has been replaced 
            node.setLeft(delete(node.getLeft(),node.getData()));
            
        }
        return node;
    }
}

public class Main {
    public static void main(String[] args) {
        BST t=new BST();
        int[] a={12,13,12,4,5,6,7,23};
        for (int i=0;i<a.length;i++){
            t.insert(a[i]);
        }
        t.traverseInorder();
        System.out.println("");
        System.out.println(t.get(12));
        System.out.println(t.get(14));
        System.out.println(t.min());
        System.out.println(t.max());
        t.delete(12);
        t.traverseInorder();
        System.out.println("");
        t.delete(44);
        t.traverseInorder();
    }
}
