class Solution {
    public void dfs(int curr, List<List<Integer>> adj,int[]indegree,boolean sus[]){
        sus[curr]=true;
        for(int num : adj.get(curr)){
            indegree[num]--;
            if(!sus[num]){

                dfs(num,adj,indegree,sus);             
            }
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] nums) {
        List<List<Integer>> adj=new ArrayList<>();      
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[]indegree=new int[n];
        for(int []num :nums){
            int u=num[0];
            int  v=num[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        boolean sus[]=new boolean[n];       
        dfs(k,adj,indegree,sus);
        boolean flag=true;
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<n;i++){
          if(sus[i] && indegree[i]>0){// iska mtlab bahar wala element se connect hai jo suspicious bhi nah hai
            flag=false;
            break;}
            if(!sus[i]){
                result.add(i);
            } 
        }
        if(!flag){
            List<Integer> ans=new ArrayList<>();
            for(int i=0;i<n;i++){
                ans.add(i);
            }
            return ans;
        }
        return result;

    }
}