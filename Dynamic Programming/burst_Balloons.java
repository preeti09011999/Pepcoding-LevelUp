import java.io.*;
import java.util.*;

public class Main {

// -------------------Recursion --------------------------------------
//   public static int solution(int[] arr,int sp, int ep) {
//     int L = sp-1 >= 0 ? arr[sp-1] : 1;
//     int R = ep+1 < arr.length ? arr[ep+1] : 1;
//     if(sp == ep){
//         return L * arr[sp] * R;
//     }
    
//     int max = Integer.MIN_VALUE;
//     for(int cp = sp;cp<=ep;cp++){
//         int leftCoins = cp-1 >= sp ? solution(arr,sp,cp-1) : 0;
//         int rightCoins = cp + 1 <= ep ? solution(arr,cp+1,ep) : 0;
//         int myCoins = leftCoins + ( L * arr[cp] * R) + rightCoins ;
//         if(max < myCoins){
//             max = myCoins;
//         }
//     }
//     return max;
//   }

// ----------------------memoization ----------------------------------

public static int solution_memo(int[] arr,int sp, int ep,int dp[][]) {
    int L = sp-1 >= 0 ? arr[sp-1] : 1;
    int R = ep+1 < arr.length ? arr[ep+1] : 1;
    if(sp == ep){
        return dp[sp][ep] = L * arr[sp] * R;
    }
    
    if(dp[sp][ep] != 0){
        return dp[sp][ep];
    }
    
    int max = Integer.MIN_VALUE;
    for(int cp = sp;cp<=ep;cp++){
        int leftCoins = cp-1 >= sp ? solution_memo(arr,sp,cp-1,dp) : 0;
        int rightCoins = cp + 1 <= ep ? solution_memo(arr,cp+1,ep,dp) : 0;
        int myCoins = leftCoins + ( L * arr[cp] * R) + rightCoins ;
        if(max < myCoins){
            max = myCoins;
        }
    }
    return dp[sp][ep] = max;
  }

// -------------------tabulation-----------------------------------------
    public static int solution_tab(int arr[]){
        int n = arr.length;
        int dp[][] = new int[n][n];
        for(int gap = 0;gap < n;gap++){
            for(int i=0,j=gap;j<n;j++,i++){
                int sp = i, ep = j;
                int max = Integer.MIN_VALUE;
                int L = sp-1 >= 0 ? arr[sp-1] : 1;
                int R = ep + 1 < arr.length ? arr[ep+1] : 1;
                if(sp == ep){
                    dp[sp][ep] = L * arr[sp] * R;
                    continue;
                }
                for(int cp = sp;cp<=ep;cp++){
                    int leftCoins = cp - 1 >= sp ? dp[sp][cp-1] : 0;
                    int rightCoins = cp + 1 <= ep ? dp[cp+1][ep] : 0;
                    int myCoins = leftCoins + (L * arr[cp] * R) + rightCoins;
                    max = Math.max(max,myCoins);
                }
                dp[sp][ep] = max;
            }
        }
        return dp[0][n-1];
    }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
    }
    // System.out.println(solution_memo(arr,0,arr.length-1,new int[n][n]));
    System.out.println(solution_tab(arr));
  }

}
