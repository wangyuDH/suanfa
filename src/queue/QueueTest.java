package queue;

public class QueueTest {

    public static void main(String[] args) {
        //普通队列-数组
        arrayQueueTest();
        System.out.println("================普通队列===================");

        //循环队列-数组
        loopQueueTest();
        System.out.println("================循环队列===================");

        //栈队列
        stackQueueTest();
        System.out.println("================栈队列===================");
    }

    private static void stackQueueTest() {
        StackQueue stackQueue = new StackQueue();
        stackQueue.enqueue(1);
        stackQueue.enqueue(2);
        stackQueue.enqueue(3);
        System.out.println(stackQueue.dequeue());
        System.out.println(stackQueue.dequeue());
        stackQueue.enqueue(3);
        System.out.println(stackQueue.dequeue());
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
