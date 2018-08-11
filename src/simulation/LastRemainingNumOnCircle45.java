package simulation;

import java.util.Scanner;

/**
 * 题目46：孩子们的游戏（圆圈中最后剩下的数字)约瑟夫环问题
 */
public class LastRemainingNumOnCircle45 {

    public static int lastRemain(int n, int m){
        if(n<1 || m<1)
            return -1;
        int[] array = new int[n];
        int i = -1;
        int step = 0;
        int count = n;
        while(count > 0){
            i++;
            if(i >= n){
                // 这是一个环，走到头
                i = 0;
            }
            if(array[i] == -1){
                // 用-1代替删除
                continue;
            }
            step++; // 喊数的计数器
            if(step == m){
                array[i] = -1; // -1模拟删除
                step = 0;
                count--;
            }
        }
        return i; // 返回最后一个删除的数字
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            int result = lastRemain(n, m);
            System.out.println(result);
        }
    }
}
