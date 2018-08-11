package array;

import java.util.Scanner;

/**
 * 题目52：构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 *其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */
public class BuildMultiplyArray {

    /**
     * 复杂度O(N^2)
     * @param A
     * @return
     */
    public static int[] multiply1(int[] A){
        if(A == null || A.length <= 0)
            return A;
        int[] B = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            int result = 1;
            for (int j = 0; j < A.length; j++) {
                if(j == i)
                    continue;
                result *= A[j];
            }
            B[i] = result;
        }

        return B;
    }

    /**
     * 时间复杂度O(N)
     * @param A
     * @return
     */
    public static int[] multiply2(int[] A){
        if(A == null || A.length <= 0)
            return A;
        int[] B = new int[A.length];
        B[0] = 1;
        // 计算下三角
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i-1] * A[i-1];
        }
        int temp = 1;
        // 计算上三角
        for (int i = A.length-2; i >= 0; i--) {
            temp *= A[i+1];
            B[i] *= temp;
        }
        return B;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = in.nextInt();
            }
            int[] B1 = multiply1(A);
            for (int i = 0; i < n; i++) {
                System.out.print(B1[i] + " ");
            }
            System.out.println();
            System.out.println("-------------------------");
            int[] B2 = multiply2(A);
            for (int i = 0; i < n; i++) {
                System.out.print(B2[i] + " ");
            }
        }
    }
}
