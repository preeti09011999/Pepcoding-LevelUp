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

//--------------------O(n) space - O(1)
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
    TreeNode LCANode = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestor_(root,p,q);
        return LCANode;
    }
    
    public boolean lowestCommonAncestor_(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return false;
        boolean selfdone = false;
        if(root == p || root == q) selfdone = true;
        boolean leftdone = lowestCommonAncestor_(root.left, p, q);
        if(LCANode != null) return true;
        boolean rightdone = lowestCommonAncestor_(root.right, p, q);
        if((leftdone && selfdone)||(rightdone && selfdone)||(leftdone && rightdone)) LCANode = root;
        return leftdone || rightdone || selfdone;
    }
}
