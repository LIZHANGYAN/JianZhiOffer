package tree;

import java.util.Scanner;

/**
 * 题目27：二叉搜索树与双向链表
 */
public class SearchTree2DoubleDirectionLinked27 {

    private static TreeNode Convert(TreeNode pRootOfTree){
        TreeNode result = null;

        return result;
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
            System.out.println("hhh");


        }
    }



}
