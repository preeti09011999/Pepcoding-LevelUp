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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return hasPath(root,sum,0);
    }
    
    public boolean hasPath(TreeNode root, int sum, int res){
        if(root == null){
            return false;
        } 
        
        if(root.left == null && root.right == null && sum == res+root.val) return true;
        
        if(hasPath(root.left, sum, res+ root.val)) return true;
        if(hasPath(root.right,sum,res+root.val)) return true;
        return false;
    }
}
