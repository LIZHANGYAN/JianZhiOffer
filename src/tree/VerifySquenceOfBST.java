package tree;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 面试题24:
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {

    public static boolean VerifySquenceOfBST(int[] sequence){
        if(sequence == null || sequence.length == 0)
            return false;

        int root = sequence[sequence.length - 1];
        int i = 0;
        for (i = 0; i < sequence.length-1; i++) {
            if(sequence[i]>root)
                break;
        }
        int j = i;
        for(; j<sequence.length-1; j++){
            if(sequence[j]<root)
                return false;
        }
        boolean left = true;

        if(i>0)
            left = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));
        boolean right = true;
        if(i<sequence.length-1)
            right = VerifySquenceOfBST(Arrays.copyOfRange(sequence, i, sequence.length-1));


        return left&&right;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int N = in.nextInt();
            int[] sequence = new int[N];
            for (int i = 0; i < N; i++) {
                sequence[i] = in.nextInt();
            }
            if(VerifySquenceOfBST(sequence)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
