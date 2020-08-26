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
// -------------------------------------------------------------------------------------------------------------
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return areMirror(root, root);
    }
    
    public boolean areMirror(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        return (node1.val == node2.val) && areMirror(node1.left, node2.right) && areMirror(node1.right, node2.left);
    }
}

// iterative approach
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        LinkedList<TreeNode> que = new LinkedList<>();
        que.add(root);
        que.add(root);
        boolean res = true;
        while(que.size()>0){
            TreeNode n1 = que.removeFirst();
            TreeNode n2 = que.removeFirst();
            if(n1 == null && n2 == null) continue;
            if(n1 == null || n2 == null){
              res = false;
              break;
            } 
            if(n1.val != n2.val){
                res = false;
                break;
            }
            que.addLast(n1.left);
            que.addLast(n2.right);
            que.addLast(n1.right);
            que.addLast(n2.left);
        }
        return res;
    }
}
