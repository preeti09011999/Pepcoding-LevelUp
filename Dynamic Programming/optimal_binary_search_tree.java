import java.io.*;
import java.util.*;

public class Main {
    
public static int optimal_bst(int frequency[]){
    int dp[][] = new int[frequency.length][frequency.length];
    for(int gap = 0;gap<frequency.length;gap++){
        for(int i=0,j=gap;j<frequency.length;i++,j++){
            int si = i,ei = j;
            if(si == ei){
                dp[si][ei] = frequency[si];
                continue;
            }
        
        int sum = 0; 
        // for evaulating sum of all nodes
        int min = Integer.MAX_VALUE;
        for(int cp = si;cp<=ei;cp++){
            sum += frequency[cp];
            int lcost = cp-1 >= si? dp[si][cp-1] : 0;
            int  rcost = cp+1 <= ei? dp[cp+1][ei] : 0;
            if(min > (lcost + rcost)){
                min  = lcost + rcost;
            }
        }
            min += sum;
            dp[si][ei] = min;
        }
    
    }
    return dp[0][frequency.length-1];
}
    
  
//   private static int optimalbst(int[] keys, int[] frequency,int si, int ei,int dp[][]) {
//         if(si == ei){
//             return dp[si][ei] = frequency[ei];
//         }
//         if(dp[si][ei] != 0){
//             return dp[si][ei];
//         }
//         int sum1 = 0; 
//         int min = Integer.MAX_VALUE;
//         for(int cp = si;cp<=ei;cp++){
//             int leftCost = cp-1 >= si ? optimalbst(keys,frequency,si,cp-1,dp) : 0;
//             int rightcost = cp+1 <= ei ? optimalbst(keys,frequency,cp+1,ei,dp) : 0;
//             int minCost = leftCost + rightcost + sumOfAllNode(frequency,si,ei);
//             if(minCost < min){
//                 min = minCost;
//             }
//         }
//         min += sum1;
//         return dp[si][ei] = min;
// 	}

// static int sumOfAllNode(int[] frequency,int si,int ei){
//     int sum = 0;
//     for(int i=si;i<=ei;i++){
//         sum += frequency[i];
//     }
//     return sum;
// }

    public static void main(String[] args) {
	Scanner scn = new Scanner(System.in);
	int n = scn.nextInt();
	int[] keys = new int[n];
	int[] frequency = new int[n];
    for(int i= 0 ;i < n ; i++) {
		keys[i] = scn.nextInt();
	}
	for(int i = 0 ; i < n; i++){
      frequency[i] = scn.nextInt();
    }
// 	System.out.println(optimalbst(keys,frequency,0,keys.length-1,new int[frequency.length][frequency.length]));
	System.out.println(optimal_bst(frequency));
        
    }

}
