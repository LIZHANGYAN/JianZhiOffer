package tree;

import java.util.Scanner;

/**
 * 题目27：二叉搜索树与双向链表
 */
public class SearchTree2DoubleDirectionLinked27 {

    private static TreeNode Convert(TreeNode pRootOfTree){
        if(pRootOfTree == null){
            return null;
        }
        TreeNode headNode;
        headNode = ConvertNode(pRootOfTree, null);
        while(headNode !=null && headNode.left != null)
            headNode = headNode.left;
        return headNode;
    }
    private static TreeNode ConvertNode(TreeNode pNode, TreeNode lastNode){
        if(pNode == null){
            return lastNode;
        }
        TreeNode current = pNode;
        if(current.left != null){
            lastNode = ConvertNode(current.left, lastNode);
        }
        current.left = lastNode;
        if(lastNode != null){
            lastNode.right = current;
        }
        lastNode = current;
        if(current.right != null){
            lastNode = ConvertNode(current.right, lastNode);
        }
        return lastNode;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int N = in.nextInt();
            int[] treenodes = new int[N];
            for (int i = 0; i < N; i++) {
                treenodes[i] = in.nextInt();
            }
            TreeNode root = TreeNode.createBinaryTreeByArray(treenodes, 0);

            TreeNode root2 = Convert(root);
            System.out.printf("hhh");

        }
    }



}
