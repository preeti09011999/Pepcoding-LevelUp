import java.io.*;
import java.util.*;
public class lecture4{
    public static class Node{
        int data =0;
        Node left = null;
        Node right = null;
        Node(int data){
            this.data = data;
        }
    }

    public static class Pair{
        Node node;
        int level;
        Pair(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }
    public static void main(String args[]){
        // int a[] = {12, 15, -1, -1, 10, 14, 21, -1, -1, 24, -1, -1, 15, 22, -1, -1, 23, -1, -1};
        int arr[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        Node root = construct_BST(arr,0,arr.length-1);
        // display(root);
        // System.out.println(size(root));
        // System.out.println(height(root));
        // inorder_predecessor(root, 30);
        // System.out.println(prev.data);
        // int arr[] = {7,3, 1, 0, 2, 6, 4, 5, 12, 9, 8, 11, 10, 13, 15, 14};
        // Node root = BST_construct_preOrder(arr,-(int)1e8,(int)1e8);
        // System.out.println(BST_preorder_height(arr,-(int)1e8,(int)1e8));
        // display(root);
        allSolutionPair Pair = new allSolutionPair();
        allSolution(root,20, 0,Pair);
        System.out.println("Predecessor -> "+Pair.pred.data);
        System.out.println("Successor -> "+Pair.succ.data);
        System.out.println("Ceil of node -> "+Pair.ceil);
        System.out.println("Floor of node -> "+Pair.floor);

    }

    public static Node construct_BST(int arr[], int sp, int ep){
        if(sp > ep) return null;
        int mid = (sp + ep) >> 1;
        Node node = new Node(arr[mid]);
        node.left = construct_BST(arr,sp,mid-1);
        node.right = construct_BST(arr,mid+1,ep);
        return node;
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

    public static int size(Node node){
        return (node == null) ? 0 : size(node.left) + 1 + size(node.right);
    }

    public static int height(Node node){
        return (node == null) ? -1 : Math.max(height(node.left),height(node.right))+1;
    }

    public static boolean find(Node node,int data){
        Node curr = node;
        while(curr != null){
            if(curr.data == data) return true;
            else if(data < curr.data ) curr = curr.left;
            else curr = curr.right;
        }
        return false;
    }
// ---------------------binary tree to circular doubly linked list---------------
    // Node bTreeToClist(Node root)
    // {
    //     bTreeToClist_(root);
    //     prev.right = head;
    //     head.left = prev;
    //     return head;
    // }
    // public void bTreeToClist_(Node root){
    //     if(root == null) return;
    //     bTreeToClist_(root.left);
    //     if(head == null) head = root;
    //     else{
    //         root.left = prev;
    //         prev.right = root;
    //     }
    //     prev = root;
    //     bTreeToClist_(root.right);
    // }
    
//----------leetcode 99 -> Recover Binary tree-------------------------
   //----------------graph solution
// class Solution {
//     public void recoverTree(TreeNode root) {
//         recoverTree_(root);
//         if(A != null){
//             int temp = A.val;
//             A.val = B.val;
//             B.val = temp;
//         }
//     }
//     TreeNode A = null, B = null;
//     TreeNode prev = null;
//     public boolean recoverTree_(TreeNode root){
//         if(root == null) return false;
//         if(recoverTree_(root.left)) return true;
//         if(prev != null && prev.val > root.val){
//             B = root;
//             if(A == null) A = prev;
//             // if A is already marked then we have to just mark B which will be done in above line
//             else return true;
//         }
//         prev = root;
//         if(recoverTree_(root.right)) return true;
//         return false;
//     }
// }


//------------------------construct BST using its preorder--------------------------
    static int idx = 0;
    public static Node BST_construct_preOrder(int arr[], int lRange, int rRange){
        // base case
        if(idx >= arr.length || arr[idx] < lRange || arr[idx] > rRange) return null;
        Node node = new Node(arr[idx++]);
        node.left = BST_construct_preOrder(arr,lRange, node.data);
        node.right = BST_construct_preOrder(arr, node.data, rRange);
        return node;
    }

// ----------calculating height of BST without constructing the tree-------------------
     static int id = 0;
    public static int BST_preorder_height(int arr[],int lRange, int rRange){
        if(id >= arr.length || arr[id] < lRange || arr[id] > rRange) return -1;
        int ele = arr[id++];
        int lh = BST_preorder_height(arr,lRange,ele);
        int rh = BST_preorder_height(arr,ele,rRange);
        return Math.max(lh,rh)+1;
    }
    
    // --------------predecessor and successor using all Solver-----------------------
    public static class allSolutionPair{
        int ht = 0;
        int size = 0;
        boolean find = false;
        int ceil = (int)1e8;
        int floor = -(int)1e8;
        Node pred = null;
        Node succ = null;
        Node prev = null;
    }

    public static void allSolution(Node node, int data, int level, allSolutionPair Pair){
        if(node == null) return;
        // to calculate height 
        Pair.ht = Math.max(Pair.ht, level);
        Pair.size++;
        Pair.find = Pair.find || node.data == data;
        if(node.data > data) {
            // ceil
            if(node.data < Pair.ceil) Pair.ceil = node.data;
        }
        if(node.data < data){
            // floor
            if(node.data > Pair.floor) Pair.floor = node.data;
        }
        if(Pair.pred == null && node.data == data) Pair.pred = Pair.prev;
        if(Pair.prev != null && Pair.prev.data == data) Pair.succ = node;
        Pair.prev = node;
        allSolution(node.left, data, level+1, Pair);
        allSolution(node.right, data, level+1, Pair);

    }


    // ------------Predecessor - Successor
    public static void predSucc(Node node, int data){
        Node curr = node;
        Node pred = null, succ = null;
        while(curr != null){
            if(curr.data == data){
                // 1st scenario when left subtree and right subtree are present
                if(curr.left != null){
                    pred = curr.left;
                    while(pred.right != null) pred = pred.right;
                } 

                if(curr.right != null){
                    succ = curr.right;
                    while(succ.left != null) succ = succ.left;
                }
                break;
            }
            // 2nd scenario when any one of the subtree is not present
            else if(curr.data < data){
                pred = curr;
                curr = curr.right;
            }
            else{
                succ = curr;
                curr = curr.left;
            }
        }

    }

    // inorder successor in BST leetcode qsn
    // using node's value
    public static Node inorder_succ(Node node){
        Node curr = node;
        Node succ = null;
        if(curr.right != null){
            succ = curr.right;
            while(succ.left != null) succ = succ.left;
            return succ;
        }
// when node.right is null then we will check for the first parent of the node whose data is greater than node.data
         int val = curr.val;
        while(curr.parent != null){
            curr = curr.parent;
            if(curr.val > val) return curr;
        }
        return succ;

    }
    // not using node.value -> check whether the node is on the left of its parent
    public static Node inorder_succ2(Node node){
        Node curr = node;
        Node succ = null;
        if(curr.right != null){
            succ = curr.right;
            while(succ.left != null) succ = succ.left;
            return succ;
        }

         Node prev = null;
        while(curr.parent != null){
            prev = curr;
            curr = curr.parent;
            if(curr.left == prev) return curr;
        }
        return succ;

    }
}

