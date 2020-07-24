import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // System.out.println(climbStairs_rec(n));
        // System.out.println(climbStairs_memo(n,new Integer[n+1]));
        System.out.println(climbStairs_tab(n));
        // System.out.println(climbStairs_rec_pre(n));
    }
//----------------------recursion ( postactive)--------------------------------
    public static int climbStairs_rec(int n){
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        int fn = climbStairs_rec(n-1) + climbStairs_rec(n-2) + climbStairs_rec(n-3);
        return fn;
    }
    
// ---------------------recursion (preactive)--------------------------------

    public static int climbStairs_rec_pre(int n){
        if(n==0){
            return 1;
        }
        int fn = ((n-1)>=0 ? climbStairs_rec(n-1) : 0) + ((n-2)>=0 ? climbStairs_rec(n-2) : 0) + ((n-3)>=0 ? climbStairs_rec(n-3) : 0);
        return fn;
    }
// --------------------memoization-------------------------------

    public static int climbStairs_memo(int n,Integer dp[]){
        
        if(n==0){
            dp[n] = 1;
            return dp[n];
        }
        if(dp[n] != null){
            return dp[n];
        }
        dp[n] = ((n-1)>=0 ? climbStairs_memo(n-1,dp) : 0) + ((n-2)>=0 ? climbStairs_memo(n-2,dp) : 0) + ((n-3)>=0 ? climbStairs_memo(n-3,dp) : 0);
        return dp[n];
    }

// ------------------tabulation---------------------------------
    public static int climbStairs_tab(int n){
        int dp[] = new int[n+1];

        for(int i=0;i<=n;i++){
            if(i==0){
                dp[i] = 1;
                continue;
            }
            
            dp[i] = ((i-1)>=0 ? dp[i-1] : 0) + ((i-2)>=0 ? dp[i-2] : 0) + ((i-3)>=0 ? dp[i-3] : 0);
        }
        return dp[n];
    }

}
