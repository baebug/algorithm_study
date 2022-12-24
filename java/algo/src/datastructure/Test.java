package datastructure;

public class Test {
    public static void main(String[] args) {
        System.out.println("--- test Stack start ---");
        testStack();
        System.out.println("--- test Stack end ---");
        System.out.println("--- test Queue start ---");
        testQueue();
        System.out.println("--- test Queue end ---");

    }

    static void testStack() {
        Stack stack = new Stack();

        System.out.println("isEmpty? : " + stack.isEmpty());

        System.out.println("push data : 1");
        stack.push(1);
        System.out.println("push data : 2");
        stack.push(2);
        System.out.println("push data : 3");
        stack.push(3);

        System.out.println("peek : " + stack.peek());

        System.out.println("pop data : " + stack.pop());

        System.out.println("peek : " + stack.peek());
        System.out.println("isEmpty? : " + stack.isEmpty());

        System.out.println("pop data : " + stack.pop());
        System.out.println("pop data : " + stack.pop());
        System.out.println("isEmpty? : " + stack.isEmpty());

    }

    static void testQueue() {
        Queue queue = new Queue();

        System.out.println("isEmpty? : " + queue.isEmpty());

        System.out.println("offer data : 1");
        queue.offer(1);
        System.out.println("offer data : 2");
        queue.offer(2);
        System.out.println("offer data : 3");
        queue.offer(3);

        System.out.println("peek : " + queue.peek());

        System.out.println("poll data : " + queue.poll());

        System.out.println("peek : " + queue.peek());
        System.out.println("isEmpty? : " + queue.isEmpty());

        System.out.println("poll data : " + queue.poll());
        System.out.println("poll data : " + queue.poll());
        System.out.println("isEmpty? : " + queue.isEmpty());
    }

}
