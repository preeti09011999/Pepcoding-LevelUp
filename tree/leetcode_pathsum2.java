/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        path(root, sum,ans,res);
        return res;
    }
    
    public void path(TreeNode node, int sum, List<Integer> ans, List<List<Integer>> res){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null && sum - node.val==0){
            ArrayList<Integer> value = new ArrayList<>(ans);
            value.add(node.val);
            res.add(value);
            return;
        }
        ans.add(node.val);
        path(node.left,sum-node.val,ans,res);
        path(node.right,sum-node.val,ans,res);
        ans.remove(ans.size()-1);
    }
}
