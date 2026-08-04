class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;          
        List<Integer> result=new ArrayList<>();
        for(int i=1;i<n;i++){
            int curr=nums[i-1]+1;
            while(curr<nums[i]){
                result.add(curr);
                curr++;
            }
        }
        return result;
    }
}