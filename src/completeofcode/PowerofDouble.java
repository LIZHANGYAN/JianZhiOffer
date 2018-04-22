package completeofcode;

import java.util.Scanner;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。
 */
public class PowerofDouble {

    public static double Power(double base, int exponent){
        double result = 1.0;
        if(base == 0.0)
            result = 0;
        else if(exponent == 0)
            result = 1;
        else if(exponent > 0){
            for (int i = 0; i < exponent; i++) {
                result *= base;
            }
        }else{
            base = 1/base;
            for(int i=0; i<-exponent; i++){
                result *= base;
            }
        }


        return result;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            System.out.println(Power(in.nextDouble(), in.nextInt()));
            System.out.println(in.nextDouble() == in.nextDouble());
        }
    }
}
