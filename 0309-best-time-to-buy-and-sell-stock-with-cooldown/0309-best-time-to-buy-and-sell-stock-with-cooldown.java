class Solution {

    public int[][]dp;
    public int solve(int[]prices,int i,int op){
        if(i>=prices.length)return 0;
        if(dp[i][op]!=-1)return dp[i][op];
        if(op==1){
            int buy=solve(prices,i+1,0)-prices[i];
            int notbuy=solve(prices,i+1,1);
            return dp[i][op]=Math.max(buy,notbuy);
        }else{
            int sell=solve(prices,i+2,1)+prices[i];
            int notsell=solve(prices,i+1,0);
            return dp[i][op]=Math.max(sell,notsell);
        }
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        dp=new int[n+1][3];
        for(int []nums :dp)Arrays.fill(nums,-1);
        return solve(prices,0,1);
    }
}