class Solution {
    public int[][][]dp;
    public int solve(int []prices,int i,int cap,int op){
        if(cap==0)return 0;// it means u have done both 2 transcation
        if(i>=prices.length)return 0;
        if(dp[i][cap][op]!=-1)return  dp[i][cap][op];
        if(op==1){
            int buy=solve(prices,i+1,cap,0)-prices[i];
            int notbuy=solve(prices,i+1,cap,1);
            return dp[i][cap][op]=Math.max(buy,notbuy);
        }
        else {
            int sell=solve(prices,i+1,cap-1,1)+prices[i];
            int notsell=solve(prices,i+1,cap,0);
            return dp[i][cap][op]=Math.max(sell,notsell);            
        }
    }
    public int maxProfit(int[] prices) {
        dp=new int[prices.length+1][3][3];
        for(int [][]nums:dp){
            for(int []arr:nums){
                Arrays.fill(arr,-1);
            }
        }
        return solve(prices,0,2,1);
    }
}
//op=1 it means u can buy 
// not able to buy it