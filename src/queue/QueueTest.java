package queue;

public class QueueTest {

    public static void main(String[] args) {
        //普通队列-数组
        arrayQueueTest();
        System.out.println("===================================");
        //循环队列-数组
        loopQueueTest();
    }

    private static void loopQueueTest() {
        ArrayLoopQueue arrayQueue = new ArrayLoopQueue(5);

        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        arrayQueue.enqueue(4);
        arrayQueue.enqueue(5);

        System.out.println(arrayQueue.dequeue());


    }

    private static void arrayQueueTest() {
        ArrayQueue arrayQueue = new ArrayQueue(5);

        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        arrayQueue.enqueue(4);
        arrayQueue.enqueue(5);

        System.out.println(arrayQueue.dequeue());

        arrayQueue.enqueue(6);
        System.out.println(arrayQueue.dequeue());

    }
}
