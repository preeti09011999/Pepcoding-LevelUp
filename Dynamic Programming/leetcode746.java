class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return minCostClimbingStairs(cost,cost.length,new int[cost.length+1]);
    }
    
    public int minCostClimbingStairs(int[] cost,int n,int dp[]) {
        for(int i=0;i<=n;i++){
            if(i<=1){
                dp[i] = cost[i];
                continue;
            }
            int a = dp[i-1];
            int b = dp[i-2];
            dp[i] = Math.min(a,b) + (i!=cost.length ? cost[i]:0);
        }
        return dp[n];
    }
}
