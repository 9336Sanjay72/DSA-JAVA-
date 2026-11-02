
class Solution {
    public int[][]dp;
    public int solve(int[]nums,int i,int []arr,int j){
        // base case
        if(i>=nums.length || j>=arr.length) return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(nums[i]==arr[j]){
            return dp[i][j]=1+solve(nums,i+1,arr,j+1);
        }
        return dp[i][j]=Math.max(solve(nums,i+1,arr,j),solve(nums,i,arr,j+1));
    }
    public int lengthOfLIS(int[] nums) {
        Set<Integer>set=new HashSet<>();
        for(int num :nums)set.add(num);
        int i = 0;
        int []arr=new int[set.size()];
        for(int num : set) arr[i++] = num;
        Arrays.sort(arr);
        dp=new int[nums.length+1][nums.length+1];
        for(int []num:dp)Arrays.fill(num,-1);
        return solve(nums,0,arr,0);
    }
}

