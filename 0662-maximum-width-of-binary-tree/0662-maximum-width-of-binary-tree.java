class Pair{
    TreeNode node;
    int idx;
    Pair(TreeNode node,int idx){
        this.node=node;
        this.idx=idx;
    }
}
class Solution {
    public int max=0;
    public void solve(TreeNode root){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        int firstIdx=0;
        int lastIdx=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                 Pair p=q.poll();
                 if(i==0)firstIdx=p.idx;
                 if(i==size-1)lastIdx=p.idx;
                 if(p.node.left!=null)q.add(new Pair(p.node.left,p.idx*2+1));
                 if(p.node.right!=null)q.add(new Pair(p.node.right,p.idx*2+2));
            }
            max=Math.max(max,lastIdx-firstIdx);

        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        solve(root);
        return max+1;
    }
}