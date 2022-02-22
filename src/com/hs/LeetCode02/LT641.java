package com.hs.LeetCode02;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.LinkedList;
import java.util.List;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/1/21 07:56
 * version: 1.0
 */
public class LT641 {

    //int[] queue;
    //int count;
    //int front;
    //int capacity;
    //
    //public MyCircularDeque(int k) {
    //    queue = new int[k];
    //    count = 0;
    //    front = 0;
    //    capacity = k;
    //}
    //
    //public boolean insertFront(int value) {
    //    if (isFull()) {
    //        return false;
    //    }
    //    front = (front - 1 + capacity) % capacity;
    //    queue[front] = value;
    //    count++;
    //    return true;
    //
    //}
    //
    //public boolean insertLast(int value) {
    //    if (isFull()) {
    //        return false;
    //    }
    //    queue[(front + count) % capacity] = value;
    //    count++;
    //    return true;
    //}
    //
    //public boolean deleteFront() {
    //    if (isEmpty()) {
    //        return false;
    //    }
    //    front = (front + 1) % capacity;
    //    count--;
    //    return true;
    //}
    //
    //public boolean deleteLast() {
    //    if (isEmpty()) {
    //        return false;
    //    }
    //    count--;
    //    return true;
    //}
    //
    //public int getFront() {
    //    if (isEmpty()) {
    //        return -1;
    //    }
    //    return queue[front];
    //}
    //
    //public int getRear() {
    //    if (isEmpty()) {
    //        return -1;
    //    }
    //    return queue[(front + count - 1) % capacity];
    //}
    //
    //public boolean isEmpty() {
    //    return count == 0;
    //}
    //
    //public boolean isFull() {
    //    return count == capacity;
    //}
}
