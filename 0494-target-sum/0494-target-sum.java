class Solution {
    public int solve(int[] nums,int target,int i,int currSum){
        int n=nums.length;
        if(i==n && currSum==target)return 1;
         if(i>=n)return 0;
        int positive=solve(nums,target,i+1,currSum+nums[i]);// ek baar jod liya
        int negative=solve(nums,target,i+1,currSum-nums[i]);// ek baar difference
        return negative+positive;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums,target,0,0);
    }
}