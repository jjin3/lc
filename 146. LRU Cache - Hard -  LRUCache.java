public class LRUCache {
    
    // <key, value> in the question could be <url, webpage> 
    // Create a hashtable which saves the key and its node.
    // Create a double-linkedlist 
    // Example: 
    // 1     2     3
    // 3 <== 2 <== 1 
    //   ==>   ==>
    
    // double linked list has head and tail
    // head: head is for the least recently used cache
    // tail: tail is for the most recently used cache 
    
    private class Node {
        int key;
        int val;
        Node pre;
        Node next; 
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.pre = null;
            this.next = null; 
        }
    }

    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    int capacity;
    Node head = null;  // maintains the most recently visted, everytime a node is visited, set this node to head; 
    Node tail = null;  // maintains least recently used item
    
    
    public LRUCache(int capacity) {
        this.capacity = capacity; 
    }
    
     public int get(int key) {
         
         // if key does not exist in the map, no such key at all in the cache.
         if (!map.containsKey(key)) return -1; 
         
         // if key is found, return the node value later. 
         Node node = map.get(key);
         
         // remove this node from linkedlist.
         remove(node);
         add2Head(node);
     
         return node.val; 
    }
    
    public void set(int key, int value){
        
        // create a new node
        Node newNode = new Node(key, value);
        // set key have the following steps
        // if key exists, update the node with a new value
        if (map.containsKey(key)) {
            remove(map.get(key)); // remove old node;
            add2Head(newNode); // add new node
            map.put(key, newNode); // add new pair to hashtable 
        }
        // if key doesn't exist, insert a new node. but before insert, check if it exceeds capacity. Requirement from the original question. 
        else {
            if (map.size() >= this.capacity) {
                // remove the tail from double linkedlist and from hashtable
                int removedKey = tail.key; 
                remove(tail); 
                map.remove(removedKey);
            }
            // add new Node to head; add key node pair to hashtable; 
            add2Head(newNode);
            map.put(key, newNode);
       }
    }

    public void add2Head(Node node){
        
        // if head is null, create a new head;
        if (head == null) {
            node.next = head;
            node.pre = null;
        }
        // if head is not null, add the node to head, let the node becomes the new head; 
        else {
            node.next = head;
            node.pre = null;
            head.pre = node; 
        }
        // set the new head
        head = node; 
        
        // This covers an important case when taill will be potentially removed later. 
        // One node case, otherwise there will be an null pointer exception.
        if (tail == null) tail = head; 
    }
    
    public void remove(Node node) {
        //  one node scenario, remove the single node;
        if (node == head && node == tail) {
            head = null; 
            tail = null; 
        }
        // remove from head
        else if (node == head) {
            head = head.next;
            head.pre = null;
        }
        // remove from tail
        else if (node == tail) {
            tail = tail.pre;
            tail.next = null; 
        }
        // remove from the middle
        else {
            node.pre.next = node.next; 
            node.next.pre = node.pre; 
        }
        
    }
}

