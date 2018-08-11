package companies.pinduoduo;

import java.util.Scanner;

/**
 * 列表补全
 *
 */
public class CompleteList {

    static void showgoods(int offset, int n, int l1, int l2){
        int start1 = 0;
        int end1 = 0;
        int start2 = 0;
        int end2 = 0;

        // 列表1元素用完
        if(offset >= l1){
            start1 = l1;
            end1 = l1;

            // 列表2用完
            if((offset-l1) >= l2){
                start2 = l2;
                end2 = l2;
                System.out.println(start1 + " " + end1 + " " + start2 + " " + end2);
                return;
            }
            // 列表2没有用完
            int remain2 = l2 - (offset - l1);
            // 列表2剩余空间够用
            if(remain2 >= n){
                start2 = offset - l1;
                end2 = start2 + n;
                System.out.println(start1 + " " + end1 + " " + start2 + " " + end2);
                return;
            }else {
                start2 = offset - l1;
                end2 = l2;
                System.out.println(start1 + " " + end1 + " " + start2 + " " + end2);
                return;
            }
        }else{
            start1 = offset;
            int remain1 = l1 - offset;
            //列表1剩余元素够用
            if(remain1 >= n){
                end1 = start1 + n;
                start2 = 0;
                end2 = 0;
                System.out.println(start1 + " " + end1 + " " + start2 + " " + end2);
                return;
            }else{
                end1 = l1;
                int offset2 = n - remain1;
                start2 = 0;
                if(offset2 <= l2){
                    end2 = offset2;
                    System.out.println(start1 + " " + end1 + " " + start2 + " " + end2);
                    return;
                }else{
                    end2 = l2;
                    System.out.println(start1 + " " + end1 + " " + start2 + " " + end2);
                    return;
                }
            }


        }

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int offset = in.nextInt();
            int n = in.nextInt();
            int l1 = in.nextInt();
            int l2 = in.nextInt();

            showgoods(offset, n, l1, l2);
        }
    }
}
