/**
 * 题目描述：
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 * ***********************************
 * 分析：
 * 1.不要忘了检测是否为空
 * 2.空数组和null是不同的
 */
package find;

public class FindIn2darray {
    public boolean Find(int target, int[][] array){
        if(array==null)
            return false;
        int a=array.length;//行
        if(a==0)
            return false;
        int b=array[0].length;//列
        if(b==0)
            return false;
        System.out.println(a+","+b);
        for(int i=a; i>=1; i--){
            int[] irow=array[i-1];
            if(target>irow[b-1])
                return false;
            if(target==irow[b-1] || target == irow[0])
                return true;
            if(target<irow[b-1] && target > irow[0]){
                for(int j=1; j<b; j++){
                    if(target==irow[j])
                        return true;
                }
            }
        }
        return false;
    }
}
