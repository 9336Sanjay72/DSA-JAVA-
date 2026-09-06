class Solution {
   public int[][]dp;
   public int helper(String s, String t,int n,int m,int i,int j){
    if(j==m)return 1;// iska matlab hume string mil gayi tab hi to woh j last tak pahoocha hai string t ke 
    if(i==n)return 0;// failure matlab tumhara string s khatam ho gaya hai
    if(dp[i][j]!=-1)return dp[i][j];
    if(s.charAt(i)==t.charAt(j)){
       return dp[i][j]=helper(s,t,n,m,i+1,j+1)+helper(s,t,n,m,i+1,j);
    }
    else {
        return dp[i][j]=helper(s,t,n,m,i+1,j);
    }
   }
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        dp=new int[n+1][m+1];
        for(int []num: dp){
            Arrays.fill(num,-1);

        }
        return helper(s,t,n,m,0,0);
    }
}