class Solution {
    public Boolean[][]dp;
    public boolean solve(int[]nums,int i,int target){
        if(target==0)return true;
        if(i>=nums.length ||target<0)return false;
        if(dp[i][target]!=null)return dp[i][target];
        boolean take=solve(nums,i+1,target-nums[i]);
        boolean nottake=solve(nums,i+1,target);
        return dp[i][target]=take||nottake;
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        int target=sum/2;
        dp=new Boolean[nums.length+1][target+1];
        if(sum%2!=0)return false;
        return solve(nums,0,sum/2);
    }
}