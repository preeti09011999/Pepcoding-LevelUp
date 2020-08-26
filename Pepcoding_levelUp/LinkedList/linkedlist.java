public class linkedlist {
    public class Node{
        int data = 0;
        Node next = null;
        Node(int data){
            this.data = data;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;
    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    // getfirst ----------------------------
    public int getFirst() throws Exception{
        if(this.size == 0){
            throw new Exception("EmptyList");
        }
        return this.head.data;
    }
    // getlast ----------------------------
    public int getLast() throws Exception{
        if(this.size == 0){
            throw new Exception("EmptyList");
        }
        return this.tail.data;
    }
    // add first-------------------------------
    public void addFirst(int data){
        Node node = new Node(data);
        addFirstNode(node);
    }

    private void addFirstNode(Node node) {
        if(this.size == 0){
            this.head = node;
            this.tail = node;
        }else{
            node.next = this.head;
            this.head = node;
        }
        this.size++;
    }

    // add Last-------------------------------
    public void addLast(int data){
        Node node = new Node(data);
        addLastNode(node);
    }

    private void addLastNode(Node node) {
        if(this.size == 0){
            this.head = node;
            this.tail = node;
        }else{
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
    }

    // add at idx-----------------------------
    public void addAt(int idx, int data) throws Exception{
        if(idx < 0 || idx > this.size){
            throw new Exception("Null Pointer");
        }
        Node node = new Node(data);
        addNodeAt(idx, node);
    }

    private void addNodeAt(int idx, Node node){
        if(idx == 0) addFirstNode(node);
        else if(idx == this.size-1) addLastNode(node);
        else{
            Node prev = getNodeAt(idx-1);
            Node forw = prev.next;
            prev.next = node;
            node.next = forw;
            this.size++;
        }
    }

    // getnode at ------------------------------
    public Node getNode(int idx) throws Exception{
        if(idx < 0 || idx > this.size){
            throw new Exception("NullPointer");
        }
        Node node = getNodeAt(idx);
        return node;
    }

    private Node getNodeAt(int idx){
        Node node = this.head;
        while(idx-->0){
            node = node.next;
        }
        return node;
    }

    //removeFirst ----------------------------
    public int removeFirst() throws Exception{
        if(this.size == 0){
            throw new Exception("EmptyList");
        }
        Node rnode = removeFirstNode();
        return rnode.data;
    }

    private Node removeFirstNode(){
        Node rnode = this.head;
        if(this.size == 1){
            this.head = null;
            this.tail = null;
        }
        else{
            this.head = this.head.next;
        }
        rnode.next = null;
        this.size--;
        return rnode;
    }

    // removelast------------------------------------
    public int removeLast() throws Exception{
        if(this.size == 0){
            throw new Exception("NullPointer");
        }
        Node rnode = removeLastNode();
        return rnode.data;
    }

    private Node removeLastNode(){
        Node rnode = this.tail;
        if(this.size == 1){
            this.head = null;
            this.tail = null;
        }
        else if(this.size == 2){
            this.tail = this.head;
        }
        else{
            Node SecondLast = getNodeAt(this.size - 2);
            SecondLast.next = null;
            this.tail = SecondLast;
        }
        this.size--;
        return rnode;
    }

    // remove node At----------------------------------
    public int removeAt(int idx) throws Exception{
        if(idx < 0 || idx > this.size){
            throw new Exception("NullPointer");
        }
        Node rnode = removeNodeAt(idx);
        return rnode.data;
    }

    private Node removeNodeAt(int idx){
        if(idx == 0){
            return removeFirstNode();
        }
        else if(idx == this.size - 1){
            return removeLastNode();
        }else{
            Node prev = getNodeAt( idx - 1);
            Node rnode = prev.next;
            prev.next = rnode.next;
            rnode.next = null;
            this.size--;
            return rnode;
        }
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node node = this.head;
        while(node != null){
            sb.append(node.data);
            if(node.next != null) sb.append(", ");
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }

}