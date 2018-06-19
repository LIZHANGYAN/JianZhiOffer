package tree;

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val){
        this.val = val;
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
