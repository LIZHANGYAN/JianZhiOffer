package string;

import java.util.*;

public class IsContinuous43 {

    public static boolean isContinuous(int[] numbers){
        if(numbers == null || numbers.length != 5)
            return false;
        Set<Integer> set = new HashSet<>();
        int max = -1;
        int min = 14;
        for (int num :
                numbers) {
            if (!set.add(num) && num != 0)
                return false;
            if(num != 0){
                max = Math.max(max, num);
                min = Math.min(min, num);
            }
        }
        if(max - min <=4)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = 5;
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = in.nextInt();
            }
            if(isContinuous(numbers)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
