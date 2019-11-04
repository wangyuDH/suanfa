package queue;

import java.util.Stack;

public class StackQueue {

    private Stack<Integer> putStack = new Stack<>();

    private Stack<Integer> takeStack = new Stack<>();

    public boolean enqueue(int data) {
        putStack.push(data);
        return true;
    }


    public Integer dequeue() {
        int size = takeStack.size();
        if(size > 0){
            return takeStack.pop();
        }

        size = putStack.size();
        if(size <= 0){
            return null;
        }

        while (size > 0){
            takeStack.push(putStack.pop());
            size--;
        }
        return takeStack.pop();

    }
}
