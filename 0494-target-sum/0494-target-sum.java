class Solution {
    public int[][]dp;
    public int solve(int[] nums,int target,int i,int currSum,int sum){
        int n=nums.length;
        if(i==n && currSum==target)return 1;
         if(i>=n)return 0;
        if(dp[i][sum+currSum]!=-1)return dp[i][currSum+sum];// why we do currentSum+sum because as we know that if ur some goes in negative ,we cannot store negative index in array thats why we use currentSum+sum
        int positive=solve(nums,target,i+1,currSum+nums[i],sum);// ek baar jod liya
        int negative=solve(nums,target,i+1,currSum-nums[i],sum);// ek baar difference
        return dp[i][currSum+sum]=negative+positive;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int num: nums)sum+=num;
        dp=new int[nums.length+1][sum*2+1];// why we do sum*2+1 because as we know that we have two either take +,- suppose if ur sum became negative so your sample space became twice 
        // suppose ur totalsum  is 4 ur space will we like [-4,-3,-2,-1,0,1,2,3,4]
        for(int[]arr: dp){
            Arrays.fill(arr,-1);
        }
        return solve(nums,target,0,0,sum);
    }
}