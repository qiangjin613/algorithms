package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/implement-queue-using-stacks/description/">232. 用栈实现队列</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_232 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.push(3); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.push(4); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.pop()); // return 1
        myQueue.push(5);
        System.out.println(myQueue.pop()); // return 2
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.empty()); // return false
    }
}

/**
 * 方式1：利用辅助栈，对栈内元素进行颠倒，push 时间复杂度 O(n)
 */
class MyQueue {

    private final Deque<Integer> stack;
    private final Deque<Integer> stack2;

    public MyQueue() {
        stack = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void push(int x) {
        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }

        stack2.push(x);

        while (!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * 方式2：pop 和 peek 为均摊 O(1)。对于每个元素，至多入栈和出栈各两次，故均摊复杂度为 O(1)。
 */
class MyQueue2 {

    private final Deque<Integer> inStack;
    private final Deque<Integer> outStack;

    public MyQueue2() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            fillOutStack();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            fillOutStack();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void fillOutStack() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
