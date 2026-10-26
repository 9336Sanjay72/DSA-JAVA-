class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int[]nums=new int[n*n];
        int k = 0;
        int sum=0;
        for (int[] arr : grid) {
            for (int val : arr) {
                nums[k++] = val;
                sum+=val;
            }
        }
        Arrays.sort(nums);
        n=nums.length;
        int duplicates=0;
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]){
                duplicates=nums[i];
                break;
            }
        }
        int maxSum=n*(n+1)/2;
        int missing=0;
        if(nums[n-1]!=n){
            missing=n;
        }
        else{
             missing=maxSum-(sum-duplicates);
        }
       return new int[]{duplicates,missing};

    }
}