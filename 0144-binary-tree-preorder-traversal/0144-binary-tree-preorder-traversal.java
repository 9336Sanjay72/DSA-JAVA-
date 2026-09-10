class Solution {
    public List<Integer> result=new ArrayList<>();
    public void preOrder(TreeNode root){
        if(root==null)return;
        result.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return result;
    }
}