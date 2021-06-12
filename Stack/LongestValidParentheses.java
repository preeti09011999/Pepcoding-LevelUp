// time complexity = O(n)
// space complexity = O(n)
public int longestValidParentheses(String str) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int n = str.length();
        int len = 0;

        for(int i=0;i<n;i++){
            if(st.peek() != -1 && str.charAt(st.peek())=='(' && str.charAt(i)==')'){
                st.pop();
                len = Math.max(len,i-st.peek());
            }else st.push(i);
        }

        return len;
    }


// time complexity = O(n)
// space complexity = O(1)

class Solution {
    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int len = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(') left++;
            else right++;
            if(left == right) len = Math.max(len, right * 2);
            else if(right > left) left = right = 0;
        }
        left = right = 0;
        for(int i = s.length()-1; i>=0;i--){
            if(s.charAt(i) == '(') left++;
            else right++;
            if(left == right) len = Math.max(len, left * 2);
            else if(left > right) left = right = 0;
        }
        return len;
    }
}
