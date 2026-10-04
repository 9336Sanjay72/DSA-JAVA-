class Solution {
    public int firstHalf(int[]nums,int target){
        int low=0;
        int high=nums.length-1;
        int idx=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){// yaha suppose tumhe element mil gaya ab tumhe chahiye first index toh iske lye hum left mai continue search karenge
                idx=mid;
                high=mid-1;

            }
            else if(nums[mid]>target) high=mid-1;
            else low=mid+1;
        }
        return idx;
    }
        public int secondHalf(int[]nums,int target){
        int low=0;
        int high=nums.length-1;
        int idx=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){// yaha suppose tumhe element mil gaya ab tumhe chahiye last index toh iske lye hum right mai continue search karenge
                idx=mid;
                low=mid+1;

            }
            else if(nums[mid]>target) high=mid-1;
            else low=mid+1;
        }
        return idx;
    }
    public int[] searchRange(int[] nums, int target) {
        int first=firstHalf(nums,target);
        int last=secondHalf(nums,target);
        int[]result=new int[2];
        result[0]=first;
        result[1]=last;
        return result;
    }
}