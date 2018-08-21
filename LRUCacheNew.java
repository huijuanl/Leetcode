package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;

//链接：https://www.nowcoder.com/questionTerminal/8006ac33cb964c54bad92ab7b6391fad
//来源：牛客网
//
//总结一下：根据题目的要求，LRU Cache具备的操作：
//
//1）set(key,value)：如果key在hashmap中存在，则先删除链表中对应的节点，再将新的值放到链表末尾；(hashmap中的value表示key在链表中的位置指针)
// 将节点放到链表的头部并更新hashmap
// 当Cache存满的时候，将链表最后一个节点删除即可。
//2）get(key)：如果key在hashmap中存在，则把对应的节点放到链表头部，并返回对应的value值；如果不存在，则返回-1
public class LRUCacheNew {
    private class Node {
        public int key;
        public int val;
        public Node pre;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.pre = null;
            this.next = null;
        }
    }

    int capacity;
    HashMap<Integer, Node> hashmap = new HashMap<Integer, Node>();
    Node head = null;
    Node tail = null;
    int count = 0;

    public LRUCacheNew(int capacity) {
        this.capacity = capacity;
    }

    public void addNode(Node cur) {//将节点插入链表尾部
        if (head == null) {
            head = cur;
            tail = cur;
        } else {
            cur.pre = tail;
            tail.next = cur;
            tail = tail.next;
        }
    }

    public void removeNode(Node cur) {//删除可能是在任意一个位置
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        if (head == cur) {
            head = cur.next;
            head.pre = null;
            return;
        }
        if (tail == cur) {
            tail = tail.pre;
            tail.next = null;
            return;
        }
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
    }

    public int get(int key) {
        if (hashmap.containsKey(key)) {
            Node res = hashmap.get(key);
            removeNode(res);
            Node cur = new Node(key,res.val);
            addNode(cur);
            hashmap.put(key,cur);
            return cur.val;
        } else return -1;
    }

    public void put(int key, int value) {
        Node cur = new Node(key, value);
        if (count == 0) {
            addNode(cur);
            hashmap.put(key, cur);
            count++;
            return;
        }
        count++;
        if (hashmap.containsKey(key)) {
            removeNode(hashmap.get(key));
            count--;
        }
        addNode(cur);
        hashmap.put(key, cur);
        if (count > capacity) {
            hashmap.remove(head.key);
            removeNode(head);
            count--;
        }

    }

    public static void main(String[] args) {
        LRUCacheNew obj = new LRUCacheNew(2);
        LinkedList list = new LinkedList();
        obj.put(2, 1);
        obj.put(3, 2);
        list.add(obj.get(3));
        list.add(obj.get(2));
        obj.put(4, 3);
        list.add(obj.get(2));
        list.add(obj.get(3));
        list.add(obj.get(4));
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");

    }
}
