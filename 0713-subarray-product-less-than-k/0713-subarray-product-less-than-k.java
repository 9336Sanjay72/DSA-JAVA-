class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length;
        int j=0;
        int product=1;
        int count=0;
        if(n==1 && nums[0]>k)return 0;
        if(n==1 && nums[0]<k)return 1;
        for(int i=0;i<n;i++){
            product*=nums[i];
            while(product>=k){
                product/=nums[j];
                j++;
            }
            count+=i-j+1;
        }
        return count;
    }
}