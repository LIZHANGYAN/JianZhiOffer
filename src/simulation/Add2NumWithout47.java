package simulation;

import java.util.Scanner;

/**
 * 题目47：不用加减乘除做加法
 */
public class Add2NumWithout47 {

    public static int add(int num1, int num2){
        int sum = 0;
        int carry = 0;
        while (num2 != 0){
            sum = num1 ^ num2; // 异或
            // 异或操作相当于相加但是不进位
            // 5-101，7-111
            // 101+111 不进位 010，101^111 = 010
            carry = (num1 & num2) << 1;

            num1 = sum;
            num2 = carry;
        }
        return num1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int num1 = in.nextInt();
            int num2 = in.nextInt();
            System.out.println(add(num1, num2));
        }
    }
}
