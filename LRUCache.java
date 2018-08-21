package LeetCode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
//链接：https://www.nowcoder.com/questionTerminal/8006ac33cb964c54bad92ab7b6391fad
//来源：牛客网
//
//总结一下：根据题目的要求，LRU Cache具备的操作：
//
//1）set(key,value)：如果key在hashmap中存在，则先删除链表中对应的节点，再将新的值放到链表末尾；
// 将节点放到链表的头部并更新hashmap
// 当Cache存满的时候，将链表最后一个节点删除即可。
//2）get(key)：如果key在hashmap中存在，则把对应的节点放到链表头部，并返回对应的value值；如果不存在，则返回-1
public class LRUCache {
    int capacity;
    HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
    LinkedList<Integer> list = new LinkedList<Integer>();//链表头部，插入链表头部。
    int count = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (hashmap.containsKey(key)) {
            int res = hashmap.get(key);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if ((Integer) (it.next()) == key) {
                    it.remove();
                    break;
                }
            }
            list.addFirst(key);
            return res;
        } else return -1;
    }

    public void put(int key, int value) {
        if (count == 0) {
            list.addFirst(key);
            hashmap.put(key, value);
            count++;
            return;
        }
        count++;
        if (hashmap.containsKey(key)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if ((Integer) (it.next()) == key) {
                    it.remove();
                    break;
                }
            }
            count--;
        }
        list.addFirst(key);
        hashmap.put(key, value);
        if (count > capacity) {
            int last = list.pollLast();
            hashmap.remove(last);
            count--;
        }

    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        LinkedList list = new LinkedList();
        obj.put(2, 1);
        obj.put(1, 1);
        obj.put(2, 3);
        obj.put(4, 1);
        list.add(obj.get(1));
        list.add(obj.get(2));
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");

    }
}
