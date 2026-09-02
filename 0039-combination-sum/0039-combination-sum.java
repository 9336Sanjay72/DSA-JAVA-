class Solution {
    public List<List<Integer>> result=new ArrayList<>();
    public void solve(int[]nums,int target,List<Integer> temp,int i,int sum){
        if(target==sum){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        if(target<sum|| i>=nums.length)return;
        // take
        temp.add(nums[i]);
        solve(nums,target,temp,i,sum+nums[i]);// i+1 isliye nahi kia kyuki tum ek hi element ko kai baar le sakte ho 
        //not take
        temp.remove(temp.size()-1);
        solve(nums,target,temp,i+1,sum);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        solve(candidates,target,new ArrayList<>(),0,0);
        return result;
    }
}