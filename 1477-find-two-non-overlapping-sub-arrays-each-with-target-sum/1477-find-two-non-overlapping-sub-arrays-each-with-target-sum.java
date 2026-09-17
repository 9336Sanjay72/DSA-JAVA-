class Solution {
    public int minSumOfLengths(int[] nums, int target) {
        int j=0;
        int currentSum=0;
        int n=nums.length;
        int[]minTillIdx=new int[n];
        Arrays.fill(minTillIdx,Integer.MAX_VALUE);
        int bestMin=Integer.MAX_VALUE;
        int result=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            currentSum+=nums[i];
            while( currentSum>target  ){
                currentSum-=nums[j];
                j++;
            }
            if(currentSum==target ){
                int len=i-j+1;
                if(j>0 && minTillIdx[j-1]!=Integer.MAX_VALUE){
                    result=Math.min(len+minTillIdx[j-1],result);
                }
                bestMin=Math.min(len,bestMin);
            }
            minTillIdx[i]=bestMin;
        }
        if(result==Integer.MAX_VALUE)return -1;
        return result;
    }
}