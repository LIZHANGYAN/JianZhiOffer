package completeofcode;

import java.util.Scanner;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Odd_Even {

    public static void reOrderArray(int[] array){

        int N = array.length;
        for(int i=0; i<N; i++){
            if(array[i]%2 == 0) {
                continue;
            }
            for(int j=i; j>0; j--){
                if(array[j-1]%2 == 0){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }else{
                    break;
                }
            }
        }
        for (int a :
                array) {
            System.out.print(a);
        }
        System.out.println();
    }
    public static void reOrderArray2(int[] array){

        int head = 0;
        int last = array.length - 1;
        while(head<=last){
            while(array[head]%2!=0)
                head++;
            while(array[last]%2==0)
                last--;
            if(head>=last)
                break;
            int temp = array[last];
            array[last] = array[head];
            array[head] = temp;

        }

        for (int a :
                array) {
            System.out.print(a);
        }
        System.out.println();



    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int N = in.nextInt();
            int[] array = new int[N];
            int[] array2 = new int[N];
            for(int i=0; i<N; i++){
                array[i] = in.nextInt();
                array2[i] = array[i];
            }

            reOrderArray(array);
            reOrderArray2(array2);
        }
    }
}
