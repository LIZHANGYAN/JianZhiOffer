package stackandqueue;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class IsPopOrder {

    public static boolean isPopOrder(int[] pushA, int[] popA){
        // 借助辅助栈,ArrayList实现
        ArrayList<Integer> list = new ArrayList<>();
        int indexA = -1;
        if(pushA.length == 0){
            return false;
        }
        if(pushA.length==1 && popA.length == 1){
            return popA[0] == pushA[0];
        }
        for (int i = 0; i < popA.length; i++) {
            System.out.println(i+":"+indexA);
            if(indexA!=-1 && list.contains(popA[i]) && list.get(indexA)!=popA[i])
                return false;
            if(indexA!=-1 && list.get(indexA)==popA[i]){
                list.remove(indexA);
                indexA--;
                continue;
            }
            for (int j = 0; j < pushA.length; j++) {
                if(!list.contains(pushA[j]) && !list.contains(popA[i]) && pushA[j] != popA[i]){
                    list.add(pushA[j]);
                    indexA++;
                }else{
                    break;
                }
            }
            System.out.println(list.toString());
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int N = in.nextInt();
            int[] pushA = new int[N];
            int[] popA = new int[N];
            for (int i = 0; i < N; i++) {
                pushA[i] = in.nextInt();
            }
            for (int i = 0; i < N; i++) {
                popA[i] = in.nextInt();
            }
            if(isPopOrder(pushA, popA)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
