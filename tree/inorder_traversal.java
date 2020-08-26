// recursive approach ---------------------
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder_traversal(root, ans);
        return ans;
    }
    
    public void inorder_traversal(TreeNode root, List<Integer> ans){
        if(root == null) return;
        inorder_traversal(root.left, ans);
        ans.add(root.val);
        inorder_traversal(root.right, ans);
    }
}

// iterative approach
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        inorder_traversal(root, ans);
        return ans;
    }
    
    public class tPair{
        TreeNode node;
        boolean selfdone = false;
        boolean leftdone = false;
        boolean rightdone = false;
        tPair(TreeNode node){
            this.node = node;
            this.selfdone = false;
            this.leftdone = false;
            this.rightdone = false;
        }
    }
    public void inorder_traversal(TreeNode root, List<Integer> ans){
        Stack<tPair> st = new Stack<>();
        st.add(new tPair(root));
        while(st.size()>0){
            tPair pb = st.peek();
            if(!pb.leftdone){
                pb.leftdone = true;
                if(pb.node.left != null) st.push(new tPair(pb.node.left));
            }
            else if(!pb.selfdone){
                pb.selfdone = true;
                ans.add(pb.node.val);
            }
            else if(!pb.rightdone){
                pb.rightdone = true;
                if(pb.node.right != null) st.push(new tPair(pb.node.right));
            }else{
                st.pop();
            }
        }
    }
}
