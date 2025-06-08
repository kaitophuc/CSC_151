package deque;

public class node<E> {
    public E data;
    public node<E> next;
    public node<E> prev;

    public node() {
        this.data = null;
        this.next = null;
        this.prev = null;
    }

    public node(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public String toString() {
        return String.valueOf(data);
    }
}
