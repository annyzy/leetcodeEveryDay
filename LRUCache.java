import java.util.*;

public class LRUCache extends LinkedHashMap<Integer, Integer>
{
    private int capacity; //Max capacity
    
    public LRUCache(int capacity) 
    {
        //true for accessOrder, 0.75F for loadFactor
        super(capacity, 0.75F, true);
        //store capacity for use in removeEldestEntry method
        this.capacity = capacity;
    }
    
    public int get(int key) 
    {
        /*
          Returns the value to which the specified key is mapped,
          or -1 if this map contains no mapping for the key.
        */
       return super.getOrDefault(key, -1); 
    }

    @Override
    // remove the node that is least visited
    /*
      This method is invoked by put and putAll after inserting a new entry into the map. 
      It provides the implementor with the opportunity to remove the eldest entry each time a new one is added. 
      This is useful if the map represents a cache: it allows the map to reduce memory consumption by deleting stale entries.
    */
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest)
    {
        //if the number of keys exceeds the capacity from this operation, evict the least recently used key.
        if (size() > capacity){
            return true;
        }else{
            return false;
        }
    }
}