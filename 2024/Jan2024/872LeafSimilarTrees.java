class Solution {
    private void getLeaves(TreeNode root,List<Integer> list){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            list.add(root.val);
        }
        if(root.left != null){
            getLeaves(root.left, list);
        }
        if(root.right != null){
            getLeaves(root.right, list);
        }
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        getLeaves(root1, l1);
        getLeaves(root2, l2);
        if(l1.size() != l2.size()){
            return false;
        }
        for(int i=0;i<l1.size();i++){
            if(l1.get(i) != l2.get(i)){
                return false;
            }
        }
        return true;
    }
}
// https://leetcode.com/problems/leaf-similar-trees/?envType=daily-question&envId=2024-01-09