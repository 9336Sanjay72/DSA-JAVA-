class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            nums[i]=nums[i]*nums[i];
        }
        Arrays.sort(nums);
        int half=n/2;
        long minusSum=0;
        for(int i=0;i<half;i++){
            minusSum+=nums[i];
        }
        long plusSum=0;
        for(int i=half;i<n;i++){
            plusSum+=nums[i];
        }
        return plusSum-minusSum;
    }
}