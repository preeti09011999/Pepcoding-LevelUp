import java.io.*;
import java.util.*;
public class lecture2{
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static void main(String args[]){
        int arr[] = {50, 25, 12, -1, -1, 37, 30, -1, -1, -1, 75, 62, -1, 70, -1, -1, 87, -1, -1};
        Node root = construct(arr);
        int k = 3;
        kLevelsDown(root,k);
        int[] minmax = new int[2];
        width(root,0,minmax);
        System.out.println(minmax[1]-minmax[0]+1);
    }
    static int idx = 0;
    public static Node construct(int[] arr){
        if(arr[idx] == arr.length || arr[idx] == -1){
            idx++;
            return null;
        }
        Node node = new Node(arr[idx++]);
        node.left = construct(arr);
        node.right = construct(arr);
        return node;
    }
// --------------------------KLevelsDown-------------------------------
    public static void kLevelsDown(Node node,int k){
        if(k==0 && node!=null){
            System.out.println(node.data);
            return;
        }
        if(node == null) return;
        kLevelsDown(node.left,k-1);
        kLevelsDown(node.right,k-1);
    }

//----------------------------width of a tree-----------------------------
    public static void width(Node node,int level,int[] minmax){
        if(node == null) return;
        minmax[0] = Math.min(minmax[0],level);
        minmax[1] = Math.max(minmax[1],level);
        width(node.left,level-1,minmax);
        width(node.right,level+1,minmax);
    }

// ---------------------LCA -----------------------------------------------
    public Node lcaNode = null;
    public static boolean lca(Node node, int p, int q){
        if(node == null) return false;
        boolean selfdone = false;
        if(node.data == p || node.data == q) selfdone = true;
        boolean leftdone = lca(node.left, p , q);
        if(lcaNode != null) return true;
        boolean rightdone = lca(node.right, p , q);
        if((leftdone && rightdone) || (selfdone && leftdone) || (selfdone && rightdone)) lcaNode = node;
        return leftdone || rightdone || selfdone;
    }

// ------------------Burning tree--------------------------------------------
    public static int burning_tree(Node node,int data, ArrayList<ArrayList<Integer>> ans){
        if(node == null) return -1;
        if(node.data == data){
            burning_node(node, 0, ans);
            return 1;
        }

        int ld = burning_tree(node.left,data,ans);
        if(ld != -1){
            if(ld == ans.size()) ans.add(new ArrayList<>());
            ans.get(ld).add(node.data);
            burning_node(node.right,ld+1,ans);
            return ld+1;
        }
        int rd = burning_tree(node.right,data,ans);
        if(rd != -1){
            if(rd == ans.size()) ans.add(new ArrayList<>());
            ans.get(rd).add(node.data);
            burning_node(node.left,rd+1,ans);
            return rd+1;
        }
        return -1;
    }

    public static void burning_node(Node node, int time, ArrayList<ArrayList<Integer>> ans){
        if(node == null) return;
        if(time == ans.size()) ans.add(new ArrayList<>());
        ans.get(ld).add(node.data);
        burning_node(node.left, time+1,ans);
        burning_node(node.right,time+1,ans); 
    }
}