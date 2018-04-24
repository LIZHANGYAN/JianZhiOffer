package tree;

import java.util.*;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintTreeTopToDown {
    public static ArrayList<Integer> printFromTopToDown(TreeNode root){

        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Queue<TreeNode> s = new LinkedList<>();
        s.offer(root);
        while(!s.isEmpty()){
            TreeNode node = s.poll();
            list.add(node.val);
            if(node.left!=null)
                s.offer(node.left);
            if(node.right!=null)
                s.offer(node.right);
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int N = in.nextInt();
            int[] treenodes = new int[N];
            for (int i = 0; i < N; i++) {
                treenodes[i] = in.nextInt();
            }
            TreeNode root = createBinaryTreeByArray(treenodes, counter);
            ArrayList<Integer> list = printFromTopToDown(root);
            for (Integer i :
                    list) {
                System.out.print(i+" ");
            }
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
}
