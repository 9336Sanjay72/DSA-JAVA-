class Solution {
    public boolean uniformArray(int[] nums1) {
        int oddMin=Integer.MAX_VALUE;
        int n=nums1.length;
        for(int i=0;i<n;i++){
           if( nums1[i]%2!=0){
            oddMin=Math.min(oddMin,nums1[i]);
           }
        }
        if(oddMin==Integer.MAX_VALUE)return true;// it means all are even 
        int[]nums2=new int[n];
        for(int i=0;i<n;i++){
            if(nums1[i]%2!=0){
                nums2[i]=nums1[i];
            }
            else{
                nums2[i]=nums1[i]-oddMin;
                if(nums2[i]<1)return false;
            }
        }
        return true;

    }
}