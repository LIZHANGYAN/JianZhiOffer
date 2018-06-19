package tree;

import java.util.ArrayList;

public class Reconstruc2Tree {

    private TreeNode tree;

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length != in.length)
            return null;
        if (pre.length == 0 || in.length == 0)
            return null;

        TreeNode root = new TreeNode(pre[0]);
        if (pre.length == 0 && in.length == 0) {
            return null;
        }


        for (int j = 0; j < in.length; j++) {
            if (in[j] == root.val){
                int[] leftprearr = new int[j];
                int[] leftinarr = new int[j];
                for (int k = 0; k < j; k++) {
                    leftprearr[k] = pre[k + 1];
                    leftinarr[k] = in[k];
                }
                root.left = reConstructBinaryTree(leftprearr, leftinarr);
                int[] rightprearr = new int[in.length - j - 1];
                int[] rightinarr = new int[in.length - j - 1];
                for (int k = 0; k < in.length - j - 1; k++) {
                    rightprearr[k] = pre[j+k+1];
                    rightinarr[k] = in[j+k+1];
                }
                root.right = reConstructBinaryTree(rightprearr, rightinarr);
            }

        }


        return root;
    }

    public static void desc(TreeNode treeNode){
        if(treeNode!=null){
            ArrayList<TreeNode> list = new ArrayList<>();
            list.add(treeNode);
            while(!list.isEmpty()){
                TreeNode tn = list.remove(0);
                System.out.print(tn.val);
                if(tn.left!=null)
                    list.add(tn.left);
                if(tn.right!=null)
                    list.add(tn.right);

            }
        }
    }
    public static void main(String[] args){
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        Reconstruc2Tree rs = new Reconstruc2Tree();
        rs.tree = rs.reConstructBinaryTree(pre,in);
        desc(rs.tree);
    }
}
