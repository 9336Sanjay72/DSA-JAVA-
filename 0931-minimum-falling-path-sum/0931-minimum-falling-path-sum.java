class Solution {
    public int[][]dp;
    public int solve(int[][]nums,int i,int j){
        int n=nums.length;
        int m=nums[0].length;
        if(i==n-1 && j<m && j>=0)return dp[i][j]=nums[i][j];
        if(i>=n ||j<0|| j>=m)return Integer.MAX_VALUE;
        if(dp[i][j]!=Integer.MAX_VALUE)return dp[i][j];
        return dp[i][j]= nums[i][j]+
        Math.min(solve(nums,i+1,j-1),Math.min(solve(nums,i+1,j),solve(nums,i+1,j+1))); 
    }
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        dp=new int[n+1][m+1];
        for(int []nums:dp)Arrays.fill(nums,Integer.MAX_VALUE);
        int ans=Integer.MAX_VALUE;
        for(int col=0;col<m;col++){
            ans=Math.min(ans,solve(matrix,0,col));
        }
        return ans;
    }
}