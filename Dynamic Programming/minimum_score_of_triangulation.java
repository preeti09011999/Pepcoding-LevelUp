import java.io.*;
import java.util.*;

public class Main {

	public static int minScoreTriangulation(int[] arr) {
	    int n = arr.length;
		int dp[][] = new int[n][n];
		for(int gap = 2;gap<n;gap++){
		    for(int sp=0,ep=gap;ep<n;sp++,ep++){
		        if(gap == 2){
		            // base case
		            dp[sp][ep] = arr[sp] * arr[sp+1] * arr[sp+2];
		        }else{
		            int res = Integer.MAX_VALUE;
		            for(int cp=sp+1;cp<=ep-1;cp++){
		                int left = dp[sp][cp];
		                int right = dp[cp][ep];
		                int myScore = left + (arr[sp]*arr[cp]*arr[ep]) + right;
		                if(res > myScore){
		                    res = myScore;
		                }
		            }
		            dp[sp][ep] = res;
		        }
		    }
		}
		return dp[0][n-1];
    }
  public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
		for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(minScoreTriangulation(arr));
	}
}
