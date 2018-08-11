package companies.netease;

import java.util.Scanner;

/**
 * 相反数
 */
public class OppositeNum {


    static int oppositeNum(int n){
        if (n == 0)
            return n;
        int digits = 0; // 多少位
        int validDigits = 0; // 有效位数
        int temp = n;
        while (temp > 0){
            temp /= 10;
            digits++;
        }
        int[] num = new int[digits];
        temp = n;
        for (int i = digits-1; i >= 0; i--) {
            num[i] = temp % 10;
            temp /= 10;
        }
        if(num[digits-1] == 0){
            validDigits++;
            for (int i = digits-2; i >= 0; i--) {
                if(num[i] != 0)
                    break;
                validDigits++;
            }
        }
        validDigits = digits - validDigits;
        int reversenum = 0;
        for (int i = 0; i < validDigits; i++) {
            reversenum += num[i]*Math.pow(10, i);
        }
        return reversenum + n;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            System.out.println(oppositeNum(n));
        }
    }
}
