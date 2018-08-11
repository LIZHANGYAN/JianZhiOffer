package string;

import java.util.Scanner;

/**
 * 题目49：字符串转换整数
 *  将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 *  但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 *  数值为0或者字符串不是一个合法的数值则返回0。
 * 输入描述:
 *  输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 *  如果是合法的数值表达则返回该数字，否则返回0
 */
public class StrToInt {
    public static int str2int(String str){
        if(str == null || str.length() <= 0)
            return 0;
        char[] chs = str.toCharArray();
        boolean minus = false;
        int start = 0;
        if('-' == chs[0]) {
            minus = true;
            start++;
        }else if('+' == chs[0]){
            start++;
        }
        int num = 0;
        while(start<chs.length && chs[start] >= '0' && chs[start] <= '9'){
            char temp = chs[start];
            num = num * 10 + (temp - '0');
            start++;
        }
        if(start < chs.length){
            return 0;
        }
        return minus?(0-num):num;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            System.out.println(str2int(str));
        }
    }
}
