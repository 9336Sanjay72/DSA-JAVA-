/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "";
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null)sb.append("null");
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
    public TreeNode deserialize(String s) {
        if(s.equals(""))return null;
        Queue<TreeNode> q=new LinkedList<>();
        String str[]=s.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(str[0]));
        q.add(root);
        int i=1;
        while(i<str.length && !q.isEmpty()){
            TreeNode node=q.poll();
            if(i<str.length && !str[i].equals("null")){
                node.left=new TreeNode(Integer.parseInt(str[i]));
                q.add(node.left);

            }
            i++;
            if(i<str.length && !str[i].equals("null")){
                node.right=new TreeNode(Integer.parseInt(str[i]));
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
// TreeNode ans = deser.deserialize(ser.serialize(root));