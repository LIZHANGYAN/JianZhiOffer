package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目：和为S的两个数字
 *
 */
public class SumOfTwoDigit41_1 {

    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();

        if(array == null || array.length == 0)
            return list;
        int ahead = 0;
        int behind = array.length-1;
        int i=-1;
        int j=-1;
        while(ahead < behind){
            if(array[ahead] + array[behind] > sum){
                behind--;
            }else if(array[ahead] + array[behind] < sum){
                ahead++;
            }else{
                if(i == j && i == -1){
                    i = ahead;
                    j = behind;
                }else{
                    if(array[i]*array[j] > array[ahead]*array[behind]){
                        i = ahead;
                        j = behind;
                    }
                }
                ahead++;
                behind--;
            }
        }
        if(i!=-1 && j!= -1){
            list.add(array[i]);
            list.add(array[j]);
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
            }
            int sum = in.nextInt();
            List<Integer> list = FindNumbersWithSum(array, sum);
            System.out.println(list.toString());
        }
    }
}
