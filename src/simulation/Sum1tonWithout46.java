package simulation;

import java.util.Scanner;

/**
 * 题目46：求1+2+3+4+...+n
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A？B：C）。
 */
public class Sum1tonWithout46 {


    public static int Sum_soulution(int n){
        return sum2(n);
    }

    public static int sum(int n){
        try{
            int i = 1%n;
            return n + sum(n-1);
        }catch (Exception e){
            return 0;
        }
    }

    /**
     * 利用&&短路的特性终止递归
     * @param n
     * @return
     */
    public static int sum2(int n){
        int sum = n;
        boolean ans = (n>0)&& ((sum += sum2(n-1))>0);
        return sum;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            System.out.println(Sum_soulution(n));
        }
    }
}
