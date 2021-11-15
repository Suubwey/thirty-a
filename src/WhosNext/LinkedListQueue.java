package WhosNext;

import java.util.LinkedList;

public class LinkedListQueue implements QueueIntrfc {

    private LinkedList<Object> queueList = new LinkedList<>();

    @Override
    public boolean isEmpty() {
        // calls a similar isEmpty() method
        return queueList.isEmpty();
    }

    @Override
    public void enqueue(Object obj) {
        // enqueue() will add it to the last position in the queue
        queueList.addLast(obj);
    }

    @Override
    public Object dequeue() {
        // dequeue() will remove and return the first item in the queue
        return queueList.removeFirst();
    }

    @Override
    public Object peekFront() {
        // peekFront will only return the first item in the queue
        return queueList.getFirst();
    }
}
