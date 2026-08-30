class Solution {
    public int maxScore(int[] nums, int k) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        int result=sum;// bhai yaha tak tumne if k==3 hai toh 3 left 0 right ka kar liya hai 
        // ab iske  baad 2 left 1 right 
        //1 left 2 right 
        // 0 left 3 right
        for(int i=0;i<k;i++){
            sum-=nums[k-i-1];
            sum+=nums[n-i-1];
            result=Math.max(sum,result);
        }
        
        return result;
    }
}