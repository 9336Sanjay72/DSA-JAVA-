class Solution {
     public int[]dp;
    public int solve(int []nums,int i){
        int n=nums.length;
        //base case
        if(i==n-1)return nums[i];
        if(i>=n)return 0;
        if(dp[i]!=-1)return dp[i];
        int take=nums[i]+solve(nums,i+2);
        int notTake=solve(nums,i+1);
        return dp[i]=Math.max(take,notTake);
    }
    public int rob(int[] nums) {
        dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        int n=nums.length;
       return solve(nums,0);
    }
}