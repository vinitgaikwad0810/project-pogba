package _146;

import java.util.*;

public class LRUCache {


    private class Node {

        private int key;
        private int value;
        private int timeStamp;

        private Node(int key, int value, int timeStamp) {
            this.key = key;
            this.value = value;
            this.timeStamp = timeStamp;
        }
    }

    private int time, capacity;
    private PriorityQueue<Node> queue;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        time = 0;
        this.capacity = capacity;
        queue = new PriorityQueue<>(capacity, (Node n1, Node n2) -> n1.timeStamp - n2.timeStamp);
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            queue.remove(node);
            map.get(key).timeStamp = ++time;
            queue.add(node);
            return map.get(key).value;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        Node node = new Node(key, value, ++time);
        if (!map.containsKey(key)) {
            map.put(key, node);
            if (queue.size() < capacity) {
                queue.add(node);
            } else {
                Node temp = queue.poll();
                map.remove(new Integer(temp.key));
                queue.add(node);
            }
        } else {
            queue.remove(map.get(key));
            map.put(key, node);
            queue.add(node);
        }
    }
}