package queue.linked_list;

public class Test {

    public static void main(String args[]) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();

        for (int i = 0; i < 10; i++) {
            System.out.println("=========队尾入队=========");
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                System.out.println("=========队首出队=========");
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
