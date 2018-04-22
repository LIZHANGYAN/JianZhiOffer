package search;

import java.util.Scanner;

/**
 * {3,4,5,1,2}是{1,2,3,4,5}的一个旋转
 */
public class RotateArray {
    public static int minNumberInRotateArray(int[] array){
        int lo = 0;
        int hi = array.length-1;
        int mid = lo; // 保证满足这是一个递增数列时，直接返回第一个元素
        while(array[lo] >= array[hi]){
            if(hi-lo == 1){
                mid = hi;
                break;
            }
            mid = (lo+hi)/2;
            // 如果下标为lo,mid,hi的三个数字相同，
            // 只能顺序查找
            if(array[lo] == array[mid] && array[lo] == array[hi])
                return minInOrder(array);
            if(array[mid] >= array[lo]){
                lo = mid;
            }else if(array[mid] <= array[hi]){
                hi = mid;
            }

        }
        return mid;
    }
    public static int minInOrder(int[] array){
        int min = 0;
        for (int i = 1; i < array.length; i++) {
            if(array[min] > array[i])
                min = i;
        }
        return min;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
            }
            int res = minNumberInRotateArray(array);
            System.out.println(array[res] + "|" + res);
        }
    }
}
