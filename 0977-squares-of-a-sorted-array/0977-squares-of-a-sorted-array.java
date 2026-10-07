class Solution {
    public int[] sortedSquares(int[] nums) {
        int[]arr=new int[nums.length];
        int j=nums.length-1;
        int i=0;
        int k=nums.length-1;
        while(i<=j){          
            if(nums[i]*nums[i] >=nums[j]*nums[j]){
                arr[k--]=nums[i]*nums[i];
                i++;
            }
            else{
                arr[k--]=nums[j]*nums[j];
                j--;
            }
        }
        return arr;
    }
}