class Solution {
    public List<List<Integer>> result=new ArrayList<>();
    public void solve(int[]nums,int k,int i,List<Integer> temp){
        if(k==0){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(i>=nums.length)return;
        temp.add(nums[i]);
        solve(nums,k-1,i+1,temp);
        temp.remove(temp.size()-1);
        solve(nums,k,i+1,temp);
    }
    public List<List<Integer>> combine(int n, int k) {
        int[]nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i+1;
        }
        solve(nums,k,0,new ArrayList<>());
        return result;
    }
}