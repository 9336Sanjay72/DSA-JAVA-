class Solution {
    List<List<Integer>>  result;
    public void solve(int[]nums,int idx,List<Integer> temp){
        if(idx==nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        // include
        temp.add(nums[idx]);
        solve(nums,idx+1,temp);
        //exclude //bactrack
        temp.remove(temp.size()-1);
        int i=idx+1;
        while(i<nums.length && nums[i]==nums[i-1])i++;
        solve(nums,i,temp);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result=new ArrayList<>();
        Arrays.sort(nums);
        solve(nums,0,new ArrayList<>());
        return result;
    }
}