package methodsofprogramming.strings;

import java.util.Scanner;

/**
 * 旋转字符串
 */
public class RotateString {

    public static String rotateString(String str, int k){
        if(str == null || str.length() < 2 || k > str.length())
            return str;

        char[] chars = str.toCharArray();
        reversePartition(chars, 0, k-1);
        reversePartition(chars, k, chars.length-1);
        reversePartition(chars, 0, chars.length-1);

        return new String(chars);
    }

    private static void reversePartition(char[] chars, int l, int r) {
        while(l < r){
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.next();
            int k = in.nextInt();
            System.out.println(rotateString(str, k));
        }
    }
}
