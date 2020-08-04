import java.io.*;
import java.util.*;

public class Main {
//-----------------------recursion--------------------------------
    public static long NumberOfChords(int n,int sp, int ep){
        if(sp + 1 == ep){
            return 1;
        }
        if(sp >= ep){
            return 1;
        }
        long res = 0;
        for(int cp = sp + 1;cp <= ep; cp += 2){
            long left = NumberOfChords(n,sp + 1,cp - 1);
            long right = NumberOfChords(n,cp + 1, ep);
            long myways = left * right;
            res += myways;
        }
        return res;
    }
    

    // --------------------tabulation----------------------------
    public static long NumberOfChords_tab(int n){
        long dp[] = new long[2*n + 1];
        dp[0] = 1;
        dp[2] = 1;
        for(int i=4;i<2*n+1;i+=2){
            for(int cp=1;cp<i;cp+=2){
                dp[i] += dp[cp-1]*dp[i-cp-1];
            }
        }
        return dp[2*n];
    }
  public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // System.out.println(NumberOfChords(n,0,2*n));
        System.out.println(NumberOfChords_memo(0,2*n,new long[2*n][2*n]));
        // System.out.println(NumberOfChords_tab(n));
	}
}
