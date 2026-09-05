class Solution {
    public List<List<Integer>> result=new ArrayList<>();
    public void solve(int[]nums,int target,List<Integer> list,int idx){
        //base case
        // if(result.contains(list))return;
        if(target==0){
            result.add(new ArrayList<>(list));
            return;
        }
        if(target<0 || idx>=nums.length)return ;
        // take
        list.add(nums[idx]);
        solve(nums,target-nums[idx],list,idx+1);
        list.remove(list.size()-1);
        while(idx+1<nums.length && nums[idx]==nums[idx+1])idx++;
        solve(nums,target,list,idx+1);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n=candidates.length;
        Arrays.sort(candidates);
        solve(candidates,target,new ArrayList<>(),0);
        return result;
    }
}