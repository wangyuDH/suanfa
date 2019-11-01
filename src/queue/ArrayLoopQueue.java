package queue;

public class ArrayLoopQueue {

    private int a[];

    private int count;

    private int head = 0;

    private int tail = 0;

    public ArrayLoopQueue(int capacity) {
        a = new int[capacity];
        count = capacity;
    }

    /**
     * 入队
     */
    public boolean enqueue(int data) {
        if ((head + 1) % count == tail) {
            System.out.println("队列已满");
            return false;
        }

        a[head] = data;
        head = (head + 1) % count;

        return true;
    }

    /**
     * 出队
     */
    public int dequeue() {
        if (tail == head) {
            System.out.println("队列为空");
            return -1;
        }

        int data = a[tail];
        tail = (tail + 1) % count;

        return data;
    }
}
