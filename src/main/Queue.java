package main;

public class Queue<T> {
    private ListRecord head;
    private ListRecord tail;
    private int length;

    public Queue() {
        head = null;
        tail = null;
        length = 0;
    }

    public void enqueue( T obj ) {
        if( obj != null ) {
            ListRecord newRecord = new ListRecord(obj);
            if (head == null) {
                head = newRecord;
                tail = newRecord;
            } else {
                tail.next = newRecord;
                tail = newRecord;
            }

            length++;
        }
    }

    public T dequeue() {
        if( isEmpty() )  {
            return null;
        } else {
            ListRecord tmp = head;
            head = head.next;
            tmp.next = null;

            if (isEmpty()) {
                tail = null;
            }

            length--;

            return tmp.data;
        }
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return head == null;
    }

    private class ListRecord {
        public T data;
        public ListRecord next;

        public ListRecord ( T obj ) {
            data = obj;
        }
    }

}
