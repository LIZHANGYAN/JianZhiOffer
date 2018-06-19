package recursion;

import java.util.Scanner;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 妈蛋：还是Fibonacci数列
 */

public class JumpFloor1or2 {
    public static int JumpFloor(int target){

        if(target<=2)
            return target;
        int num1 = 1;
        int num2 = 2;
        int result = 0;
        for(int i=3; i<=target; i++){
            result = num1 + num2;
            num1 = num2;
            num2 = result;
        }

        return result;

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();
            int result = JumpFloor(n);
            System.out.println(result);
        }
    }
}
