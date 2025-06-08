package deque;

public class deque<E> {
    private node<E> head;
    private node<E> tail;
    
    public deque() {
        this.head = null;
        this.tail = null;
    }

    public void push_back(E data) {
        node<E> newNode = new node<>(data);
        if (tail == null) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void push_front(E data) {
        node<E> newNode = new node<>(data);
        if (head == null) {
            head = tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public E pop_back() {
        if(tail == null) {
            return null;
        }
        E data = tail.data;
        if (tail.prev == null) {
            head = tail = null;
        }
        else {
            tail = tail.prev;
            tail.next = null;
        }
        return data;
    }

    public E pop_front() {
        if(head ==null) {
            return null;
        }
        E data = head.data;
        if (head. next == null) {
            head = tail = null;
        }
        else {
            head = head.next;
            head.prev = null;
        }
        return data;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
