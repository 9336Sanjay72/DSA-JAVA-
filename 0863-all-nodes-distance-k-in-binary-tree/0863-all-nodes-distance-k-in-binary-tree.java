class Node{
    int val;
    Node left;
    Node right;
    Node parent;
    Node (int val){
        this.val=val;
    }
}
class Solution {
   public Node newTarget=null;
   public List<Integer> result=new ArrayList<>();
   public Set<Node> visited = new HashSet<>();

    public void build(TreeNode root,Node newNode,TreeNode target){
        if(root==null)return;
        if(root==target){
            newTarget=newNode;
        }
        if(root.left!=null){
            newNode.left=new Node(root.left.val);
            newNode.left.parent=newNode;
            build(root.left,newNode.left,target);
        }
        if(root.right!=null){
            newNode.right=new Node(root.right.val);
            newNode.right.parent=newNode;
            build(root.right,newNode.right,target);
        }
        
    }
    public void solve(Node target,int k){
        Queue<Node> q=new LinkedList<>();
        q.add(target);
        visited.add(target);
        while(!q.isEmpty()){
            int size=q.size();
            if(k==0){
                while(!q.isEmpty()){
                    result.add(q.poll().val);
                }
                return;
            }
            for(int i=0;i<size;i++){
                Node newNode=q.poll();
                if(newNode.parent!=null && !visited.contains(newNode.parent) ){
                    visited.add(newNode.parent);
                    q.add(newNode.parent);
                    }
                if (newNode.left != null && !visited.contains(newNode.left)) {
                    visited.add(newNode.left);
                    q.add(newNode.left);
                 }

                if (newNode.right != null && !visited.contains(newNode.right)) {
                    visited.add(newNode.right);
                    q.add(newNode.right);
                }
            }
            k--;

        }

    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root==null)return result;
        Node newRoot=new Node(root.val);
        newRoot.parent=null;
        build(root,newRoot,target);
        solve(newTarget,k);
        return result;
    }
}