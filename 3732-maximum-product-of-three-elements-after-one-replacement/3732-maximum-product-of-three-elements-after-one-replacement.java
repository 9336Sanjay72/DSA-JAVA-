class Solution {
    public long maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        // there will be three cases 
        // case1 all positive
        long case1=(long)nums[n-1]*(long)nums[n-2]*100000L;
        // two negative [-7,-5,-4,-2]
        long case2= (long)nums[0]*(long)nums[1]*100000L;
        // one negative and one positve;[-7,0,3,4];
        long case3=(long)nums[0]*-100000L*(long)nums[n-1];
        return Math.max(case1,Math.max(case2,case3));
    }
}