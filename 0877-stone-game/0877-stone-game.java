class Solution {
    public int[][]dp=new int[501][501];
    public int solve(int[]piles,int i,int j){
        if(i>j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int take_i=piles[i]+Math.min(solve(piles,i+2,j),solve(piles,i+1,j-1));
        int take_j=piles[j]+Math.min(solve(piles,i+1,j-1),solve(piles,i,j-2));
        return dp[i][j]=Math.max(take_i,take_j);

    }
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        for(int []num : dp){
            Arrays.fill(num,-1);
        }
        int sum=0;
        for(int num:piles){
            sum+=num;
        }
       int Alice_score=solve(piles,0,n-1);
       return Alice_score>sum/2;
    }
}