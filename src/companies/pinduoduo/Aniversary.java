package companies.pinduoduo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Aniversary {

    static int maxLength(int m, int n, int[][] tree){

        List<Integer> list = new ArrayList<>();
        boolean[] isVisited = new boolean[6];
        Arrays.fill(isVisited, false);
        isVisited[0] = true;
        for (int i = 0; i < n - 1; i++) {
            list.add(dfs(tree, i, tree[i][1], isVisited));
        }
        for (Integer i :
                list) {
            System.out.println(i);
        }


        return 0;
    }

    static int dfs(int[][] tree, int node, int length, boolean[] isVisited){
        if(node >= tree.length)
            return length;
        int next = -1;
        if(isVisited[tree[node][0]]) {
            next = checkSub(tree, node+1, tree[node][2]);
        }
        if(next == -1){
            return tree[node][1];
        }
        isVisited[tree[node][0]] = true;
        length += dfs(tree, node+1, length, isVisited);
        return node;
    }
    static int checkSub(int[][] tree, int index, int node){
        for (int i = index+1; i < tree.length; i++) {
            if(tree[i][0] == node){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int m = in.nextInt();
            int n = in.nextInt();
            int[][] tree = new int[n-1][3];
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < 3; j++) {
                    tree[i][j] = in.nextInt();
                }
            }

            System.out.println("*****" + maxLength(m, n, tree));
        }
    }
}
