class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)==')'){
                List<Character> list=new ArrayList<>();
                while(st.peek()!='('){
                    list.add(st.pop());
                }
                st.pop();
                for(int j=0;j<list.size();j++){
                    st.push(list.get(j));
                }

            }
            if(s.charAt(i)==')')continue;
            st.push(s.charAt(i));
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        
        return sb.reverse().toString();
    }
}