import java.util.*;

public class LRUCache {

    private int capacity;
    private final HashMap<Integer, Node> map;
    private Node head,tail;
    
    class Node{
        int key, value;
        Node prev, next;
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    public void setHead(Node n){
        n.next = head;
        n.prev = null;
        
        if(head!= null) head.prev = n;
        head = n;
        
        if(tail==null) tail = head;
    }
    
    public void remove(Node n){
        if(n.prev != null){
            n.prev.next = n.next;
        }else{
            head = n.next;
        }
        
        if(n.next != null){
            n.next.prev = n.prev;
        }else{
            tail = n.prev;
        }
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node n =map.get(key);
        remove(n);
        setHead(n);
        return n.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node n =map.get(key);
            n.value = value;
            remove(n);
            setHead(n);   
        }else{
            Node node = new Node(key,value);
            if(map.size() >= capacity){
                map.remove(tail.key);
                remove(tail);
                setHead(node);
            }else{
                setHead(node);
            }
            map.put(key,node);
        }   
    }
}
//Time: Lookup O(n)
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */