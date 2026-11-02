class Solution {
    public int minMoves2(int[] nums) {
        int sum=0;
        int n=nums.length;
        Arrays.sort(nums);
        int mid=n/2;
        for(int i=0;i<n;i++){
            if(i==mid)continue;
            sum+=Math.abs(nums[mid]-nums[i]);
        }
        return sum;
    }
}