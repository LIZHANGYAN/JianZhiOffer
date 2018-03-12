/**
 * 题目描述：
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * *********************************************************
 * 知识点：
 * 当对字符串进行修改时需要使用StringBuffer和StringBuilder类(StringBuilder不是线程安全的，但是速度快)
 *
 *
 */
package string;

public class ReplaceSpace {
    public String replaceSpace(StringBuffer str){
        String replaceStr = "%20";
        String targetStr = " ";
        int index = str.indexOf(targetStr);
        while(index !=-1){
            str.replace(index,index+1,replaceStr);
            index = str.indexOf(targetStr);
        }
        return str.toString();
    }
}

