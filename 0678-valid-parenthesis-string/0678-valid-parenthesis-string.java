class Solution {
    public int dp[][];
    public boolean solve(String s,int i,int open){
        if(open<0)return false;
        if(i==s.length())return open==0;
        char ch=s.charAt(i);
        if(dp[i][open]!=-1)return dp[i][open]==1;
        if(ch=='('){
            boolean ans=solve(s,i+1,open+1);
            dp[i][open]=ans ? 1 : 0; 
            return ans;
        }
        if(ch==')'){
            boolean ans=solve(s,i+1,open-1);
            dp[i][open]=ans ? 1 : 0; 
            return ans;
        }
        boolean a=solve(s,i+1,open+1);// jab * ko '(' ye mana tab 
        boolean b=solve(s,i+1,open-1);// jab * ko humne ')' ye mana tab 
        boolean c=solve(s,i+1,open);// jab * ko hum empty manege tab ka 
        boolean ans= a|| b||c;
        dp[i][open]=ans ?1 : 0;
        return ans;
    }
    public boolean checkValidString(String s) {
        dp=new int[101][101];
        for(int[]arr : dp){
            Arrays.fill(arr,-1);
        }
        return solve(s,0,0);
    }
}