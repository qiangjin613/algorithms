package leetcode;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/design-hashset/">705. 设计哈希集合</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_705 {
    public static void main(String[] args) {

    }

}

class MyHashSet {

    private final boolean[] data;

    public MyHashSet() {
        data = new boolean[1_000_001];
    }

    public void add(int key) {
        data[key] = true;
    }

    public void remove(int key) {
        data[key] = false;
    }

    public boolean contains(int key) {
        return data[key];
    }
}

class MyHashSet2 {

    private static final int BASE = 769;
    private final LinkedList<Integer>[] data;

    public MyHashSet2() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<>();
        }
    }

    public void add(int key) {
        int h = hash(key);
        for (Integer element : data[h]) {
            if (element == key) {
                return;
            }
        }
        data[h].offerLast(key);
    }

    public void remove(int key) {
        int h = hash(key);
        for (Integer element : data[h]) {
            if (element == key) {
                data[h].remove(element);
                return;
            }
        }
    }

    public boolean contains(int key) {
        int h = hash(key);
        for (Integer element : data[h]) {
            if (element == key) {
                return true;
            }
        }
        return false;
    }

    private static int hash(int key) {
        return key % BASE;
    }
}
