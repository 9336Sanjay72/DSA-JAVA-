class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        if(n==1)return 1;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int minIdx=0;
        int maxIdx=0;
        for(int i=0;i<n;i++){
            if(max<nums[i]){
                maxIdx=i;
                max=nums[i];
            }
            if(min>nums[i]){
                minIdx=i;
                min=nums[i];
            }
        }
        // case 1 it means we to remove one element from front and and one from back 
        // suppose minIdx is on left and max index on right 
        int case1=minIdx+1 + n-maxIdx;
        // suppose minIdx is on right  and max index on left 
        int case2=maxIdx+1 +n-minIdx;

        //case 3 it means we have to remove all the element from front means both min and max element is in left
        int case3=Math.max(minIdx,maxIdx)+1;
        
        //case 4 it means we have to remove all the element from back means both min and max element is in right
        int case4=n-Math.min(minIdx,maxIdx);
        // now return minimum of all the above 4 cases 
        return Math.min(case1,Math.min(case2,Math.min(case3,case4)));

        
    }
}