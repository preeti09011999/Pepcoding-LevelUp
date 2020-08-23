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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        int n = preorder.length;
        return buildTree_(preorder, 0, n-1, inorder, 0, n-1);
    }
    public TreeNode buildTree_(int[] preorder, int psp, int pep,int[] inorder, int isp, int iep) {
        if(psp > pep) return null;
        int idx = isp;
        while(inorder[idx] != preorder[psp]) idx++;
        int len = idx - isp;
        TreeNode node = new TreeNode(preorder[psp]);
        node.left = buildTree_(preorder, psp + 1, psp + len, inorder, isp, idx - 1);
        node.right = buildTree_( preorder, psp + len + 1, pep, inorder, idx + 1, iep);
        return node;
    }
    
}
