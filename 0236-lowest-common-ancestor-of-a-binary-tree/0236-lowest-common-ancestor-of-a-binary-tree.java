/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode solve(TreeNode root,int p,int q){
        if(root==null)return null;
        if(root.val==p || root.val==q)return root;
        TreeNode leftLca=solve(root.left,p,q);
        TreeNode rightLca=solve(root.right,p,q);
        if(leftLca!=null && rightLca!=null)return root;
        if(leftLca!=null)return leftLca;
        else return rightLca;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       return solve(root,p.val,q.val);
    }
}