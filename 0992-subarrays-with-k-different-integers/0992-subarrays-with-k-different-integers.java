class Solution {
    public int atMostSubarray(int[]nums,int k){
        int n=nums.length;
        int count=0;
        int j=0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while(map.size()>k){
                if(map.get(nums[j])>0){
                   map.put(nums[j],map.get(nums[j])-1);
                }
                if(map.get(nums[j])==0)map.remove(nums[j]);
                j++;
            }
            count+=i-j+1;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostSubarray(nums,k)-atMostSubarray(nums,k-1);
    }
}