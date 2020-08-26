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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return areMirror(root, root);
    }
    
    public boolean areMirror(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null) return true;
        if((node1 == null && node2 != null) || (node2 == null && node1 != null)) return false;
        if(node1.val != node2.val) return false;
        if(!areMirror(node1.left, node2.right)) return false;
        if(!areMirror(node1.right, node2.left)) return false;
        return true;
    }
}
