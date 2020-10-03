class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n+1][m+1];
        for(int d[] : dp ) Arrays.fill(d,-1);
        return numDistinct_(s,t,n,m,dp);
    }
    
    public int numDistinct_(String s, String t, int n, int m,int[][] dp){
        if(n<m) return dp[n][m] = 0;
        if(m==0) return dp[n][m] = 1;
        if(dp[n][m] !=-1) return dp[n][m];
        int a = numDistinct_(s,t,n-1,m-1,dp);
        int b = numDistinct_(s,t,n-1,m,dp);
        if(s.charAt(n-1) == t.charAt(m-1)) dp[n][m] = a + b;
        else dp[n][m] = b;
        return dp[n][m];
   }
}
