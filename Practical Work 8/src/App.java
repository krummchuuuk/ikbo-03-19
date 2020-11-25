import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

interface IWaitList<E> {
    void add(E element);
    E remove();
    boolean contains(E element);
    boolean containsAll(Collection<E> c);
    boolean isEmpty();
}

class WaitList<E> implements IWaitList<E> {
    protected ConcurrentLinkedQueue<E> content;

    public WaitList() {
        content = new ConcurrentLinkedQueue<>();
    }
    public WaitList(Collection<E> c) {
        content = c;
    }
    public void add(E element) {
        content.add(element);
    }
    public E remove() {
        return content.remove();
    }
    public boolean contains(E element) {
        return content.contains(element);
    }
    public boolean containsAll(Collection<E> c) {
        return content.containsAll(c);
    }
    public boolean isEmpty() {
        return content.isEmpty();
    }
    public String toString() {
        return("content: "+content);
    }
}

class BoundedWaitList<E> extends WaitList<E> {
    private int capacity;

    public BoundedWaitList(int capacity) {
        this.capacity = capacity;
    }
    public int getCapacity() {
        return capacity;
    }
    public void add(E element) {
        if(content.size() < capacity) super.add(element);
    }
    public String toString() {
        return ("capacity = "+capacity+", content: "+content);
    }
}

class UnfairWaitList<E> extends WaitList<E> {
    public UnfairWaitList() {}
    public void remove(E element) {
        content.remove(element);
    }
    public void moveToBack() {
        content.add(content.remove());
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("WaitList:");
        WaitList<Integer> WL = new WaitList();
        for (int i=0;i<5;i++) {
            WL.add(i+5);
        }
        System.out.print("\n"+WL+"\nNow WaitList is empty? "+WL.isEmpty());
        for(int i=0;i<5;i++) {
            WL.remove();
        }
        System.out.print("\nNow WaitList is empty? "+WL.isEmpty());

        System.out.print("\n\nBoundedWaitList:");
        BoundedWaitList<Integer> BWL = new BoundedWaitList(5);
        for (int i=0;i<15;i++) {
            BWL.add(i+30);
        }
        System.out.print("\n"+BWL+"\nNow BoundedWaitList is empty? "+BWL.isEmpty());
        BWL.remove();
        BWL.remove();
        System.out.print("\n"+BWL);

        System.out.print("\n\nUnfairWaitList:");
        UnfairWaitList<Integer> UWL = new UnfairWaitList();
        for(int i=0;i<5;i++) {
            UWL.add(i+20);
        }
        System.out.print("\n"+UWL+"\nNow UnfairWaitList is empty? "+UWL.isEmpty());
        UWL.moveToBack();
        System.out.print("\n"+UWL);
    }
}