class Solution {
    public int[][]dp;
    public int solve(int[]coins,int target,int i){
        if(target==0)return 0;
        if(target<0 || i>=coins.length)return Integer.MAX_VALUE;
        if(dp[i][target]!=-1)return dp[i][target];
        int take=Integer.MAX_VALUE;
        if(target>0){
            int x=solve(coins,target-coins[i],i);
            if(x!=Integer.MAX_VALUE)take=x+1;
        }
        int nottake=solve(coins,target,i+1);
        return dp[i][target]= Math.min(take,nottake);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        dp=new int[n+1][amount+1];
        for(int[]arr:dp)Arrays.fill(arr,-1);
        int x=solve(coins,amount,0);
        if(x!=Integer.MAX_VALUE)return x;
        return -1;
    }
}