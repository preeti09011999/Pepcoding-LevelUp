import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int arr[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = scn.nextInt();
            }
        }
        // System.out.println(minCost_rec(arr,0,0));
        // System.out.println(minCost_tab(arr));
        System.out.println(minCost_memo(arr,0,0,new int[n][m]));
    }
    
    //------------------recursion-------------------------
    public static int minCost_rec(int arr[][],int i,int j){
        if(i == arr.length-1 && j == arr[0].length-1){
            return arr[i][j];
        }
        int hc = j+1 < arr[0].length ? minCost_rec(arr,i,j+1) : Integer.MAX_VALUE;
        int vc = i+1 < arr.length ? minCost_rec(arr,i+1,j) : Integer.MAX_VALUE;
        return Math.min(hc,vc) + arr[i][j];
    }
    
    // -----------------tabulation-------------------------
    
    public static int minCost_tab(int arr[][]){
        int dp[][] = new int[arr.length][arr[0].length];
        for(int i=arr.length-1;i>=0;i--){
            for(int j=arr[0].length-1;j>=0;j--){
                if(i==arr.length-1 && j==arr[0].length-1){
                    dp[i][j] = arr[i][j];
                    continue;
                }
                int hc = j+1 < arr[0].length ? dp[i][j+1] : Integer.MAX_VALUE;
                int vc = i+1 < arr.length ? dp[i+1][j] : Integer.MAX_VALUE;
                dp[i][j] = Math.min(hc,vc)+arr[i][j];
            }
        }
        return dp[0][0];
    }
  // ---------------------memoization----------------------
    public static int minCost_memo(int arr[][],int i,int j, int dp[][]){
        if(i==arr.length-1 && j==arr[0].length-1){
            return dp[i][j] = arr[i][j];
        }
        
        int hc = j+1 < arr[0].length ? minCost_memo(arr,i,j+1,dp) : Integer.MAX_VALUE;
        int vc = i+1 < arr.length ? minCost_memo(arr,i+1,j,dp) : Integer.MAX_VALUE;
        return dp[i][j] = Math.min(hc,vc)+arr[i][j];
    }

}

