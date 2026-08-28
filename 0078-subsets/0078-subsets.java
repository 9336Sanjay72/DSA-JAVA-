class Solution {
    public List<List<Integer>> result;
    public void solve(int[]nums,int i,List<Integer> temp){
        if(i==nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        // nahi lena hai 
        solve(nums,i+1,temp);
        temp.add(nums[i]);
        solve(nums,i+1,temp);
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        result=new ArrayList<>();
        solve(nums,0,new ArrayList<>());
        return result;
    }
}