class Solution {
    public Set<String> set=new HashSet<>();
    public int maxLength=0;
    public void solve(char[]s,StringBuilder sb,int i,int count){
        if(count<0)return;
        if(i==s.length){
            if(count==0){// it means valid string
                if(maxLength<sb.length()){
                    maxLength=sb.length();
                    set.clear();// we do this because want element  of maxlength which means minimal removal
                }
                
            // why we are doing this?
            // because we want valid string with minimal removal thats why we take maxlength 
            if(maxLength==sb.length()){
                set.add(sb.toString());
            } 
         }
         return;
        }
        // now we handle character 
        if(s[i]!='(' && s[i]!=')'){
          sb.append(s[i]);
          solve(s,sb,i+1,count);
          sb.deleteCharAt(sb.length()-1);
            return;
        }
        sb.append(s[i]);// take 
        solve(s,sb,i+1,count+(s[i]=='(' ?1 :-1));// explore and add 1 if char is ( other wise -1
        sb.deleteCharAt(sb.length()-1);// not take
        solve(s,sb,i+1,count);// kyuki humne liya hi nahi hai isliye count nahi badaya

        

    }
    public List<String> removeInvalidParentheses(String s) {
        solve(s.toCharArray(),new StringBuilder(),0,0);
        List<String> result=new ArrayList<>();
        for(String str: set){
            result.add(str);
        }
        return result;
    }
}