package datastructure;

public class Queue {
    private Node head;
    private Node tail;

    public Queue() {
        head = tail = null;
    }

    private Node createNode(int data) {
        return new Node(data);
    }

    public boolean isEmpty() {
        return tail == null ? true : false;
    }

    public void offer(int data) {
        Node node = createNode(data);

        if (isEmpty()) {
            head = tail = node;
        }
        else {
            tail.next = node;
            tail = tail.next;
        }
    }

    public int poll() {
        if (isEmpty()) {
            return -1;
        }
        else {
            int pollData = this.head.data;

            // 원소가 하나일 때
            if (head == tail) {
                head = tail = null;
            }
            else {
                head = head.next;
            }

            return pollData;
        }
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        else {
            return this.head.data;
        }
    }
}
