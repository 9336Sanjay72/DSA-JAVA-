class Solution {
    public boolean canFinish(int n, int[][] nums) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        int m=nums.length;
        for(int i=0;i<m;i++){
            list.get(nums[i][0]).add(nums[i][1]);
        }
        int indegree[]=new int[n];
        for(int i=0;i<n;i++){
            for(int num:list.get(i)){
                indegree[num]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0)q.offer(i);
        }
        List<Integer> result=new ArrayList<>();
        while(q.size()>0){
            int node=q.poll();
            result.add(node);
            for(int num : list.get(node)){
                indegree[num]--;
                if(indegree[num]==0)q.add(num);
            }
        }
        if(result.size()==n)return true;
        return false;

    }
}