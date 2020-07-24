import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    // System.out.println(fibonacci(n));
    // System.out.println(fibonacci_memo(n,new int[n+1]));
    System.out.println(fibonacci_rec(n));
 }
 // -------- tabulation-----------------------
 public static int fibonacci(int n){
     int dp[] = new int[n+1];
     for(int i=0;i<=n;i++){
         if(i==0 || i == 1){
             dp[i] = i;
             continue;
         }
         int f1 = dp[i-1];
         int f2 = dp[i-2];
         dp[i] = f1+f2;
         
     }
     return dp[n];
 }
// ----------memoization------------------------
 public static int fibonacci_memo(int n,int dp[]){
     if(n==0|| n==1){
         dp[n]= n;
         return dp[n];
     }
     if(dp[n] != 0){
         return dp[n];
     }
     int f1 = fibonacci_memo(n-1,dp);
     int f2 = fibonacci_memo(n-2,dp);
     dp[n] = f1+f2;
     return dp[n];
 }
 //----------recursion---------------------------
 public static int fibonacci_rec(int n){
     if(n==0||n==1){
         return n;
     }
     int f1 = fibonacci_rec(n-1);
     int f2 = fibonacci_rec(n-2);
     return f1+f2;
 }

}
