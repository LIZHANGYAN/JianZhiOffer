package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串
 * abc,acb,bac,bca,cab和cba。
 */
public class StringPermutation {
    public static ArrayList<String> Permutation(String str){
        char[] chs = str.toCharArray();

        return null;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()){
            String str = in.nextLine();
            ArrayList<String> list = Permutation(str);
        }
    }
}
