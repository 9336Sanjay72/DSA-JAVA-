class Solution {
    public int[][][]dp;
    public int solve(int row,int c1,int c2,int[][]grid){
        //base case
        int n=grid.length;
        int m=grid[0].length;
        int max=0;
        if(row>=n ||row<0 || c1>=m ||c1<0 ||c2>=m ||c2<0)return 0;
        if(row==n-1 && c1!=c2)return grid[row][c1]+grid[row][c2] ;
        if(row==n-1 && c1==c2)return grid[row][c1];
        if(dp[row][c1][c2]!=-1)return dp[row][c1][c2];
        // put loop for 9 combination of robot 
        for(int move1=-1;move1<=1;move1++){
            for(int move2=-1;move2<=1;move2++){
                int curr=0;
                if(c1==c2)curr= grid[row][c1];
                else {
                    curr= grid[row][c1]+grid[row][c2];
                }
                max=Math.max(max,curr+solve(row+1,c1+move1,c2+move2,grid));
            }
        }
        return dp[row][c1][c2]=max;
     }

     public int cherryPickup(int[][] grid) {
        dp=new int[grid.length+1][grid[0].length+1][grid[0].length+1];
        for(int [][]nums : dp){
            for(int []arr:nums){
                Arrays.fill(arr,-1);
            }
        }
        return solve(0,0,grid[0].length-1,grid);
    }
}