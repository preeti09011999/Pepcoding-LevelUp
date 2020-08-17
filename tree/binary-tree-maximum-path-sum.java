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
    int NTRsum = -(int)1e8;
    public int maxPathSum(TreeNode root) {
        mPathSum(root);
        return NTRsum;
    }
    
    public int mPathSum(TreeNode root){
        if(root == null) return -(int)1e8;
        int lr = mPathSum(root.left);
        int rr = mPathSum(root.right);
        int max_ = Math.max(lr,rr)+root.val;
        NTRsum = Math.max(Math.max(NTRsum,root.val),Math.max(max_,lr+root.val+rr));
        return Math.max(max_, root.val);
    }
}
