package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述: 28
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串
 * abc,acb,bac,bca,cab和cba。
 */
public class StringPermutation28 {
    public static ArrayList<String> Permutation(String str){
        List<String> list = new ArrayList<>();
        if(str != null && str.length() != 0){
            PermutationHelper(str.toCharArray(), 0, list);
            //Collections.sort(list);
        }
        return (ArrayList<String>) list;
    }
    public static void PermutationHelper(char[] cs, int i, List<String> list){
        if(i == cs.length-1){
            String val = String.valueOf(cs);
            if(!list.contains(val)){
                list.add(val);
            }
        }else{
            for (int j = i; j < cs.length; j++) {
                swap(cs, i, j);
                PermutationHelper(cs, i+1, list);
                swap(cs, i, j);
            }
        }
    }
    private static void swap(char[] cs, int i, int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()){
            String str = in.nextLine();
            ArrayList<String> list = Permutation(str);
            for (String s :
                    list) {
                System.out.println(s);
            }
        }
    }
}
