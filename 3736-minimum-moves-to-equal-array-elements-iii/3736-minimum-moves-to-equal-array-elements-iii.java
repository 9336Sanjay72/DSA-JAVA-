class Solution {
    public int minMoves(int[] nums) {
     int sum=0;
     int  max=Integer.MIN_VALUE;
     for(int num : nums)max=Math.max(num,max);
     for(int num : nums){
        sum+=Math.abs(num-max);
     }
     return sum;
        
    }
}