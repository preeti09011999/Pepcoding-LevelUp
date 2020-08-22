class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class Tree
{ 
    Node head = null;
    Node prev = null;
    Node bTreeToClist(Node root)
    {
        bTreeToClist_(root);
        prev.right = head;
        head.left = prev;
        return head;
    }
    public void bTreeToClist_(Node root){
        if(root == null) return;
        bTreeToClist_(root.left);
        if(head == null) head = root;
        else{
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        bTreeToClist_(root.right);
    }
    
}
    
