import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        // System.out.println(cmv_rec(arr,0));
        // System.out.println(cmv_memo(arr,new int[n],0));
        System.out.println(cmv_tab(arr));
    }
    
//-----------------recursion----------------------------------
    public static int cmv_rec(int arr[],int idx){
        if(idx==arr.length-1){
            return 1;
        }
        if(idx<0){
            return 0;
        }
        int totalways = 0;
        for(int j=1;j<=arr[idx] && idx+j<=arr.length-1;j++){
            totalways += cmv_rec(arr,idx+j); 
        }
        
        return totalways;
    }
//----------------memoization---------------------------------
    public static int cmv_memo(int arr[],int dp[],int idx){
        if(idx==arr.length-1){
            dp[idx] = 1;
            return dp[idx];
        }
        if(idx<0){
            return 0;
        }
        if(dp[idx] != 0){
            return dp[idx];
        }
        for(int i=1;i<=arr[idx] && idx+i<=arr.length-1;i++){
            dp[idx] += cmv_memo(arr,dp,idx+i);
        }
        return dp[idx];
    }
//------------------tabulation------------------------------
    public static int cmv_tab(int arr[]){
        int dp[] = new int[arr.length];
        dp[arr.length-1] = 1;
        for(int i=arr.length-2;i>=0;i--){
            for(int idx=1;idx<=arr[i] && i+idx <=arr.length-1;idx++){
                dp[i] += dp[i+idx];
            }
            
        }
        return dp[0];
    }
}
