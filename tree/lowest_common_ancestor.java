/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pa = new ArrayList<>();
        nodeToRootPath(root,p,pa);
        ArrayList<TreeNode> qa = new ArrayList<>();
        nodeToRootPath(root,q,qa);
        int n1 = pa.size()-1;
        int n2 = qa.size()-1;
        while(n1 >= 0 && n2 >= 0 && pa.get(n1)==qa.get(n2)){
            n1--;
            n2--;
        }
        return pa.get(n1+1);
    }
    
    public boolean nodeToRootPath(TreeNode node, TreeNode des,ArrayList<TreeNode> path){
        if(node == null) return false;
        if(node.val == des.val){
            path.add(node);
            return true;
        }
        path.add(node);
        boolean res = false;
        res = res || nodeToRootPath(node.left,des,path);
        res = res || nodeToRootPath(node.right,des,path);
        if(res){
          path.add(node);
          return true;  
        } 
        
        return false;
    }
}
