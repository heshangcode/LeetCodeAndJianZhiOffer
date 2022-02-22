package com.hs.LeetCode02;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * LeetCode622
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/1/21 08:20
 * version: 1.0
 */
public class MyCircularQueue {
    int[] queue;
    int front;
    int capacity;
    int count;

    public MyCircularQueue(int k) {
        queue = new int[k];
        capacity = queue.length;
        front = 0;
        count = 0;
    }


    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        int rear = (front + count) % capacity;
        queue[rear] = value;
        count++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        // 请记住是先进先出，这里出的是队头的数据，所以要+1
        front = (front + 1) % capacity;
        count--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[(front + count - 1) % capacity];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(1);
        myCircularQueue.enQueue(2);
        myCircularQueue.enQueue(3);
        myCircularQueue.enQueue(4);
    }

}
