import java.util.LinkedList;

interface Queue {
    public void enqueue(int value);
    public int element();
    public int dequeue();
    public int size();
    public boolean isEmpty();
    public void clear();
}

class LinkedQueue implements Queue{
    private LinkedList<Integer> linked = new LinkedList<Integer>();
    private int size=0;

    public void enqueue(int value) {
        size++;
        linked.addLast(value);
    }

    public int element() {
    return linked.getFirst();
    }

    public int dequeue() {
        int value = linked.removeFirst();
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) return true;
        else return false;
    }

    public void clear() {
        linked.clear();
        size = 0;
    }
}

abstract class AbstractQueue {
    private int size=0;

    public abstract int size();
    public abstract boolean isEmpty();
}

public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("Linked Queue\n");
        LinkedQueue queue = new LinkedQueue();
        for (int i=0;i<5;i++) {
            queue.enqueue(i+10);
        }
        System.out.print("The first element is "+queue.element()+". Size of queue is "+queue.size()+"\nNow delete "+queue.dequeue()+" and "+queue.dequeue()+". Now size is "+queue.size());
        queue.clear();
        System.out.print("\nNow let's delete all elements. The size is "+queue.size());
    }
}
