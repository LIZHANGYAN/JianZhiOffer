package recursion;

import java.util.Scanner;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 方法1：迭代
 * 方法2：递归
 */
public class JumpFloor1orn {
    public static int JumpFloorII(int target){
        // 迭代
        if(target<=2)
            return target;
        int result=0;
        int[] num = new int[target+1];
        num[1] = 1;
        num[2] = 2;
        for(int i=3; i<=target; i++){
            result = 0;
            for(int j=1; j<num.length; j++){
                result += num[j];
            }
            result += 1;
            System.out.println(i+"|"+result);

            num[i] = result;
        }

        for (int a :
                num) {
            System.out.print(a);
        }
        System.out.println();
        return result;
    }

    public static int JumpFloorIIRecur(int target){
        if(target<=2)
            return target;
        int result = 0;
        result = 2*JumpFloorIIRecur(target - 1);
        return result;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();
            int result = JumpFloorIIRecur(n);
            System.out.println(result);
        }
    }
}
