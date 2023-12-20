package org.example;

import java.util.Arrays;


public class DataList<T> {
    private int defaultSize = 10; //default size
    private Object[] elements; //array to store elements
    private int size; //number of elements in list

    public DataList() { //constructor
        elements = new Object[defaultSize];
        size = 0;
    }

    public int size() {
        return size;
    } //gets current size of list

    public boolean isEmpty() {
        return size == 0;
    } //checks if list is empty

    public void add(T element) { //adds elements to list
        ensureCapacity(); //ensures capacity
        elements[size++] = element; //adds element to end of list
    }


    private void ensureCapacity() { //ensures that array has enough capacity
        if (size == elements.length) { //checks if size is equal to array length
            int newCapacity = elements.length * 2; //doubles capacity
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    public void reverse() { //reverses elements in list
        int left = 0;
        int right = size - 1;

        while (left < right) { //repeats until list is reversed
            // Swap elements at left and right indices
            Object temp = elements[left]; //left element stored in temp variable
            elements[left] = elements[right]; //left element set to right element
            elements[right] = temp; //right element set to temp variable (left element)

            // Move indices towards the center
            left++; //left is incremented
            right--; //right is decremented
        }
    }

    @SuppressWarnings("unchecked")
    public T get(int index) { //gets element at specific index
        if (index < 0 || index >= size) { //checks if index is out of bounds
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size + ". Index doesnt exist"); //throws exception
        }
        return (T) elements[index]; //returns element at given index
    }

    public void set(int index, T element) { //sets element to a specified index in list
        if (index < 0 || index >= size) { //if out of bounds
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size + ". Index doesnt exist"); //throws exception
        }
        elements[index] = element; //sets element to given index
    }

    public void remove(int index) { //removes element of specified index
        if (index < 0 || index >= size) { //checks if index is out of bounds
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size + ". Index doesnt exist"); //throws exception
        }
        System.arraycopy(elements, index + 1, elements, index, size - index - 1); //pushes all elements to the left and the element at specified index is overwritten by the following element
        elements[--size] = null; // set the last element to null
    }
}