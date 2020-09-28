class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        for(int sr=n;sr>=0;sr--){
            if(sr==n){
                dp[sr] = 1;
                continue;
            }
            int count = 0;
            for(int i=1;i<=2&&sr+i<=n;i++){
                count += dp[sr+i];
            }
            dp[sr] = count;
        }
        return dp[0];
    }
}
