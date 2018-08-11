package string;

import java.util.Scanner;

/**
 * 题目42：左旋转字符串
 * 汇编语言中有一种移位指令叫做循环左移（ROL），
 * 现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,
 * 要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 */
public class LeftRotateString42 {

    public static String leftRotateString(String str, int n){
        if(str == null || str.length() <= 0)
            return "";
//        String result = "";
//
//        String part1 = str.substring(0,n);
//        String part2 = str.substring(n);
//
//        result = part2 + part1;
        str = reverse(str.toCharArray(), 0, n-1);
        str = reverse(str.toCharArray(), n, str.length()-1);
        str = reverse(str.toCharArray(), 0, str.length()-1);
        return str;
    }

    public static String reverse(char[] chs, int i, int j){
        while(i<j){
            char temp = chs[j];
            chs[j] = chs[i];
            chs[i] = temp;
            i++;
            j--;
        }
        return String.valueOf(chs);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            System.out.println(reverse(str.toCharArray(),0,str.length()-1));
            int n = in.nextInt();
            System.out.println(leftRotateString(str, n));
        }
    }
}
