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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0) return null;
        int n = postorder.length;
        return buildTree_(postorder, 0, n-1, inorder, 0, n-1);
    }
    public TreeNode buildTree_(int[] postorder, int psp, int pep,int[] inorder, int isp, int iep) {
         if(psp > pep) return null;
        int idx = isp;
        while(inorder[idx] != postorder[pep]) idx++;
        int len = idx - isp;
        TreeNode node = new TreeNode(postorder[pep]);
        node.left = buildTree_(postorder, psp, psp + len - 1, inorder, isp, idx - 1);
        node.right = buildTree_(postorder, psp + len , pep - 1, inorder, idx + 1, iep);
        return node;
    }
}
