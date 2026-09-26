public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "";
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null){
                sb.append("null");
            }
            else{
                sb.append(node.val);
                q.add(node.left);
                q.add(node.right);
            }
            sb.append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))return null;
        Queue<TreeNode > q=new LinkedList<>();
        String[]s=data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(s[0]));
        q.add(root);
        int i=1;
        while(i<s.length && !q.isEmpty()){
            TreeNode node=q.poll();
            if(!s[i].equals("null") && i<s.length ){
               node.left= new TreeNode(Integer.parseInt(s[i]));
               q.add(node.left);
            }
            i++;
           if(!s[i].equals("null") && i<s.length){
               node.right= new TreeNode(Integer.parseInt(s[i]));
               q.add(node.right);
            }
            i++;
        }
        return root;
      }
    }


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;