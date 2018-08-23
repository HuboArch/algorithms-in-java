package queue.array;

public class Test {
    public static void main(String args[]) {
        CircularQueue<Integer> queue = new CircularQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
