package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/implement-stack-using-queues/">225. 用队列实现栈</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_225 {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // 返回 2
        System.out.println(myStack.pop()); // 返回 2
        System.out.println(myStack.empty()); // 返回 False

        MyStack2 myStack2 = new MyStack2();
        myStack2.push(1);
        myStack2.push(2);
        System.out.println(myStack2.top()); // 返回 2
        System.out.println(myStack2.pop()); // 返回 2
        System.out.println(myStack2.empty()); // 返回 False
    }
}

/**
 * 方法1：使用两个队列
 */
class MyStack {

    /** 存储栈内元素 */
    private Queue<Integer> queue1;
    /** 辅助队列 */
    private Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        // 尾插
        queue2.add(x);

        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        // 头出
        return queue1.poll();
    }

    public int top() {
        // 头出
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * 方法2：使用1个队列
 */
class MyStack2 {

    /** 存储栈内元素 */
    private final Queue<Integer> queue;

    public MyStack2() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        // 尾插
        int loopTime = queue.size();
        queue.add(x);
        for (int i = 0; i < loopTime; i++) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        // 头出 & 删除
        return queue.poll();
    }

    public int top() {
        // 头出
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}