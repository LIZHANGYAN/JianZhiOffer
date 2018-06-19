package bitoperation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * ------------------------------------------> 122
 * 正整数：原码=补码=反码，符号位为0---------------> 01111010
 * ------------------------------------------> -122
 * 负整数：原码，符号位为1，----------------------> 11111010
 *       反码，原码符号位不变，其余取反 -----------> 10000101
 *       补码，反码符号位不变，从最低位加1 ---------> 10000110
 */
public class Count1BinarySystem {

    public static int NumberOf1(int n) {
        int count = 0;

        String str = Integer.toBinaryString(n);
        System.out.println(str);
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '1')
                count++;
        }

        return count;
    }
    public static int NumberOf1_2(int n){
        int count = 0;
        int i=0;
        while(i<32){
            if((n&1)!=0){
                count++;
            }
            n = n>>1;
            i++;
        }
        return count;
    }
    public static int NumberOf1_3(int n){
        int count = 0;

        while(n!=0){
            count++;
            n = (n-1)&n;
        }

        return count;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            System.out.println(NumberOf1(n));
            System.out.println(NumberOf1_2(n));
            System.out.println(NumberOf1_3(n));
        }
    }
}
