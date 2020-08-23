import java.io.*;
import java.util.*;
public class serialize_tree{
    public static class Node{
        int data = 0;
        Node left = null;
        Node right = null;
        Node(int data){
            this.data = data;
        }
    }
    public static void main(String[] args){
        int arr[] = {10,20,40,-1,-1,50,80,-1,-1,90,-1,-1,30,60,100,-1,-1,-1,70,110,-1,-1,120,-1,-1};
        Node root = construct(arr);
        display(root);
        System.out.println("size -> "+size(root));
        System.out.println("max -> "+max(root));
        System.out.println("min -> "+min(root));
        System.out.println("height -> "+height(root));
    }
    static int idx = 0;
    public static Node construct(int[] arr){
        if(arr[idx] == -1 || idx == arr.length){
            idx++;
            return null;
        } 
            
        Node node = new Node(arr[idx++]);
        node.left = construct(arr);
        node.right = construct(arr);
        return node;
    }

    public static void display(Node node){
        if(node == null) return;
        String str = "";
        str += (node.left == null) ? "." : node.left.data+"";
        str += "-> "+node.data+" <-";
        str += (node.right == null) ? "." : node.right.data+"";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }

    public static int size(Node node){
        return node == null ? 0 : size(node.left)+size(node.right)+1;
    }

    public static int height(Node node){
        return node == null ? -1 : Math.max(height(node.left),height(node.right))+1;
    } 

    public static int max(Node node){
        return node == null ? Integer.MIN_VALUE : Math.max(node.data,Math.max(max(node.left),max(node.right)));
    }

    public static int min(Node node){
        return node == null ? Integer.MAX_VALUE : Math.min(node.data,Math.min(min(node.left),min(node.right)));
    }
}