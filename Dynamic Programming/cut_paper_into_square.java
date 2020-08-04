import java.io.*;
import java.util.*;

public class Main {

    public static int solution(int n, int m) {
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1) {
                    dp[i][j] = j;
                } else if (j == 1) {
                    dp[i][j] = i;
                } else if (i == j) {
                    dp[i][j] = 1;
                } else {
                    int min = Integer.MAX_VALUE;
                    int row = 1;
                    int col = 1;
                    // cutpoint row-wise
                    while (row <= i / 2) {
                        int val = dp[i - row][j] + dp[row][j];
                        min = Math.min(min, val);
                        row++;
                    }
                    // cutpoint col-wise
                    while (col <= j / 2) {
                        int val = dp[i][j - col] + dp[i][col];
                        min = Math.min(min, val);
                        col++;
                    }
                    dp[i][j] = min;
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        System.out.println(solution(n, m));
    }



}
