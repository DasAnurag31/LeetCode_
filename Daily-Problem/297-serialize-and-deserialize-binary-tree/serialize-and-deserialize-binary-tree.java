
public class Codec {

    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        StringBuilder str = new StringBuilder();

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                str.append("-").append("_");
            }else{
                str.append(node.val).append("_");
                q.offer(node.left);
                q.offer(node.right);
            }
        }

        System.out.println(str);
        return str.toString();
    }

    public TreeNode deserialize(String data) {
        if(data == ""){
            return null;
        }
        String[] nodes= data.split("_");
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        int index = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(!nodes[++index].equals("-")){
                node.left = new TreeNode(Integer.valueOf(nodes[index]));
                q.offer(node.left);
            }
            if(!nodes[++index].equals("-")){
                node.right = new TreeNode(Integer.valueOf(nodes[index]));
                q.offer(node.right);
            }
        }

        return root;
    }
}