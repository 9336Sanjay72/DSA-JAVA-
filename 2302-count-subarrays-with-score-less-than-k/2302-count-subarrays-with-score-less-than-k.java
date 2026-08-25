class Solution {
    public long countSubarrays(int[] nums, long k) {
        long sum=0;
        int n=nums.length;
        long count=0;
        int j=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];// pehle window mai jod lenge 
            long length=i-j+1;
            while(sum*length>=k){
                // ab jaise hi subarray tumhara window size se bada ho gaya waise hi shringk karna chalu kar diya
            sum-=nums[j];
            j++;
            length=i-j+1;
          }      
          count+=i-j+1;

        }
        return count;
    }
}

// brute force  approach
// class Solution {
//     public long countSubarrays(int[] nums, long k) {
//         int n = nums.length;
//         long count = 0;
//         for (int i = 0; i < n; i++) {
//             int sum = 0;
//             int j = i;
//             while (j < n) {
//                 sum += nums[j];
//                 if (((long) sum * (j - i + 1)) < k)
//                     count++;
//                 j++;
//             }
//         }
//         return count;
//     }
// }