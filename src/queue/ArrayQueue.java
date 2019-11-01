package queue;

public class ArrayQueue {

    private int a[];

    private int count;

    private int head = 0;

    private int tail = 0;

    public ArrayQueue(int capacity) {
        a = new int[capacity];
        count = capacity;
    }

    /**
     * 入队
     */
    public boolean enqueue(int data) {
        if (head == count) {
            if (tail == 0) {
                System.out.println("队列已满");
                return false;
            } else {
                //搬运数据
                for (int i = 0; i < head - tail; i++) {
                    a[i] = a[tail + i];
                }
                head = head - tail;
                tail = 0;
            }
        }

        a[head] = data;
        head++;

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
        tail++;

        return data;
    }
}
