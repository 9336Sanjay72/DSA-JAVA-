class Solution {
    public  List<String> result;
    public void solve (String s,int idx,String curr){
        if(idx==s.length()){
            result.add(curr);
            return;
        }
        char ch=s.charAt(idx);
        if(Character.isDigit(ch)){
            solve(s,idx+1, curr+ch);
        }
        else{
            //lower case
            solve(s,idx+1,curr+Character.toLowerCase(ch));
            //upper case
             solve(s,idx+1,curr+Character.toUpperCase(ch));
        }
        
    }
    public List<String> letterCasePermutation(String s) {
         result=new ArrayList<>();  
         
         solve(s,0,"");
         return result;

    }
}