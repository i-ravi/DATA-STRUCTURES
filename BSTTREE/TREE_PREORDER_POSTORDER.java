/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BSTTREE;

/**
 *
 * @author ravisharma
 */ 


/*Let us consider the two given arrays as pre[] = {1, 2, 4, 8, 9, 5, 3, 6, 7} and post[] = {8, 9, 4, 5, 2, 6, 7, 3, 1};
In pre[], the leftmost element is root of tree. Since the tree is full and array size is more than 1. 
The value next to 1 in pre[], must be left child of root. So we know 1 is root and 2 is left child. 
How to find the all nodes in left subtree? We know 2 is root of all nodes in left subtree. 
All nodes before 2 in post[] must be in left subtree. Now we know 1 is root, elements {8, 9, 4, 5, 2} are in left subtree,
and the elements {6, 7, 3} are in right subtree.*/

public class TREE_PREORDER_POSTORDER {
    static class TreeNode{
    TreeNode left;
    TreeNode right;
    int data;
    TreeNode(int data){
        this.data=data;
    }
    }
    static int preindex;
    static TreeNode buildTree(int preorder[],int postorder[]){
        preindex=0;
        int n=preorder.length;
    return buildTreeHelper(preorder,postorder,0,n-1,n);
}

    private static TreeNode buildTreeHelper(int[] preorder, int[] postorder,int l,int r,int size) {
        if(preindex>=size || l>r) return null;
        // The first node in preorder traversal is  
        // root. So take the node at preIndex from  
        // preorder and make it root, and increment  
        // preIndex 
        TreeNode root=new TreeNode(preorder[preindex++]);
        
        if(preindex>=size || l==r) return root;
        int i;
        for ( i=l;i<=r;i++) {
            if (postorder[i]==preorder[preindex]){
                break;
            }
        }
        if (i<r){
            root.left=buildTreeHelper(preorder,postorder,l,i,size);
            root.right=buildTreeHelper(preorder,postorder,i+1,r,size);
        }
        return root;
    }
    static void inorder(TreeNode root){
        if (root ==null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    static void preorder(TreeNode root){
        if (root ==null) return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    static void postorder(TreeNode root){
        if (root ==null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    public static void main(String[] args) {
        int pre[] = { 1, 2, 4, 8, 9, 5, 3, 6, 7 }; 
        int post[] = { 8, 9, 4, 5, 2, 6, 7, 3, 1 }; 
        int size = pre.length; 
        TreeNode root = buildTree(pre, post); 
  
        inorder(root); 
        System.out.println("");
        preorder(root);
        System.out.println("");
        postorder(root);
    }
}
