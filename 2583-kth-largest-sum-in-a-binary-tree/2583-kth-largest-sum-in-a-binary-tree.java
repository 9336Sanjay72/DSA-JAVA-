class Solution {
    public List<Long> list=new ArrayList<>();
    Queue<TreeNode> q=new LinkedList<>();
    public void solve(TreeNode root){
        q.add(root);
        while(!q.isEmpty()){
            long sum=0;      
            int size=q.size();   
            for(int i=0;i<size;i++){
                TreeNode element=q.poll();
                sum+=element.val;
                if(element.left!=null)q.add(element.left);
                if(element.right!=null)q.add(element.right);
            }
            list.add(sum);
        }
    }
    public long kthLargestLevelSum(TreeNode root, int k) {
        solve(root);
        Collections.sort(list);
        int size=list.size();
        if(k>size)return -1;
        return list.get(size-k);

    }
}