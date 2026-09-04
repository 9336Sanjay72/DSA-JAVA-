class Solution {
    public List<List<Integer>> result=new ArrayList<>();
    public void solve(int k,int n,int sum,List<Integer> list,int start){
            // base case
            if(sum==n && k==0){
                result.add(new ArrayList<>(list));
                return;
            }
            if(sum>n || k<0 || start>9)return;
                
                list.add(start);
                solve(k-1,n,sum+start,list,start+1);
                list.remove(list.size()-1);
                solve(k,n,sum,list,start+1);
            
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        solve(k,n,0,new ArrayList<>(),1);
        return result;
    }
}