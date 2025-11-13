package main;

public class Stack<T> {

    private StackItem stack;

    public Stack() {
        stack = null;
    }

    public void empty() {
        while( pop() != null ) {
        }
    }

    public T pop() {
        T obj = null;
        if( stack != null ) {
            obj = stack.data;
            if( stack.before != null ) {
                stack = stack.before;
            } else {
                stack = null;
            }
        }

        return obj;
    }

    public boolean hasNext() {
        return stack == null;
    }

    public void push( T element ) {
        if( stack == null ) {
            stack = new StackItem( element );
        } else  {
            StackItem newItem = new StackItem( element );
            newItem.before = stack;
            stack = newItem;
        }
    }

    private class StackItem {
        public StackItem before;
        public T data;

        public StackItem( T element ) {
            data = element;
            before = null;
        }

    }

}