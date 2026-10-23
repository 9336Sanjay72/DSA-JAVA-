class Solution {
    public static int[][][]dp;
    public static int solve(int row ,int col,int [][]grid,int k,int sum){
        int n=grid.length;
        int m=grid[0].length;
        // base case 
        if(row>=n || col>=m )return 0;
        sum=(sum%1000000007+grid[row][col])%1000000007;
        if(row==n-1 && col==m-1 && sum%k==0)return 1;
        if(dp[row][col][sum%k]!=-1)return dp[row][col][sum%k];
        int down=solve(row+1,col,grid,k,sum);
        int right=solve(row,col+1,grid,k,sum);
        return dp[row][col][sum%k]=(down+right)%1000000007;

    }
    public int numberOfPaths(int[][] grid, int k) {
        dp=new int[grid.length+1][grid[0].length+1][k+1];
        for(int [][] arr:dp){
             for(int []nums:arr){
                Arrays.fill(nums,-1);
             } 
         }
        return solve(0,0,grid,k,0);
    }
}
// we neeed 3 state dp because sum is also changing phele mai sirf 2d dp bana raha tha for row col