class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null)return result;
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            int x=0;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.left!=null)q.add(node.left);
                if(node.right!=null)q.add(node.right);
                x=node.val;
            }
            result.add(x);
        }
        return result;
    }
}