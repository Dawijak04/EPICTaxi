package org.example;

import java.util.Arrays;
import java.util.Iterator;

public class DataList<T> {
    private int defaultSize = 10;
    private Object[] elements;
    private int size;

    public DataList() {
        elements = new Object[defaultSize];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }


    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    public void reverse() {
        int left = 0;
        int right = size - 1;

        while (left < right) {
            // Swap elements at left and right indices
            Object temp = elements[left];
            elements[left] = elements[right];
            elements[right] = temp;

            // Move indices towards the center
            left++;
            right--;
        }
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {

            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        elements[index] = element;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        // Shift elements to the left to remove the element at the specified index
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null; // Set the last element to null and decrease size

    }


}