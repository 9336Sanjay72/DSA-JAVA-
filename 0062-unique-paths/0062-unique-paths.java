class Solution {
    public int[][]dp;
    public int solve(int m,int n,int i,int j){
        if(i>=m || j>=n || i<0 || j<0)return 0;
        if(i==m-1 &&  j==n-1)return 1;
        if(dp[i][j]!=-1)return dp[i][j];
        int right=solve(m,n,i,j+1);
        int down=solve(m,n,i+1,j);
        return dp[i][j]= down+right;
    }
    public int uniquePaths(int m, int n) {
        dp=new int[m+1][n+1];
        for(int []nums: dp)Arrays.fill(nums,-1);
        return solve(m,n,0,0);
    }
}