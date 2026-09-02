class Solution {
    public List<String> result=new ArrayList<>();; 
    public boolean isValid(String s){
        int count=0;
        for(char ch : s.toCharArray()){
            if(ch=='(')count++;
            else count--;
            if(count<0)return false;
        }
        return count==0;

    }
    public void solve(int n,StringBuilder sb){
        if(sb.length()==2*n){
            if(isValid(sb.toString())){
                result.add(new String(sb));
            }
            return;
        }
        sb.append('(');
        solve(n,sb);
        sb.deleteCharAt(sb.length()-1);
        sb.append(')');
        solve(n,sb);
        sb.deleteCharAt(sb.length()-1);
    }
    public List<String> generateParenthesis(int n) {
        
        StringBuilder sb=new StringBuilder();
        solve(n,sb);
        return result;
    }
}