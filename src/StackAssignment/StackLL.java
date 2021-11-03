package StackAssignment;

import java.util.LinkedList;

public class StackLL implements StackIntrfc {

    private LinkedList<Double> stack = new LinkedList<Double>();

    @Override
    public void push(double d) {
        // adding the double to the end of the linkedlist
        stack.add(d);
    }

    @Override
    public double pop() {
        // the removeLast method from the LinkedList class is the same as a pop method that removes and returns the last item
        return stack.removeLast();
    }

    @Override
    public double peek() {
        // just returns the first item in the list with the getFirst method.
        return stack.getFirst();
    }

    @Override
    public int size() {
        // just returns the actual size of the linkedlist
        return stack.size();
    }

    @Override
    public void clear() {
        // just clears the linkedlist
        stack.clear();
    }
}
