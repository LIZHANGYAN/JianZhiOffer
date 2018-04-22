package completeofcode;

import java.util.Scanner;

public class Print1ToMaxN {
    public static void print1ToMaxN(int n){
        if(n<=0)
            return;

        char[] array = new char[n];
        for (int i = 0; i < n; i++) {
            array[i] = '0';
        }
        boolean isOverflow = false;

        while(!isOverflow) {
            int nTakeOver = 0;
            for (int i = array.length - 1; i >= 0; i--) {
                int iSum = array[i] - '0' + nTakeOver;
                if (i == array.length - 1)
                    iSum++;
                if (iSum >= 10) {
                    if (i != 0) {
                        iSum -= 10;
                        nTakeOver = 1;
                        array[i] = (char) ('0' + iSum);
                    } else {
                        isOverflow = true;
                    }
                } else {
                    array[i] = (char) ('0' + iSum);
                    break;
                }

            }
            if (!isOverflow) {
                boolean flag = true;
                for (int j = 0; j < array.length; j++) {
                    if(array[j] == '0' && flag){
                        continue;
                    }
                    flag = false;
                    System.out.print(array[j]);
                }
                System.out.println();
            }
        }
    }

    // 递归方法
    public static void Print1ToMaxOfNRecursively(char[] array, int n, int index){
        if(index == n-1){
            boolean flag = true;
            for (int j = 0; j < array.length; j++) {
                if(array[j] == '0' && flag){
                    continue;
                }
                flag = false;
                System.out.print(array[j]);
            }
            System.out.println();
            return;
        }
        for(int i=0; i<10; i++){
            array[index+1] = (char) (i+'0');
            Print1ToMaxOfNRecursively(array, n, index+1);
        }
    }

    // 调用递归方法
    public static void Print1ToMaxOfN(int n){
        char[] array = new char[n];
        for (int i = 0; i < n; i++) {
            array[i] = '0';
        }
        for (int i = 0; i < 10; i++) {
            array[0] = (char) (i+'0');
            Print1ToMaxOfNRecursively(array, n, 0);
        }

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            Print1ToMaxOfN(n);
        }
    }
}
