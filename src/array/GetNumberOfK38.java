package array;

public class GetNumberOfK38 {
    public static int GetNumberOfk(int[] array, int k){
        if(array == null || array.length == 0)
            return 0;
        return bisearch(array, k+0.5) - bisearch(array, k-0.5);
    }
    private static int bisearch(int[] array, double k){
        int s = 0;
        int e = array.length-1;
        while (s<=e){
            int mid = (e-s)/2 + s;
            if(array[mid] < k)
                s = mid+1;
            else if(array[mid]>k)
                e = mid -1;
        }
        return s;
    }
}
