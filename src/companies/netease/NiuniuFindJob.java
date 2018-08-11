package companies.netease;

import java.util.Scanner;

/**
 * 题目描述：牛牛找工作
 */
public class NiuniuFindJob {


    public static int[] getMaxProfile(int[][] workinfos, int[] workerinfo, int N, int M){
        int[] maxProfile = new int[M];

        for (int i = 0; i < M; i++) {
            int Ai = workerinfo[i];
            maxProfile[i] = workinfos[0][1];
            for (int j = 1; j < N; j++) {
                int Di = workinfos[j][0];
                int Pi = workinfos[j][1];
                if(Di <= Ai){
                    if(maxProfile[i] < Pi){
                        maxProfile[i] = Pi;
                    }
                }
            }
        }


        return maxProfile;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int N = in.nextInt();
            int M = in.nextInt();
            int[][] workinfos = new int[N][2];
            for (int i = 0; i < N; i++) {
                workinfos[i][0] = in.nextInt();
                workinfos[i][1] = in.nextInt();
            }
            int[] workerinfos = new int[M];
            for (int i = 0; i < M; i++) {
                workerinfos[i] = in.nextInt();
            }


            for (int i = 0; i < N; i++) {
                System.out.println(workinfos[i][0] + "," + workinfos[i][1]);
            }
            for (int i = 0; i < M; i++) {
                System.out.println(workerinfos[i]);
            }

            int[] maxProfile = getMaxProfile(workinfos, workerinfos, N, M);
            for (int i = 0; i < M; i++) {
                System.out.println(maxProfile[i]);
            }
        }
    }
}
