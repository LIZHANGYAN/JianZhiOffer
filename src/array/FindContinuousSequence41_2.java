package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FindContinuousSequence41_2 {
    public static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list = null;
        if(sum < 3)
            return lists;
        int small = 1;
        int big = 2;
        int middle = (1+sum)/2;
        int curSum = small + big;
        while(small < middle){
            list = new ArrayList<>();
            if(curSum == sum){
                for(int i=small; i<=big; i++){
                    list.add(i);
                }

                lists.add(list);
            }
            while(curSum > sum && small < middle){
                curSum -= small;
                small++;
                if(curSum == sum){

                    for(int i=small; i<=big; i++){
                        list.add(i);
                    }
                    lists.add(list);
                }
            }
            big++;
            curSum += big;
        }
        return lists;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int sum = in.nextInt();
            ArrayList<ArrayList<Integer>> lists = FindContinuousSequence(sum);
            for (ArrayList<Integer> list :
                    lists) {
                for (Integer i :
                        list) {
                    System.out.print(i+" ");
                }
                System.out.println();
            }
        }
    }
}
