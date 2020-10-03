class Solution {
    public int distinctSubseqII(String S) {
        if(S.length()==0) return 0;
        int dp[] = new int[S.length()+1];
        int loc[] = new int[26];
        Arrays.fill(loc,-1);
        dp[0] = 1;
        int mod = (int)1e9 + 7;
        for(int i=1;i<=S.length();i++){
            dp[i] = (2 * dp[i-1])%mod;
            char ch = S.charAt(i-1);
            if(loc[ch-'a'] !=-1){
                int val = loc[ch-'a'];
                dp[i] = (dp[i]%mod - dp[val-1]%mod + mod)%mod;
            }
            loc[ch-'a'] = i;
        }
        return (dp[S.length()]-1)%1000000007;
    }
}
