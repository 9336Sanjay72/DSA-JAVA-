class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int[]prefix=new int[n];
        int result=0;
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        Map<Integer,Integer> map=new HashMap<>(); 
        for(int i=0;i<n;i++){
             if(k==prefix[i])result++;
             int val=prefix[i]-k;
             if(map.containsKey(val)){
               result+= map.get(val);
             }
             map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1);        
        }
        return result;
    }
}