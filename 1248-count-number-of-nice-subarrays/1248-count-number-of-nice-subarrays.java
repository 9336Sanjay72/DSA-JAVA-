class Solution {
    public int solve(int nums[],int k){
        int n=nums.length;
        int i=0,j=0;
        int count=0;
        int oddCount=0;
        while(i<n){
            if(nums[i]%2!=0)oddCount++;
            while(oddCount>k){
                 if(nums[j]%2!=0)oddCount--;
                 j++;
            }
            count+=i-j+1;
            i++;
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return solve(nums,k)-solve(nums,k-1);
    }
}