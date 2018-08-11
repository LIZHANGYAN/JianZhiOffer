package string;

import java.util.Scanner;

/**
 * 题目：翻转单词顺序
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class ReverseSentence42_2 {

    public static String ReverseSentences(String str){
        str = str.trim();
        if(str == null || str.length() <= 0)
            return "";
        if(str.equals(" ")){
            return str;
        }
        String[] strs = str.split(" ");
        int i = 0;
        int j = strs.length-1;
        while (i<j){
            String temp = strs[j];
            strs[j] = strs[i];
            strs[i] = temp;
            i++;
            j--;
        }
        String result = "";
        for (int k = 0; k < strs.length - 1; k++) {
            result += strs[k]+" ";
        }
        result += strs[strs.length-1];
        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            String str2 = "";
            System.out.println(ReverseSentences(str));
            System.out.println(ReverseSentences(str2));
        }
    }
}
