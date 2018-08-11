package companies.netease;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 字符串碎片
 */
public class StringFragment {

    static double getAvga(String s){
        if(s == null || s.length() <= 0)
            return 0.0;
        double result = 0.0;
        List<Integer> list = new ArrayList<>();

        char[] chs = s.toCharArray();
        int i = 0;
        while (i < chs.length){
            int num = 0;
            while (true){
                if((i+1)<chs.length && chs[i] == chs[i+1]){
                    num++;
                    i++;
                }else{
                    break;
                }
            }
            num++;
            i++;
            list.add(num);
        }

        int sum = 0;
        for (Integer num :
                list) {
            sum += num;
        }
        result = sum/(double)list.size();
        result = (double)Math.round(result*100)/100;
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String s = in.nextLine();
            System.out.println(String.format("%.2f", getAvga(s)));
        }
    }
}
