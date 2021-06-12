public boolean isValid(String str) {
        Stack<Character> st = new Stack<>();
        int n = str.length();

        for(int i=0;i<n;i++){
            char ch = str.charAt(i);

            if(ch == '(' || ch == '[' || ch == '{') st.push(ch);
            else{
                if(st.size()==0) return false;  // more no of closing brackets
                else if(ch == ')' && st.peek() != '(') return false;
                else if(ch == ']' && st.peek() != '[') return false;
                else if(ch == '}' && st.peek() != '{') return false;
                else st.pop();
            }
        }

        return st.size()==0;
    }
