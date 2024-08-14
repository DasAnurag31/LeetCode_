class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        TreeNode cur = root;
        while(cur != null){
            if(cur.left == null){
                pre.add(cur.val);
                cur = cur.right;
            }else{
                TreeNode prev = cur.left;
                while(prev.right != null && prev.right != cur){
                    prev = prev.right;
                }

                if(prev.right == null){
                    prev.right = cur;
                    cur = cur.left;
                }
                else{
                    prev.right = null;
                    pre.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return pre;
    }
}