class Solution {
    public List<Integer> list=new ArrayList<>();
    public void solve(TreeNode root){
        if(root==null)return ;
        solve(root.left);
        list.add(root.val);
        solve(root.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        solve(root);
        return list;
    }
}