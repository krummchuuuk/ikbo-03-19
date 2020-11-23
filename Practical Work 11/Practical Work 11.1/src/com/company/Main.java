package com.company;
import java.util.Arrays;

class ArrayQueueModule {
    private int[] array = new int[0];
    private int size = 0;

    public void enqueue(int value) {
            size++;
            array = Arrays.copyOf(array, size);
            array[size-1] = value;
    }

    /*
    @size>0
     */
    public int element() {
        return array[0];
    }

    /*
    @size>0
     */
    public int dequeue() {
        int value = array[0];
        array = Arrays.copyOfRange(array, 1, size);
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

    /*
    @size>0
     */
    public void clear() {
        array = Arrays.copyOf(array, 0);
        size = 0;
    }
}

class ArrayQueueADT {
    private int[] array = new int[0];
    private int size = 0;

    public void setArray(int[] arr) {
        array = arr;
        size = arr.length;
    }

    public void enqueue(int value) {
        size++;
        array = Arrays.copyOf(array, size);
        array[size-1] = value;
    }

    /*
    @size>0
     */
    public int element() {
        return array[0];
    }

    /*
    @size>0
     */
    public int dequeue() {
        int value = array[0];
        array = Arrays.copyOfRange(array, 1, size);
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

    /*
    @size>0
     */
    public void clear() {
        array = Arrays.copyOf(array, 0);
        size = 0;
    }
}

class ArrayQueue extends ArrayQueueADT{
    private int[] array = new int[0];
    private int size=0;

    public ArrayQueue(int[] arr) {
        this.setArray(arr);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.print("ArrayQueueModule:\n");
        ArrayQueueModule ex1 = new ArrayQueueModule();
        for (int i=0;i<5;i++) {
            ex1.enqueue(i+10);
        }
        System.out.print("The first element is "+ex1.element()+". Size is "+ex1.size()+"\n");
        System.out.print("Delete "+ex1.dequeue()+" and "+ex1.dequeue()+". New size is "+ex1.size()+"\n");
        if (!ex1.isEmpty()) System.out.print("Now queue isn't empty.\n");
        ex1.clear();
        if (ex1.isEmpty()) System.out.print("But now queue is empty.\n\n");

        System.out.print("ArrayQueueADT:\n");
        ArrayQueueADT ex2 = new ArrayQueueADT();
        int[] array1 =  {20, 22, 24, 26, 28, 30};
        ex2.setArray(array1);
        System.out.print("The first element is "+ex2.element()+". Size is "+ex2.size()+"\n");
        System.out.print("Delete "+ex2.dequeue()+" and "+ex2.dequeue()+". New size is "+ex2.size()+"\n");
        if (!ex2.isEmpty()) System.out.print("Now queue isn't empty.\n");
        ex2.clear();
        if (ex2.isEmpty()) System.out.print("But now queue is empty.\n\n");

        System.out.print("ArrayQueue:\n");
        int[] array2 = {41, 43, 45, 47, 49};
        ArrayQueue ex3 = new ArrayQueue(array2);
        System.out.print("The first element is "+ex3.element()+". Size is "+ex3.size()+"\n");
        System.out.print("Delete "+ex3.dequeue()+" and "+ex3.dequeue()+". New size is "+ex3.size()+"\n");
        if (!ex3.isEmpty()) System.out.print("Now queue isn't empty.\n");
        ex3.clear();
        if (ex3.isEmpty()) System.out.print("But now queue is empty.\n\n");
    }
}