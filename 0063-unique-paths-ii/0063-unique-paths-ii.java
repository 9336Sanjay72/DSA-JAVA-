class Solution {
    public int[][]dp;
    public int solve(int[][]nums,int i,int j){
        int n=nums.length;
        int m=nums[0].length;
        if(i>=n || j>=m)return 0;
        if(i==n-1 && j==m-1)return 1;
        int right=0;
        int down=0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(nums[i][j]==0){
            right=solve(nums,i,j+1);
            down=solve(nums,i+1,j);
        }
        return dp[i][j]= right+down;

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
         int n=obstacleGrid.length;
         int m=obstacleGrid[0].length;
        dp=new int[obstacleGrid.length+1][obstacleGrid[0].length+1];
        if(obstacleGrid[n-1][m-1]==1)return 0;

        for(int[]nums : dp)Arrays.fill(nums,-1);
        return solve(obstacleGrid,0,0);
    }
}