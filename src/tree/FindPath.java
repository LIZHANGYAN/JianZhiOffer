package tree;

import java.util.*;

/**
 * 面试题25：
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class FindPath {



    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if(root == null)
            return lists;
        FindPath(lists, root, target, new Stack<>());
        return lists;
    }

    static void FindPath(ArrayList<ArrayList<Integer>> lists,
                         TreeNode root,
                         int target,
                         Stack<Integer> stack){
        stack.push(root.val);
        int sum = sum(stack);

        // 判断是否叶节点
        if(root.left==null && root.right==null){
            if(sum == target){
                System.out.println("A path is found:");
                ArrayList<Integer> list = new ArrayList<>();
                for (Integer i :
                        stack) {
                    System.out.print(i+"-->");
                    list.add(i);
                }
                System.out.println();
                lists.add(list);
                stack.pop();
                return;
            }
        }
        if(root.left != null)
            FindPath(lists, root.left, target,stack);
        if(root.right != null)
            FindPath(lists, root.right, target, stack);

        stack.pop();
        return;
    }
    static int sum(Stack<Integer> stack){

        int sum = 0;
        for (Integer i :
                stack) {
            sum += i;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int N = in.nextInt();
            int[] treenodes = new int[N];
            for (int i = 0; i < N; i++) {
                treenodes[i] = in.nextInt();
            }
            counter = 0;
            TreeNode root = createBinaryTreeByArray(treenodes, counter);
            int target = in.nextInt();
            ArrayList<ArrayList<Integer>> lists = FindPath(root, target);
            for (ArrayList<Integer> list:
                    lists) {
                for (Integer i :
                        list) {
                    System.out.print(i+"\t");
                }
                System.out.println();
            }
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
}
