import java.util.*;

class LRUCache {
    private int capacity;
    private Map<Integer, ListNode> cache;
    private LinkedList<ListNode> list;

    class ListNode {
        int key;
        int value;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.list = new LinkedList<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        ListNode node = cache.get(key);
        list.remove(node);
        list.addLast(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            ListNode node = cache.get(key);
            list.remove(node);
        } else if (cache.size() == capacity) {
            ListNode lruNode = list.removeFirst();
            cache.remove(lruNode.key);
        }
        ListNode newNode = new ListNode(key, value);
        list.addLast(newNode);
        cache.put(key, newNode);
    }
}
