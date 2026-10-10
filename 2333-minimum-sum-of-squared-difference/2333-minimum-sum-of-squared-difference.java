class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int[]freq=new int[100001];
        int n=nums1.length;
        for(int i=0;i<n;i++ ){
            freq[Math.abs(nums1[i]-nums2[i])]++;
        }
        long sum=0;
        int k=k1+k2;
        for(int i=freq.length-1;i>=0;i--){
            int count=freq[i];
            int countOps=Math.min(count,k);
            k -= countOps;
            freq[i]-=countOps;
            if(i>0)freq[i-1]+=countOps;
        }
        for(int i=0;i<freq.length;i++){
            sum+=(long)freq[i]*i*i;
        }
        return sum;
    }
}