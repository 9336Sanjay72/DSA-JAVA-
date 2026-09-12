class Solution {
    public int solve(TreeNode root){
        if(root==null)return 0;
        return 1+Math.max(solve(root.left),solve(root.right));
    }
    public int maxDepth(TreeNode root) {
        return solve(root);
    }
}