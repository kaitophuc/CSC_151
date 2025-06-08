package linked_list;

public class node <E> {
    public E data;
    public node <E> next;

    public node() {
        this.data = null;
        this.next = null;
    }

    public node(E data) {
        this.data = data;
        this.next = null;
    }
    
    public String toString() {
        return String.valueOf(data);
    }
}
