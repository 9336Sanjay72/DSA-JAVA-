class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][]dp=new int[n+1][amount+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=1;j<=amount;j++){
                int consider=0;
                if(j>=coins[i])consider=dp[i][j-coins[i]];
                int notConsider = dp[i+1][j];
                dp[i][j]=consider+notConsider;
            }
        }
        return dp[0][amount];
   }
}

// class Solution {
//     int[][]dp;
//     public int helper(int i,int []coins,int amount){
//         if(amount==0)return 1;
//         if(amount<0||i==coins.length)return 0;
//         if(dp[i][amount]!=-1)return dp[i][amount];
//         int consider=helper(i,coins,amount-coins[i]);
//         int notConsider=helper(i+1,coins,amount);
//         return dp[i][amount]=consider+notConsider;
//     }
//     public int change( int amount,int[] coins) {
//         int n= coins.length;
//         dp=new int[n][amount+1];
//         for(int i=0;i<n;i++){
//             Arrays.fill(dp[i],-1);
//         }
//         return helper(0,coins,amount);
//     }
// }