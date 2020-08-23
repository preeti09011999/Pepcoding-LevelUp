import java.io.*;
import java.util.*;
public class lecture3{
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
        int arr[] = {10, 20, 40, -1, -1, 50, 80, -1, -1, 90, -1, -1, 30, 60, -1, -1, 70, 110, -1, -1, 120, -1, -1};
        Node root = construct(arr);
        // levelOrder_zigzag(root);
        // levelOrder1(root);
        // leftView(root);
        // rightView(root);
        // verticalOrder(root);
        // verticalOrder_sum(root);
        bottom_rigth_preference(root);
    }

    static int idx = 0;
    public static Node construct(int arr[]){
        if(idx == arr.length || arr[idx]==-1){
            idx++;
            return null;
        }
        Node node = new Node(arr[idx++]);
        node.left = construct(arr);
        node.right = construct(arr);
        return node;
    }

    public static void width(Node node,int level, int[] minmax){
        if(node == null) return;
        minmax[0] = Math.min(level,minmax[0]);
        minmax[1] = Math.max(level,minmax[1]);
        
        width(node.left,level-1, minmax);
        width(node.right, level+1, minmax);
        
    }


    //----------------levelOrder 1----------------
    public static void levelOrder1(Node node){
        LinkedList<Node> que = new LinkedList<>();
        que.addLast(node);
        que.addLast(null);
        while(que.size()!=1){
            // remove
            Node ps = que.removeFirst();
            // print
            System.out.print(ps.data+" ");
            // add
            if(ps.left != null) que.addLast(ps.left);
            if(ps.right != null) que.addLast(ps.right);
            if(que.getFirst() == null){
                que.removeFirst();
                System.out.println();
                que.addLast(null);
            }
        }
    }

    public static void levelOrder_zigzag(Node root){
        LinkedList<Node> mainL = new LinkedList<>();
        LinkedList<Node> childL = new LinkedList<>();
        mainL.addLast(root);
        int level = 0;
        while(mainL.size()!=0){
            while(mainL.size()>0){
                Node ps = mainL.removeFirst();
                System.out.print(ps.data+" ");
                if(level%2 == 0){
                    // even level
                    if(ps.left != null) childL.addFirst(ps.left);
                    if(ps.right != null) childL.addFirst(ps.right);
                }else{
                    // odd level
                    if(ps.right != null) childL.addFirst(ps.right);
                    if(ps.left != null) childL.addFirst(ps.left);
                }
            }
            LinkedList<Node> temp = mainL;
            mainL = childL;
            childL = temp;
            level++;
            System.out.println();
        }
    }

    //------------------view set--------------------------------------
    public static void leftView(Node node){
        LinkedList<Node> que = new LinkedList<>();
        que.addLast(node);
        while(que.size()!=0){
            int size = que.size();
            System.out.print(que.getFirst().data+" ");
            while(size-->0){
                Node ps = que.removeFirst();
                if(ps.left != null) que.addLast(ps.left);
                if(ps.right != null) que.addLast(ps.right);
            }
        }
    }

    public static void rightView(Node node){
        LinkedList<Node> que = new LinkedList<>();
        que.addLast(node);
        while(que.size()!=0){
            int size = que.size();
            Node prev = null;
            while(size-->0){
                Node ps = que.removeFirst();
                prev = ps;
                if(ps.left!=null) que.addLast(ps.left);
                if(ps.right!=null) que.addLast(ps.right);
            }
            System.out.print(prev.data+" ");
        }

    }

    //--------------------------vertical Order-----------------------
    public static void verticalOrder(Node node){
        int minmax[] = new int[2];
        width(node,0,minmax);
        ArrayList<Integer>[] a = new ArrayList[minmax[1]-minmax[0]+1];
        for(int i=0;i<a.length;i++) a[i] = new ArrayList<>();
        LinkedList<Pair> que = new LinkedList<>();
        que.addLast(new Pair(node,Math.abs(minmax[0])));
        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                Pair pb = que.removeFirst();
                a[pb.level].add(pb.node.data);
                if(pb.node.left != null) que.addLast(new Pair(pb.node.left, pb.level-1));
                if(pb.node.right != null) que.addLast(new Pair(pb.node.right,pb.level+1));
            }
        }
        for(int i=0;i<a.length;i++) System.out.println(a[i]);
    }

    public static void verticalOrder_sum(Node node){
        int[] minmax = new int[2];
        width(node,0,minmax);
        int a[] = new int[minmax[1]-minmax[0]+1];
        LinkedList<Pair> que = new LinkedList<>();
        que.addLast(new Pair(node, Math.abs(minmax[0])));
        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                Pair pb = que.removeFirst();
                a[pb.level]+=pb.node.data;
                if(pb.node.left != null) que.addLast(new Pair(pb.node.left, pb.level-1));
                if(pb.node.right != null) que.addLast(new Pair(pb.node.right, pb.level+1));
            }
        }
        for(int i=0;i<a.length;i++) System.out.println(a[i]);
    }

    // ----------------bottom-right-preference----------------------------------
    public static void bottom_rigth_preference(Node node){
        int minmax[] = new int[2];
        width(node,0,minmax);
        int a[] = new int[minmax[1]-minmax[0]+1];
        LinkedList<Pair> que = new LinkedList<>();
        que.addLast(new Pair(node,Math.abs(minmax[0])));
        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                Pair pb = que.removeFirst();
                a[pb.level] = pb.node.data;
                if(pb.node.left != null) que.addLast(new Pair(pb.node.left,pb.level-1));
                if(pb.node.right != null) que.addLast(new Pair(pb.node.right,pb.level+1));
            }
        }
        for(int i=0;i<a.length;i++) System.out.println(a[i]);
    }

    // -------------------bottom-left-preference---------------------------
    public static void bottom_left_preference(Node node){
        
    }
}