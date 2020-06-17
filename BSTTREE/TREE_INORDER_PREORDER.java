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
class TreeNode{
    TreeNode left;
    TreeNode right;
    int data;
    TreeNode(int data){
    this.data=data;
}
}
public class TREE_INORDER_PREORDER {
    static TreeNode buildTree(int inorder[],int preorder[]){
        int n=inorder.length;
        return buildTreeHelper(inorder,preorder,0,n-1,0,n-1);
    }

    static private TreeNode buildTreeHelper(int[] inorder, int[] preorder, int inorderS, int inorderE, int preorderS, int preorderE) {
        if (inorderS > inorderE) return null;
        int inorderRindex=-1;
        int rootData=preorder[preorderS];
        for (int i=inorderS;i<=inorderE;i++){
            if (inorder[i]==rootData){
                inorderRindex=i;
                break;
            }
        }
        int linorderS=inorderS;
        int linorderE=inorderRindex-1;
        int rinorderS=inorderRindex+1;
        int rinorderE=inorderE;
        int lpreorderS=preorderS+1;
        int lpreorderE=lpreorderS+(linorderE-linorderS);
        int rpreorderS=lpreorderE+1;
        int rpreorderE=preorderE;
        
        TreeNode root=new TreeNode(rootData);
        root.left=buildTreeHelper(inorder,preorder,linorderS,linorderE,lpreorderS,lpreorderE);
        root.right=buildTreeHelper(inorder,preorder,rinorderS,rinorderE,rpreorderS,rpreorderE);
        return root;
    }
    static void inorder(TreeNode root){
        if (root==null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    static void preorder(TreeNode root){
        if (root==null) return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        int[] inorder={4,2,5,1,8,6,9,3,7};
        int[] preorder={1,2,4,5,3,6,8,9,7};
        TreeNode root=buildTree(inorder,preorder);
        inorder(root);
        System.out.println("");
        preorder(root);
    }
}
