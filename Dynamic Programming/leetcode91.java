// memoization code

class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        return numDecodings_(s,0,new int[s.length()+1]);
    }
    
    public int numDecodings_(String str, int idx,int dp[]){
        if(idx >= str.length()) return dp[idx]=1; 
        char ch = str.charAt(idx);
        if(dp[idx]!=0) return dp[idx];
        if(ch == '0') return 0;
        int count = 0;
        count += numDecodings_(str,idx+1,dp);
        if(idx < str.length()-1){
            char c = str.charAt(idx+1);
            int num = (ch-'0') * 10 + (c-'0');
            if(num>=10 && num <=26) count += numDecodings_(str,idx+2,dp);   
        }
        return dp[idx] = count;
    }
}

// tabulation
class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        return numDecodings_(s,0,new int[s.length()+1]);
    }
    
    public int numDecodings_(String str, int idx,int dp[]){
        for(idx=str.length();idx>=0;idx--){
            if(idx == str.length()){
                dp[idx] = 1;     
                continue;
            }
            char ch = str.charAt(idx);
            if(ch == '0'){
                dp[idx] = 0;
                continue;
            }
            dp[idx] = dp[idx+1];
            if(idx < str.length()-1){
                char c = str.charAt(idx+1);
                int num = (ch-'0') * 10 + (c-'0');
                if(num>=10 && num <=26) dp[idx] += dp[idx+2];   
            }
        }
        return dp[0];
    }
}
