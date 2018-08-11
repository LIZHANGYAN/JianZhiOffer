package tree;

import java.util.Scanner;

public class FindTreeDepth39 {

    public static int TreeDepth(TreeNode root){
        if(root == null)
            return 0;
        return nodeDepth(root);
    }

    private static int nodeDepth(TreeNode node) {
        if(node == null)
            return 0;
        int ldepth = nodeDepth(node.left) + 1;
        int rdepth = nodeDepth(node.right) + 1;

        return ldepth>rdepth?ldepth:rdepth;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int N = in.nextInt();
            int[] treenode = new int[N];
            for (int i = 0; i < N; i++) {
                treenode[i] = in.nextInt();
            }
            TreeNode.counter = 0;
            TreeNode root = TreeNode.createBinaryTreeByArray(treenode, 0);
            System.out.println(TreeDepth(root));
        }

    }

}
