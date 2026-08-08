class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int[]temp=new int[n];
        int negIdx=1;
        int posIdx=0;
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                temp[negIdx]=nums[i];
                negIdx+=2;
            }
            else{
                temp[posIdx]=nums[i];
                posIdx+=2;
            }
        }
        return temp;
    }
}