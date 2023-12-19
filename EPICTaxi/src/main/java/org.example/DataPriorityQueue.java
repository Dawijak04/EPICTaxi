package org.example;
import java.util.Comparator;



public class DataPriorityQueue<T> {

    private final DataList<T> heap;
    private final Comparator<T> comparator;

    public DataPriorityQueue(Comparator<T> comparator) {
        this.heap = new DataList<>();
        this.comparator = comparator;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void add(T element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }

    public T poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }

        T top = heap.get(0);
        int lastIndex = heap.size() - 1;
        heap.set(0, heap.get(lastIndex));
        heap.remove(lastIndex);

        if (!isEmpty()) {
            heapifyDown(0);
        }

        return top;
    }

    private void heapifyUp(int childIndex) {
        while (childIndex > 0) {
            int parentIndex = (childIndex - 1) / 2;
            if (comparator.compare(heap.get(childIndex), heap.get(parentIndex)) < 0) {
                swap(childIndex, parentIndex);
                childIndex = parentIndex;
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
            leftChildIndex = 2 * parentIndex + 1;
            rightChildIndex = 2 * parentIndex + 2;
            smallestChildIndex = parentIndex;

            if (leftChildIndex < heap.size() && comparator.compare(heap.get(leftChildIndex), heap.get(smallestChildIndex)) < 0) {
                smallestChildIndex = leftChildIndex;
            }

            if (rightChildIndex < heap.size() && comparator.compare(heap.get(rightChildIndex), heap.get(smallestChildIndex)) < 0) {
                smallestChildIndex = rightChildIndex;
            }

            if (smallestChildIndex != parentIndex) {
                swap(parentIndex, smallestChildIndex);
                parentIndex = smallestChildIndex;
            } else {
                break;
            }
        }
    }

    private void swap(int index1, int index2) {
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

}