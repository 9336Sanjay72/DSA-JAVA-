class Solution {
    public boolean findSubarrays(int[] nums) {
        List<Integer> list=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        for(int i=1;i<nums.length;i++){
            set.add(nums[i]+nums[i-1]);
            list.add(nums[i]+nums[i-1]);
        }
        if(set.size()==list.size())return false;
        return true;
    }
}