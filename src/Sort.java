import java.util.Scanner;

public class Sort {

    static void bubblesort(int[] arr){
        if(arr == null || arr.length <= 0){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length-1; j>i; j--) {
                if(arr[j-1] > arr[j])
                    swap(arr, j-1, j);
            }
        }
    }

    static void selectsort(int[] arr){
        if(arr == null || arr.length <= 0)
            return;
        int minIndex = 0;
        for(int i=0; i < arr.length-1; i++){
            minIndex = i;
            for(int j=i+1; j < arr.length; j++){
                if(arr[minIndex] < arr[j])
                    minIndex = j;

            }
            if(minIndex != i){
                swap(arr, minIndex, i);
            }
        }
    }

    static void insertSort(int[] arr){
        if(arr == null || arr.length <= 0)
            return;
        for(int i=1; i < arr.length; i++){
            int j = i;
            int target = arr[i];
            while(j > 0 && target < arr[j-1]){
                arr[j] = arr[j-1];
            }
            arr[j] = target;
        }
    }

    // 一次划分
    static int partition(int[] arr, int left, int right){
        int baseNum = arr[left];
        int baseIndex = left;
        while(left < right){
            while(left < right && arr[right] >= baseNum)
                right--;
            while(left < right && arr[left] <= baseNum)
                left++;
            swap(arr, left, right);
        }
        swap(arr, baseIndex, right);
        return right;
    }
    static void quickSort(int[] arr, int left, int right){
        if(left > right)
            return;
        int partiIndex = partition(arr, left, right);
        quickSort(arr, left, partiIndex-1);
        quickSort(arr, partiIndex+1, right);
    }
    static void quickSort(int[] arr){
        if(arr == null || arr.length <= 0)
            return;
        quickSort(arr, 0, arr.length-1);
    }

    static void heapAdjust(int[] arr, int start, int end){
        int temp = arr[start];
        for(int i=2*start+1; i <= end; i *= 2){
            if(i < end && arr[i] < arr[i+1]){
                i++;
            }
            if(temp >= arr[i]){
                break;
            }
            arr[start] = arr[i];
            start = i;
        }
        arr[start] = temp;
    }
    static void heapSort(int[] arr){
        if(arr == null || arr.length <= 0)
            return;
        for(int i = arr.length/2; i >= 0; i--){
            heapAdjust(arr, i, arr.length-1);
        }
        for(int i=arr.length-1; i>=0; i--){
            swap(arr, 0, i);
            heapAdjust(arr, 0, i-1);
        }
    }

    static void shellSort(int[] arr, int d){
        for(int i=d; i < arr.length; i++){
            int j = i-d;
            int temp = arr[i];
            while(j >= 0 && arr[j] > temp){
                arr[j+d] = arr[j];
                j -= d;
            }
            if(j != i-d)
                arr[j+d] = temp;
        }
    }
    static void shellSort(int[] arr){
        if(arr == null || arr.length <= 0)
            return;
        int d = arr.length/2;
        while (d >= 1){
            shellSort(arr, d);
            d /= 2;
        }
    }

    static void merge(int[] arr, int left, int mid, int right){
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= right){
            if(arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        while(j <= right)
            temp[k++] = arr[j++];
        for(int p=0; p < temp.length; p++){
            arr[left+p] = temp[p];
        }
    }
    static void mSort(int[] arr, int left, int right){
        if(left >= right){
            return;
        }
        int mid = (left + right) / 2;
        mSort(arr, left, mid);
        mSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }
    static void mergeSort(int[] arr){
        if(arr == null || arr.length <= 0)
            return;
        mSort(arr, 0, arr.length - 1);
    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
//            heapSort(arr);
//            shellSort(arr);
            mergeSort(arr);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
