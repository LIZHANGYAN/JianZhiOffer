package companies.netease;

import java.util.Scanner;

/**
 * 游历魔法王国
 */
public class TravelMagicalCountry {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int L = in.nextInt();

            int[] parent = new int[n-1];
            for (int i = 0; i < n - 1; i++) {
                parent[i] = in.nextInt();
            }

            int maxLen = 0;
            int[] dp = new int[n];
            for (int i = 0; i < n - 1; i++) {
                dp[i+1] = dp[parent[i]] + 1;
                maxLen = Math.max(maxLen, dp[i+1]);
            }
            int validpath = Math.min(maxLen, L);
            System.out.println(Math.min(n, 1+validpath+(L-validpath)/2));
        }
    }
}
