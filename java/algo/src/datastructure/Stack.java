package datastructure;

public class Stack {
    private Node head;
    private Node top;

    public Stack() {
        head = top = null;
    }

    private Node createNode(int data) {
        return new Node(data);
    }

    public boolean isEmpty() {
        return top == null ? true : false;
    }

    public void push(int data) {
        Node node = createNode(data);

        if (isEmpty()) {
            head = top = node;
        }
        else {
            top.next = node;
            top = top.next;
        }
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        else {
            int popData = top.data;

            Node pointer = this.head;

            // 원소가 1개 일 때
            if (pointer == top) {
                head = top = null;
            }
            else {
                // pointer 의 next 가 top 일 때 stop
                while(pointer.next != top) {
                    pointer = pointer.next;
                }

                pointer.next = null;
                top = pointer;
            }

            return popData;
        }
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        else {
            return this.top.data;
        }
    }
}
