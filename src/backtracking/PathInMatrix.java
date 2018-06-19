package backtracking;

import java.util.Scanner;

/**
 * 面试题66：矩阵中的路径
 *  请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 *  路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中
 *          向左，向右，向上，向下移动一个格子。
 *  如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 *  例如
 *          a b c e
 *          s f c s
 *          a d e e
 *  矩阵中包含一条字符串"bcced"的路径，
 *  但是矩阵中不包含"abcb"路径，
 *  因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 *  路径不能再次进入该格子。
 *
 * 方法：回溯法
 */
public class PathInMatrix {

    private static boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        int[] visited = new int[rows*cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(hasPath(matrix, rows, cols,
                        str, i, j, 0, visited)){
                    return true;
                }
            }
        }

        return false;
    }

    static boolean hasPath(char[] matrix, int rows, int cols,
                           char[] str, int row, int col,
                           int lengthStr, int[] visited){
        if(lengthStr == str.length)
            return true;

        boolean haspath = false;
        if(row>=0 && row<rows && col>=0 && col<cols
                && matrix[row*cols+col]==str[lengthStr]
                && visited[row*cols+col]==0){
            lengthStr++;
            visited[row*cols+col] = 1; //visited
            haspath = hasPath(matrix, rows, cols, str, row-1,col,lengthStr,visited)
                    || hasPath(matrix, rows, cols, str, row+1, col,lengthStr, visited)
                    || hasPath(matrix, rows, cols, str, row, col+1, lengthStr, visited)
                    || hasPath(matrix, rows, cols, str, row, col-1, lengthStr, visited);

            if(!haspath){
                lengthStr--;
                visited[row*cols+col] = 0;
            }
        }



        return haspath;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();

        char[] matrix;
        matrix = in.next().toCharArray();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i*cols+j]+" ");
            }
            System.out.println();
        }
        while (in.hasNext()){

            char[] str;
            str = in.next().toCharArray();
            if(hasPath(matrix, rows, cols, str)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
