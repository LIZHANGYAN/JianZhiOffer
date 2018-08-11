package array;

import java.util.Scanner;

/**
 * 题目40：数组中只出现一次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class OnlyOnceNumberInArray40 {

    public static void FindNumsAppearOnce(int[] array, int[] num1, int[] num2){
        if(array == null || array.length < 2)
            return;
        int resultExclusiveOR = 0;
        for(int i = 0; i<array.length; i++){
            resultExclusiveOR ^= array[i];
        }
        int indexBit = FindFirstBitIs1(resultExclusiveOR);
        for (int i = 0; i < array.length; i++) {
            if(isBit1(array[i], indexBit)){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }

        System.out.println("num1: "+num1[0] + "\nnum2: "+num2[0] + "\n");
    }

    private static int FindFirstBitIs1(int num){
        int indexBit = 0;
        while((num & 1)==0 && indexBit<32){
            num = num >> 1;
            ++indexBit;
        }
        return indexBit;
    }

    private static boolean isBit1(int num, int indexBit){
        num = num >> indexBit;
        return (num & 1) ==1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
            }
            FindNumsAppearOnce(array, new int[1],new int[1]);
        }
    }
}
