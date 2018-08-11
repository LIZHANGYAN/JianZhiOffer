package companies.netease;

import java.util.Scanner;

/**
 * 魔法机器
 */
public class MaginMachine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            StringBuilder sb = new StringBuilder();
            while (n > 0){
                if(n % 2 == 0){
                    n = (n-2) / 2;
                    sb.append("2");
                }else{
                    n = (n-1) / 2;
                    sb.append("1");
                }

            }
            System.out.println(sb.reverse().toString());
        }
    }
}
