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
    List<TreeNode> pAncestor=new ArrayList<>();
    List<TreeNode> qAncestor=new ArrayList<>();
    public boolean  solve(TreeNode root,int p,int q){
        if(root==null)return false;
        pAncestor.add(root);
        if(root.val==p)return true;
        if(solve(root.left,p,q)) return true;
        if(solve(root.right,p,q)) return true;
        pAncestor.remove(pAncestor.size() - 1);
        return false;
    }
    public boolean dfs(TreeNode root,int p,int q){
        if(root==null)return false;
        qAncestor.add(root);
        if(root.val==q)return true;
       if(dfs(root.left,p,q)) return true;
        if(dfs(root.right,p,q)) return true;
        qAncestor.remove(qAncestor.size() - 1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean x=solve(root,p.val,q.val);
        boolean y=dfs(root,p.val,q.val);
        int n=Math.min(pAncestor.size(),qAncestor.size());
        TreeNode temp=null;
        for(int i=0;i<n;i++){
            if(pAncestor.get(i).val==qAncestor.get(i).val){
                temp=pAncestor.get(i);
            } 
            else break;
        }
        return temp;
    }
}