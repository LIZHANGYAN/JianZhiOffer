package sort;

import java.util.Scanner;

public class SortAges {
    public static void sortAges(int[] ages){
        if(ages==null || ages.length<=0){
            return;
        }
        int oldestAge = 20;
        int[] timesOfAge = new int[oldestAge+1];
        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            timesOfAge[age]++;
        }
        for (int i:
                timesOfAge){
            System.out.print(i+" ");
        }
        int index = 0;
        for (int i = 0; i <= oldestAge; i++) {
            for (int j = 0; j < timesOfAge[i]; j++) {
                ages[index++] = i;
            }
        }
        for (int i:
            ages){
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = 10;
            int[] ages = new int[n];
            for (int i = 0; i < n; i++) {
                ages[i] = in.nextInt();
            }
            sortAges(ages);
        }
    }
}
