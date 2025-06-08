package linked_list;

public class linked_list<E> {
    private node<E> head;
    private int size;

    public linked_list() {
        this.head = null;
    }

    public void insert(E data) {
        node<E> newNode = new node <>(data);
        if (head == null) head = newNode;
        else {
            newNode.next = head;
            head = newNode;
        }
        ++size;
    }

    public node<E> search(E data) {
        node<E> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return current;
            }
            else { 
                current = current.next;
            }
        }
        return null;
    }

    public void delete(E data) {
        if (head == null) return;
        if (head.data.equals(data)) {
            head = head.next;
            --size;
            return;
        }
        node<E> current = head;
        while(current.next != null) {
            if(current.next.data.equals(data)) {
                current.next = current.next.next;
                --size;
                return;
            }
            current = current.next;
        }
    }

}