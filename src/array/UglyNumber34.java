package array;

import java.util.ArrayList;
import java.util.Scanner;

public class UglyNumber34 {
    public static int GetUglyNumber_Solution(int index) {
        if(index <= 0)
            return 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        while(list.size()<index){
            int m2 = list.get(i2)*2;
            int m3 = list.get(i3)*3;
            int m5 = list.get(i5)*5;
            int min = Math.min(m2, Math.min(m3, m5));
            list.add(min);
            if(min == m2)
                i2++;
            if(min == m3)
                i3++;
            if(min == m5)
                i5++;
        }
        return list.get(list.size()-1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int index = in.nextInt();
            System.out.println(GetUglyNumber_Solution(index));
        }
    }
}
