package companies.netease;

import java.util.Scanner;

/**
 * 重排数列
 * 小易有一个长度为N的正整数数列A = {A[1], A[2], A[3]..., A[N]}。
 * 牛博士给小易出了一个难题:
 * 对数列A进行重新排列,使数列A满足所有的A[i] * A[i + 1](1 ≤ i ≤ N - 1)都是4的倍数。
 * 小易现在需要判断一个数列是否可以重排之后满足牛博士的要求。
 *
 *
 * 输入描述:
 * 输入的第一行为数列的个数t(1 ≤ t ≤ 10),
 * 接下来每两行描述一个数列A,第一行为数列长度n(1 ≤ n ≤ 10^5)
 * 第二行为n个正整数A[i](1 ≤ A[i] ≤ 10^9)
 *
 *
 * 输出描述:
 * 对于每个数列输出一行表示是否可以满足牛博士要求,如果可以输出Yes,否则输出No。
 */
public class RrorderSeries {

    static boolean checkSeries(int n, int[] array){
        int mod2 = 0;
        int mod4 = 0;
        for (int i = 0; i < n; i++) {
            if(array[i] % 4 == 0)
                mod4++;
            else if(array[i] % 2 == 0)
                mod2++;
        }


        return mod4>=(n-mod2-mod4)?true:false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int t = in.nextInt();   // 数列个数
            for (int i = 0; i < t; i++) {
                int n = in.nextInt();
                int[] array = new int[n];
                for (int j = 0; j < n; j++) {
                    array[j] = in.nextInt();
                }
                if(checkSeries(n, array))
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }


        }
    }

}
