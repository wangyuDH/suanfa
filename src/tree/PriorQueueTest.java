package tree;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * 优先级队列
 */
public class PriorQueueTest {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.add(2);
        priorityQueue.add(1);
        priorityQueue.add(4);
        priorityQueue.add(5);

        Iterator iterator = priorityQueue.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
