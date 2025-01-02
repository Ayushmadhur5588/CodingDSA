public class ll{
    private class Node{
        int data = 0;
        Node next = null;

        Node(int data){
            this.data = data;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int size(){
        return this.size;
    }

    //Exceptions
    private void emptyException() throws Exception{
        if(this.size == 0){
            throw new Exception("Empty LinkedList");
        }

    }

    private void IndexOutOfBoundSizeExclusiveException(int idx) throws Exception {
        if (idx < 0 || idx >= this.size)
            throw new Exception("Index Out Of Bound : -1");
    }

    private void IndexOutOfBoundSizeInclusiveException(int idx) throws Exception {
        if (idx < 0 || idx > this.size)
            throw new Exception("Index Out Of Bound : -1");
    }

    //get

    public int getFirst(){
        emptyException();
        return this.head.data;

    }

    public int getLast(){
        emptyException();
        return this.tail.data;
    }

    private Node getNodeAt(int idx){
        
        Node curr = head;
        while(idx-- > 0){
         curr = curr.next;
        }
        return curr;
    }

    public int getAt(int idx) throws Exception{
        IndexOutOfBoundSizeExclusiveException(idx);
        Node node = getNodeAt(idx);
        return node.data;
    }


    //add

    private void addFirstNode(Node node){
        if(this.size == 0){
            this.head = node;
            this.tail = node;
        }else{
            node.next = head;
            this.head = node;
        }
       this.size++;
 
    }
    
    public void addFirst(int data){
        Node node = new Node(data);
        addFirstNode(node);
    }

    private void addLastNode(Node node){
        if(this.head == null){
            this.head = node;
            this.tail = node;
        }else{
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
    }
    
    public void addLast(int data){
        Node node = new Node(data);
        addLastNode(node);
    }

    private void addAtNode(int idx, Node node){
        if(idx == 0){
            addFirstNode(node);
        }else if(idx  == this.size){
            addLastNode(node);
        }else{
          Node prev = getNodeAt(idx - 1);
          Node forw = prev.next;

          prev.next = node;
          node.next = forw;

          this.size++;
        }

    }
   
    public void addAt(int idx, int data) throws Exception{
        IndexOutOfBoundSizeInclusiveException(idx);
        Node node = new Node(data);
        addAtNode(idx, node);
    }



    //remove 

    

}