package DLL_HashMap;


import java.util.HashMap;
import java.util.Map;

class Node {
    int key, value;
    Node prev, next;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRU_Caching {

    public static int capacity;
    public static Map<Integer, Node> map;
    public static Node head;
    public static Node tail;

    LRU_Caching(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    static void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    static void insertAtFront(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    static int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        insertAtFront(node);
        return node.value;
    }

    static void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertAtFront(node);
        } else {
            if(map.size() == capacity) {
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            insertAtFront(newNode);
            map.put(key, newNode);
        }

    }

    public static void main(String[] args) {
        LRU_Caching cache = new LRU_Caching(2);

        put(1, 1);
        put(2, 2);

        System.out.println(get(1));

        put(3, 3);
        System.out.println(get(2));

        put(4, 4);
        System.out.println(get(1));
        System.out.println(get(3));
        System.out.println(get(4));
    }

}
