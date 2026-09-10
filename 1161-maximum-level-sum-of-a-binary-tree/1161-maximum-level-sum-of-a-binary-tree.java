class Solution {
    public int max=Integer.MIN_VALUE;
    public Queue<TreeNode> q=new LinkedList<>();
    public int level=0;
    public void solve(TreeNode root){
        q.add(root);
        int j=0;
        while(!q.isEmpty()){
            int size=q.size();
            int sum=0;
            j++;
            for(int i=0;i<size;i++){
                TreeNode ele=q.poll();
                sum+=ele.val;
                if(ele.left!=null)q.add(ele.left);
                if(ele.right!=null)q.add(ele.right);
            }
           if(max<sum){
            max=sum;
            level=j;
           }
        }
    }
    public int maxLevelSum(TreeNode root) {
        solve(root);
        return level;
    }
}