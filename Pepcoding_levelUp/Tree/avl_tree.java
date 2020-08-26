import java.io.*;
import java.util.*;
public class avl_tree{
    public static class Node{
        int data =0;
        Node left = null;
        Node right = null;
        int bal = 0;
        int ht = 0;
        Node(int data){
            this.data = data;
        }
    }

    public public static void main(String args[]) {
        solve();
    }

    public static void display(Node node){
        if(node == null) return;
        String str = "";
        str += (node.left != null) ? node.left.data+"" : ".";
        str += " <-"+node.data+"-> ";
        str += (node.right != null) ? node.right.data+"" : ".";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }

    // -----------------Get Rotation------------------
    public static Node getRotation(Node node) {
        update_height_balance(node);
        if(node.bal == 2){
            // ll or lr
            if(node.left.bal == 1){
                // ll
                return rightRotation(node);
            }else{
                // lr
                
            }
        }   
        else if(node.bal == -2){
            // rr, rl
            if(node.right.bal == -1){
                // rr
                return leftRotation(node);
            }else{
                // rl
            }
        }
    }

    // -------------update height balance -----------------------
    
    public static void update_height_balance(Node node){
        // O(1) complexity
        int lh = -1;
        int rh = -1;
        if(node.left != null) lh = node.left.ht;
        if(node.right != null) rh = node.right.ht;
        int bal = lh - rh;
        int ht = Math.max(lh, rh) + 1;
        node.ht = ht;
        node.bal = bal;
    }

    // ------------- left rotation ----------------------------

    public static Node leftRotation(Node A) {
        Node B = A.right;
        Node B_left = B.left;
        B.left = A;
        A.right = B_left;
        update_height_balance(A);
        update_height_balance(B);
    }

    // ----------right rotation -------------------------------

    public static Node rightRotation(Node A) {
        Node B = A.left;
        Node B_right = B.right;
        B.right = A;
        A.left = B_right;
        update_height_balance(A);
        update_height_balance(B);
        return B;
        
    }

    //--------------traversal----------------------------
    public static class tPair{
        Node node = null;
        boolean selfdone = false;
        boolean leftdone = false;
        boolean rightdone = false;
        tPair(Node node, boolean selfdone, boolean leftdone, boolean rightdone){
            this.node = node;
            this.selfdone = selfdone;
            this.leftdone = leftdone;
            this.rightdone = rightdone;
        }
    }

    public static void traversal(Node node) {
        Stack<tPair> st = new Stack<>();
        st.push(new tPair(node,false,false,false));
        while(st.size()!=0){
            tPair rvtx = st.peek();
            if(!rvtx.leftdone){
                rvtx.leftdone = true;
                if(rvtx.node.left != null) st.push(new tPair(rvtx.node.left, false, false, false));
            }else if(!rvtx.righttdone){
                rvtx.righttdone = true;
                if(rvtx.node.right != null) st.push(new tPair(rvtx.node.right, false, false, false));
            }else if(!rvtx.selfdone){
                rvtx.selfdone = true;
                System.out.println(rvtx.node.data + " ");
            }else{
                st.pop();
            }
        }
    }

    // ------------------diameter (iteratively) ------------------
    public static class dPair{
        Node node = null;
        int 
    } 
    public static void diameter(Node node) {
        Stack<dPair> st = new Stack<>();

    }

    // --------binary tree cameras--------------------------------

    class Solution {
        int cameras = 0;
        public int minCameraCover(TreeNode root) {
            if(root == null) return 0;
            if(minCameraCover_(root) == -1) cameras++;
            return cameras;
        }
        
        public int minCameraCover_(TreeNode root){
            if(root == null) return 1;
            // camera required = -1
            // camera = 0
            // child covered = 1
            int lans = minCameraCover_(root.left);
            int rans = minCameraCover_(root.right);
            if(lans == -1 || rans == -1){
                cameras++;
                return 0;
            }
            if(lans == 0 || rans == 0) return 1;
            return -1;
            
        }
    }

    // ------ distribute coins in binary tree -------------------
    
    class Solution {
        int totalcoins = 0;
        public int distributeCoins(TreeNode root) {
            if(distributeCoins_(root) != 0) return -1;
            return totalcoins;
        }
        
        public int distributeCoins_(TreeNode root){
            if(root == null) return 0;
            // left deficiency gain
            int leftDefeGain = distributeCoins_(root.left);
            // right deficiency gain
            int rightDefeGain = distributeCoins_(root.right);
            
            totalcoins += Math.abs(leftDefeGain) + Math.abs(rightDefeGain);
            return root.val - 1 + leftDefeGain + rightDefeGain;
        }
    }
}

