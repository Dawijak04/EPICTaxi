package org.example;
import java.util.Comparator;



public class DataPriorityQueue<T> {

    private final DataList<T> heap;
    private final Comparator<T> comparator; //determines priority of elements

    public DataPriorityQueue(Comparator<T> comparator) { //constructor
        this.heap = new DataList<>();
        this.comparator = comparator;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    } //checks if empty

    public void add(T element) { //adds elements to priority queue
        heap.add(element); //adds element to heap
        heapifyUp(heap.size() - 1); //
    }

    public T poll() { //removes and returns highest priority element
        if (isEmpty()) { //checks if queue is empty
            throw new IllegalStateException("Priority queue is empty"); //throws exception
        }
        T top = heap.get(0); //gets first element (highest priority)
        int lastIndex = heap.size() - 1; //gets index of last element
        heap.set(0, heap.get(lastIndex)); //sets it as the first element
        heap.remove(lastIndex); //removes it from the end

        if (!isEmpty()) { //if queue isnt empty
            heapifyDown(0); //restore heap property
        }
        return top; //returns top element
    }

    private void heapifyUp(int childIndex) {
        while (childIndex > 0) {
            int parentIndex = (childIndex - 1) / 2; //gets parent index
            if (comparator.compare(heap.get(childIndex), heap.get(parentIndex)) < 0) { //comapares child index and parent index
                swap(childIndex, parentIndex); //swaps is needed
                childIndex = parentIndex; //child index is set as parent index
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int parentIndex) {
        int leftChildIndex;
        int rightChildIndex;
        int smallestChildIndex;

        while (true) {
            leftChildIndex = 2 * parentIndex + 1; //gets left child index
            rightChildIndex = 2 * parentIndex + 2; //gets right child index
            smallestChildIndex = parentIndex; //sets smallest child index as parent index

            if (leftChildIndex < heap.size() && comparator.compare(heap.get(leftChildIndex), heap.get(smallestChildIndex)) < 0) { //compares with left child index
                smallestChildIndex = leftChildIndex; //updates if needed
            }

            if (rightChildIndex < heap.size() && comparator.compare(heap.get(rightChildIndex), heap.get(smallestChildIndex)) < 0) { //compares with right child index
                smallestChildIndex = rightChildIndex; //updates if needed
            }

            if (smallestChildIndex != parentIndex) { //checks if smallest child index and parent index are not the same
                swap(parentIndex, smallestChildIndex); //swaps them if needed
                parentIndex = smallestChildIndex; //assigns smallest child index to parent index
            } else {
                break; //else breaks
            }
        }
    }

    private void swap(int index1, int index2) { //swaps two elements at given indices
        T temp = heap.get(index1); //stores index 1 value in temp variable
        heap.set(index1, heap.get(index2)); //sets index 1 as index 2
        heap.set(index2, temp); //sets index 2 as temp variable (i.e. index 1)
    }

}