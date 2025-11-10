package main;

import java.util.NoSuchElementException;

/** Minimal generic FIFO queue (linked list). */
public class Queue<T> {
    private Node head, tail;
    private int size;

    public void enqueue(T item) {
        Node n = new Node(item);
        if (tail == null) { head = tail = n; }
        else { tail.next = n; tail = n; }
        size++;
    }

    public T dequeue() {
        if (head == null) throw new NoSuchElementException();
        T val = head.data;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return val;
    }

    public boolean isEmpty() { return head == null; }
    public int size() { return size; }

    private static final class Node {
        final Object data; Node next;
        Node(Object d) { data = d; }
    }
}
