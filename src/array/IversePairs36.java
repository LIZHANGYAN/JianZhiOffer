package array;

import java.util.Arrays;
import java.util.Scanner;

public class IversePairs36 {
    public static int InversePairs(int[] array){
        if(array == null || array.length == 0)
            return 0;
        int count = 0;
        int[] copy;
        copy = array.clone();

        count = InversePairsCore(array, copy, 0, array.length-1);

        return count%1000000007;
    }

    private static int InversePairsCore(int[] array, int[] copy, int low, int high){
        if(low == high) {
//            copy[low] = array[low];
            return 0;
        }
        int mid = (high + low) / 2;
        int leftcount = InversePairsCore(array, copy, low, mid);
        int rightcount = InversePairsCore(array, copy, mid+1, high);

        int i = mid;
        int j = high;
        int indexCopy = high;
        int count = 0;
        while(i>=low && j>=mid+1){
            if(array[i] > array[j]){
                copy[indexCopy--] = array[i--];
                count += j-mid;
            }else{
                copy[indexCopy--] = array[j--];
            }
        }
        for(; i>=low;i--){
            copy[indexCopy--] = array[i];
        }
        for(; j>=mid+1; j--){
            copy[indexCopy--] = array[j];
        }
        for(int s=low; s<=high; s++){
            array[s] = copy[s];
        }
        return leftcount+rightcount+count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
            }
            System.out.println(InversePairs(array));
        }
    }
}
