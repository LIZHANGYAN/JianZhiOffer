package tree;

import java.util.Scanner;

/**
 * 输入两颗二叉树A,B，判断B是不是A的子结构
 */

class TreeNode{
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val){
        this.val = val;
    }
}

public class FindSubTree {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int N = in.nextInt();
            int[] treenode = new int[N];
            for (int i = 0; i < N; i++) {
                treenode[i] = in.nextInt();
            }
            int M = in.nextInt();
            int[] treenode2 = new int[M];
            for (int i = 0; i < M; i++) {
                treenode2[i] = in.nextInt();
            }
            counter = 0;
            TreeNode root1 = createBinaryTreeByArray(treenode, counter);
            counter = 0;
            TreeNode root2 = createBinaryTreeByArray(treenode2, counter);
            if(hasSubTree(root1, root2))
                System.out.println("root2 is the subtree of root1");
            else
                System.out.println("root2 is not the subtree of root2");
            System.out.println("--------------------------");
        }

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

    public static boolean hasSubTree(TreeNode root1, TreeNode root2){
        boolean result = false;
        if(root1 != null && root2 != null){
            if(root1.val == root2.val){
                result = doesTree1HaveTree2(root1, root2);
            }
            if(!result)
                result = hasSubTree(root1.left, root2);
            if(!result)
                result = hasSubTree(root1.right, root2);
        }
        return result;
    }

    static boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2){
        if(root2 == null)
            return true;
        if(root1 == null)
            return false;

        if(root1.val != root2.val)
            return false;

        return doesTree1HaveTree2(root1.left, root2.left) &&
                doesTree1HaveTree2(root1.right, root2.right);
    }
}
