if(root == null) return null;
        bTreeToClist(root.left);
        if(head == null) head = root;
        else{
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        bTreeToClist(root.right);
