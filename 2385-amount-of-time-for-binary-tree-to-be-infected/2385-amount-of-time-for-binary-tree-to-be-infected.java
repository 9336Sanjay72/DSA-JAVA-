class Node{
    int val;
    Node left;
    Node right;
    Node parent;
    Node(int val){
        this.val=val;
    }
}
class Solution {
    public int count=0;
    public Node newStart=null;
    public Set<Node> visited=new HashSet<>();
    public void buildTree(TreeNode root,Node newNode,int start){
        if(root==null)return;
        if(newNode.val==start){
            newStart=newNode;
        }
        if(root.left!=null){
            newNode.left=new Node(root.left.val);
            newNode.left.parent=newNode;
            buildTree(root.left,newNode.left,start);
        }
        if(root.right!=null){
            newNode.right=new Node(root.right.val);
            newNode.right.parent=newNode;
            buildTree(root.right,newNode.right,start);
        }
        
    }
    public void bfs(Node newStart){
        Queue<Node> q=new LinkedList<>();
        q.add(newStart);
        visited.add(newStart);
        while(!q.isEmpty()){
            count++;
            int size=q.size();
            for(int i=0;i<size;i++){
                Node node=q.poll();
                if(node.parent!=null && !visited.contains(node.parent)){
                    q.add(node.parent);
                    visited.add(node.parent);
                    }
                if(node.left!=null && !visited.contains(node.left)){
                    q.add(node.left);
                    visited.add(node.left);
                    }
                if(node.right!=null && !visited.contains(node.right)){
                    q.add(node.right);
                    visited.add(node.right);
                    }
            }
        }
    }
    public int amountOfTime(TreeNode root, int start) {
        if(root==null)return count;
        Node node=new Node(root.val);
        node.parent=null;
        buildTree(root,node,start);
        bfs(newStart);
        return count-1;
    }
}