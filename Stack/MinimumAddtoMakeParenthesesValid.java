// time complexity = O(n)
// space complexity = O(1)

class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == ')'){
                if(st.size() > 0 && st.peek() == '(') st.pop();
                else st.push(ch);
            }
            else st.push(ch);
        }
        return st.size();
    }
}


// time complexity = O(n)
//space complexity = O(1)
class Solution {
    public int minAddToMakeValid(String s) {
        int obr = 0, cbr = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(') cbr++;
            else{
                if(cbr > 0) cbr--;
                else obr++;
            }
        }
        return obr + cbr;
    }
}
