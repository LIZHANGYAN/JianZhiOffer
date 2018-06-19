package recursion;

import java.util.Scanner;

/**
 * 获得Fibonacci数列第n项
 * 方法1：递归，对于大数会造成堆栈溢出
 * 方法2：迭代
 */

public class GetNitemOfFibonacci {
    public static int Fibonacci(int n){
//        if(n==1){
//            return 1;
//        }
//        if(n==0){
//            return 0;
//        }
//        int result = Fibonacci(n-1) + Fibonacci(n-2);
        if(n<=1)
            return n;
        int prenum1 = 0;
        int prenum2 = 1;

        int result = 0;
        for(int i=2; i<=n; i++){
            result = prenum1 + prenum2;
            prenum1 = prenum2;
            prenum2 = result;
        }
        return result;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();
            int result = Fibonacci(n);
            System.out.println(result);
        }
    }
}
