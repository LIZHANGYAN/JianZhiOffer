package tree;

import java.util.Scanner;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 二叉树的镜像定义：
 源二叉树
          8
         /  \
        6   10
       / \  / \
      5  7 9 11
 镜像二叉树
         8
        /  \
      10   6
     / \  / \
    11 9 7  5

 */

public class MirrorOfBinaryTree {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int N = in.nextInt();
            int[] treenode = new int[N];
            for (int i = 0; i < N; i++) {
                treenode[i] = in.nextInt();
            }

            TreeNode root = createBinaryTreeByArray(treenode, counter);

            TreeNode newRoot = getMirrorOfBT(root);

            System.out.println("--------------------------");
        }
    }

    public static TreeNode getMirrorOfBT(TreeNode root){
        if(root == null)
            return null;
        if(root.left!=null || root.right!=null){
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
        }
        TreeNode left = null;
        TreeNode right = null;
        if(root.left!=null)
            left = getMirrorOfBT(root.left);
        if(root.right!=null)
            right = getMirrorOfBT(root.right);

        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = left;
        newRoot.right = right;

        return newRoot;
    }


    static int counter = 0;
    // 通过数组创建链式二叉树
    public static TreeNode createBinaryTreeByArray(int[] treenodes, int i){
        if(i<treenodes.length){
            if(treenodes[i] == 0)
                return null;
            TreeNode root = new TreeNode(treenodes[i]);
            root.left = createBinaryTreeByArray(treenodes, ++counter);
            root.right = createBinaryTreeByArray(treenodes, ++counter);
            return root;
        }
        return null;
    }
}
