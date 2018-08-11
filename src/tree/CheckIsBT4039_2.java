package tree;

public class CheckIsBT4039_2 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null)
            return true;

        return IsBalanced(root);
    }
    private boolean IsBalanced(TreeNode node){
        if(node == null)
            return true;
        int left = nodeDepth(node.left);
        int right = nodeDepth(node.right);
        int diff = left - right;
        if(diff>1 || diff<-1)
            return false;
        return IsBalanced(node.left) && IsBalanced(node.right);
    }
    // 后序遍历
    private int getDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = getDepth(node.left);
        if(left == -1)
            return -1;
        int right = getDepth(node.right);
        if(right == -1)
            return -1;

        return Math.abs(left - right) > 1? -1:1+(left>right?left:right);
    }
    //层次便利
    private int nodeDepth(TreeNode node) {
        if(node == null)
            return 0;
        int ldepth = nodeDepth(node.left) + 1;
        int rdepth = nodeDepth(node.right) + 1;

        return ldepth>rdepth?ldepth:rdepth;
    }
}
