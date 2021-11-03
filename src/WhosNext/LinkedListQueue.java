package WhosNext;

import java.util.LinkedList;

public class LinkedListQueue implements Queue {

    private LinkedList<Object> queueList = new LinkedList<>();

    @Override
    public boolean isEmpty() {
        return queueList.isEmpty();
    }

    @Override
    public void enqueue(Object obj) {
        queueList.addLast(obj);
    }

    @Override
    public Object dequeue() {
        return queueList.removeFirst();
    }

    @Override
    public Object peekFront() {
        return queueList.getFirst();
    }
}
