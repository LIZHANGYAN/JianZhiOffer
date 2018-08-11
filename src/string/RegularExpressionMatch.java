package string;

import java.util.Scanner;

/**
 * 题目53：正则表达式匹配
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class RegularExpressionMatch {

    public static boolean match(char[] str, char[] pattern){
        if(str == null || pattern == null){
            return false;
        }
        return matchCore2(str, pattern, 0, 0);
    }

    static boolean matchCore(char[] str, char[] pattern, int start1, int start2){
        if(start1 == str.length && start2 == pattern.length)
            return true;

        if(start1 != str.length && start2 == pattern.length)
            return false;

        if(start2 + 1 < pattern.length && '*' == pattern[start2+1]){
            if((start1 != str.length && pattern[start2] == str[start1]) || ('.' == pattern[start2] && start1 != str.length)){
                return matchCore(str, pattern, start1+1, start2+2)
                        || matchCore(str, pattern, start1+1, start2)
                        || matchCore(str, pattern, start1, start2+1);
            }else{
                return matchCore(str, pattern, start1, start2+2);
            }
        }
        if((start1 != str.length && str[start1] == pattern[start2]) || ('.' == pattern[start2]&& start1 != str.length))
            return matchCore(str, pattern, start1+1, start2+1);

        return false;
    }
    static boolean matchCore2(char[] str, char[] pattern, int start1, int start2){
        if(start1 == str.length && start2 == pattern.length)
            return true;
        if(start1 != str.length && start2 == pattern.length)
            return false;

        if(start1 == str.length && start2 != pattern.length){
            if(start2 + 1 < pattern.length && pattern[start2+1] == '*'){
                return matchCore(str, pattern, start1, start2+2);
            }
            return false;
        }

        if(start2 + 1 < pattern.length && pattern[start2+1] == '*'){
            if(pattern[start2] == str[start1] || (pattern[start2] == '.' && start1 != str.length)){
                return matchCore(str, pattern, start1, start2+2)
                        || matchCore(str, pattern, start1+1, start2+2)
                        || matchCore(str, pattern, start1+1, start2);
            }else {
                return matchCore(str, pattern, start1, start2+2);
            }
        }

        if(pattern[start2] == str[start1] || (pattern[start2] == '.' && start1 != str.length)){
            return matchCore(str, pattern, start1+1, start2+1);
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            String pattern = in.nextLine();
//            str = "";
//            pattern = "";
            boolean result = match(str.toCharArray(), pattern.toCharArray());
            if(result)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
