package array;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵：
 *      1   2   3   4
 *      5   6   7   8
 *      9   10  11  12
 *      13  14  15  16
 * 则依次打印出数字
 *      1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrixClockWise {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();   // 行数
        int M = in.nextInt();   // 列数

        int[][] arrays = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arrays[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arrays[i][j]+"\t");
            }
            System.out.println();
        }
        ArrayList<Integer> list = printMatrix(arrays);
        for (Integer integer :
                list) {
            System.out.print(integer+" ");
        }
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix){
        ArrayList<Integer> list = new ArrayList<>();
        int N = matrix.length;
        int M = matrix[0].length;

        int rs = 0, re = N-1;
        int cs = 0, ce = M-1;

        while(rs<=re && cs<=ce){
            if(cs == ce && rs == re) {
                list.add(matrix[cs][rs]);
                break;
            }
            if(rs == re && cs < ce){
                for (int i = cs; i <= ce ; i++) {
                    list.add(matrix[rs][i]);
                }
                break;
            }
            if(cs == ce && rs < re){
                for (int i = rs; i <= re ; i++) {
                    list.add(matrix[i][cs]);
                }
                break;
            }

            // 第一次循环，遍历rs行,从cs-ce列
            for (int i = cs; i <= ce; i++) {
                list.add(matrix[rs][i]);
            }

            // 第二个循环，遍历ce列，从rs+1-re行
            for (int i = rs+1; i <= re; i++) {
                list.add(matrix[i][ce]);
            }
            //第三个循环，遍历re行，从ce-1~cs列
            for (int i = ce-1; i >= cs; i--) {
                list.add(matrix[re][i]);
            }
            // 最后一个循环，遍历cs列，从cr-1~rs+1行
            for (int i = re-1; i >= rs+1; i--) {
                list.add(matrix[i][cs]);
            }
            cs++;
            ce--;
            rs++;
            re--;

        }
        return list;
    }
}
