/* class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Tree
{
    public int leaftoleafsum = -(int)1e8;
    int maxPathSum(Node root)
    { 
        leaf_to_leaf_sum(root);
        return leaftoleafsum;
    } 
    public int leaf_to_leaf_sum(Node node){
        if(node == null) return -(int)1e8;
        if(node.left == null && node.right == null) return node.data;
        int lmax = leaf_to_leaf_sum(node.left);
        int rmax = leaf_to_leaf_sum(node.right);
        if(node.left != null && node.right != null){
            leaftoleafsum = Math.max(leaftoleafsum,lmax+node.data+rmax);
        }
        return Math.max(lmax,rmax)+node.data;
    }
    
}
