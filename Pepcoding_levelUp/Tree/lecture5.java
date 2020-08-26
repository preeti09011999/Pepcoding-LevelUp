import java.io.*;
import java.util.*;
public class lecture5{
    public static class Node{
        int data = 0;
        ArrayList<Node> child = new ArrayList<>();
        Node(int data){
            this.data = data;
        }
    }
    public static void main(String[] args) {
        int arr[] = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 100, -1, 110, -1, -1, 90, -1, -1, 40, 120, 140, -1, 150, -1, -1, -1,-1};
        Node root = constructGT(arr);
        System.out.println("Height -> "+ height(root));
        System.out.println("Max -> " + max(root));
        System.out.println("Min -> "+ min(root));
        System.out.println(" size -> "+ size(root));
        int data = 110;
        System.out.println("find -> " + find(root, data));
        System.out.println("LCA -> " + lca(root, 70, 120));

        display(root);

    }

    public static Node constructGT(int[] arr) {
        Stack<Node> st = new Stack<>();
        for(int i=0;i<arr.length-1;i++){
            if(arr[i] != -1){
                st.push(new Node(arr[i]));
            }else{
                Node node = st.pop();
                st.peek().child.add(node);
            }
        }
        return st.peek();
    }

    public static int height(Node node) {
        int ht = -1;
        for(Node children : node.child){
            ht = Math.max(ht, height(children));
        }
        return ht + 1;
    }

    public static int size(Node node) {
        int size = 1;
        for(Node children : node.child){
            size += size(children);
        }
        return size;
    }

    public static int max(Node node) {
        int max = Integer.MIN_VALUE;
        for(Node children : node.child){
            max = Math.max(max, max(children));
        }
        max = Math.max(max, node.data);
        return max;
    }

    public static int min(Node node) {
        int min = Integer.MAX_VALUE;
        for(Node children : node.child){
            min = Math.max(min, min(children));
        }
        min = Math.min(min, node.data);
        return min;
    }

    public static void display(Node node) {
        String str = ""+node.data+" -> ";
        for(Node children : node.child){
            str += children.data+" ";
        }
        System.out.println(str);
        for(Node children : node.child) display(children);  
    }

    public static boolean find(Node node, int data) {
        if(node.data == data) return true;
        for(Node children : node.child) if(find(children, data)) return true;
        return false;
    }

// -------------find lowest common ancestor ---------------------------------------------

    public static int lca(Node node, int data1, int data2) {
        ArrayList<Integer> path1 = nodeToRootPath(node, data1);
        ArrayList<Integer> path2 = nodeToRootPath(node, data2);
        int i = path1.size()-1;
        int j = path2.size()-1;
        while(i>=0 && j>=0 && path1.get(i)==path2.get(j)){
            i--;
            j--;
        }
        return path1.get(i+1);
    }
// -----------print generic tree in levelwise zig zag --------------------------------------
    public static void zig_zag(Node node) {
        Stack<Node> mainS = new Stack<>();
        mainS.add(node);
        Stack<Node> childS = new Stack<>();
        int level = 0;
        while(mainS.size() != 0){
            Node bs = mainS.pop();
            System.out.print(bs.data + " ");
            if(level % 2 == 0){
                for(Node children : node.child){
                    childS.push(children);
                }
            }else{
                for(int i=node.child.size()-1;i>=0;i--){
                    Node children = node.child.get(i);
                    childS.push(children);
                }
            }
            if(mainS.size()==0){
                mainS = childS;
                childS = new Stack<>();
                System.out.println();
                level++;
            }
        }
    }

// ------------------ check if mirror/symmetric -------------------------------
 
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

// ----------------Node to Root path --------------------------------------
    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        if(node.data == data){
            ArrayList<Integer> path = new ArrayList<>();
            path.add(node.data);
            return path;
        }

        for(Node children : node.child){
            ArrayList<Integer> res = nodeToRootPath(children);
            if(res.size()>0){
                res.add(node.data);
                return res;
            }
        }
        return new ArrayList<>();
    }
// lca using boolean method ---------------------------------------------
    public boolean lowestCommonAncestor_(Node root, Node p, Node q){
        if(root == null) return false;
        boolean selfdone = false;
        if(root == p || root == q) selfdone = true;
        boolean child_done = false;
        for(Node children : node.child){
            lowestCommonAncestor_()
        }
        boolean leftdone = lowestCommonAncestor_(root.left, p, q);
        if(LCANode != null) return true;
        boolean rightdone = lowestCommonAncestor_(root.right, p, q);
        if((leftdone && selfdone)||(rightdone && selfdone)||(leftdone && rightdone)) LCANode = root;
        return leftdone || rightdone || selfdone;
    }

    // linearize ------------------------------------------------------
    public static Node linearize(Node node) {
        if(node.children.size() == 0) return node;
        int n = node.child.size();
        Node oTail = linearize(node.child.get(n-1));
        for(int i=n-2;i>=0;i--){
            Node tail = linearize(node.child.get(i));
            tail.child.add(node.child.get(i+1));
            node.child.remove(node.child.size()-1);
        }
        return oTail;
    }

    // doubly linkedlist containing all the leaf node of tree
    public static Node dll(Node node) {
        
    }
}