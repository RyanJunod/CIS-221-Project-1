// Ryan Junod
//CIS-221 -- Data Structures
// This class creates three stacks which share the memory of one array. Once the sum of the three stacks exceeds the capacity, the stack has overflowed. The class can push,
// pop, and read the top for each of the three stacks and check to see whether the stack is full or whether or not each stack is empty. There is also a toString() method
// for testing purposes.
// I did not copy code from other people or sources other than our CIS-221 textbook. I did not use any AI software to help write code.

public class ThreeStacks<T> implements StackInterface3<T> {

    // Stack indexes and capacity limit
    private int topIndex1 = -1;
    private int topIndex2 = -1;
    private int topIndex3 = -1;
    private final int DEFCAP = 10;

    private T[] elements;





    // Constructor
    public ThreeStacks() {
        elements = (T[]) new Object[DEFCAP];
    }





    // Push method
    // Pre-conditions: The stack is not at maximum capacity
    // Post-conditions: The passed element is pushed to the specified stack number
    public void push(T element, int numStack) throws StackOverflowException {

        if (isFull() == true) {
            throw new StackOverflowException("Push attempted on a full stack.");
        }

        if (numStack == 1) {

            // Increment indexes
            topIndex1++;
            topIndex2++;
            topIndex3++;

            // Moving stack 3 elements
            for (int i = DEFCAP - 1; i > topIndex2; i--) {
                if (!isEmpty(3)) {
                    T temp = elements[i - 1];
                    elements[i] = temp;
                }
            }

            // Moving stack 2 elements
            for (int i = topIndex2; i > topIndex1; i--) {
                if (!isEmpty(2)) {
                    T temp = elements[i - 1];
                    elements[i] = temp;
                }
            }

            // Add element
            elements[topIndex1] = element;
        }

        else if (numStack == 2) {

            // Increment indexes
            topIndex2++;
            topIndex3++;
    
            // Moving stack 3 elements
            for (int i = DEFCAP - 1; i >= topIndex3; i--) {
                if (!isEmpty(3)) {
                    T temp = elements[i - 1];
                    elements[i] = temp;
                }
            }
    
            // Add element
            elements[topIndex2] = element;
        }

        else {

            // Increment index
            topIndex3++;
    
            // Add element
            elements[topIndex3] = element;
        }
    }





    // Pop method
    // Pre-conditions: The specified stack is not empty
    // Post-conditions: The top element of the specified stack is removed
    public void pop(int numStack) throws StackUnderflowException {

        if (isEmpty(numStack) == true) {
            throw new StackUnderflowException("Pop attempted on an empty stack.");
        }

        if (numStack == 1) {

            // Remove element
            elements[topIndex1] = null;

            // Move all elements above down
            for (int i=topIndex1; i < topIndex3; i++) {
                T temp = elements[i + 1];
                elements[i] = temp;
                elements[i + 1] = null;
            }

            // Increment indexes
            topIndex1--;
            topIndex2--;
            topIndex3--;
        }

        else if (numStack == 2) {
    
            // Remove element
            elements[topIndex2] = null;
    
            // Move all elements above down
            for (int i=topIndex2; i <= topIndex3; i++) {
                T temp = elements[i + 1];
                elements[i] = temp;
                elements[i + 1] = null;
            }
    
            // Increment indexes
            topIndex2--;
            topIndex3--;
        }

        else {
    
            // Remove element
            elements[topIndex3] = null;
    
            // Increment index
            topIndex3--;
        }
    }





    // Top method
    // Pre-conditions: The specified stack is not empty
    // Post-conditions: The top element of the stack is returned
    public T top(int numStack) throws NullPointerException {
        if (isEmpty(numStack) == true) {
            throw new NullPointerException("Top attempted on empty stack.");
        }

        T element;

        if (numStack == 1) {
            element = elements[topIndex1];
        }

        else if (numStack == 2) {
            element = elements[topIndex2];
        }

        else {
            element = elements[topIndex3];
        }

        return element;
    }






    // isFull()
    // Pre-conditions: None
    // Post-conditions: If the stack is full, return true; otherwise return false
    public boolean isFull() {
        return (topIndex3 == elements.length - 1);
    }


    // isEmpty()
    // Pre-conditions: None
    // Post-conditions: If the specified stack is empty, return true; otherwise return false
    public boolean isEmpty(int numStack) {
        if (numStack == 1) {
            return (topIndex1 == -1);
        }
        else if (numStack == 2) {
            return (topIndex2 == (topIndex1));
        }
        else {
            return (topIndex3 == (topIndex2));
        }
    }





    // toString method
    // Pre-conditions: None
    // Post-conditions: The contents of the specified stack are returned in a string
    public String toString(int numStack) {

        StringBuffer sb = new StringBuffer();

        sb.append("\nItems in stack ").append(numStack).append(": ");
        
        if (numStack == 1) {

            // Iterating through stack 1 items
            for (int i = 0; i <= topIndex1; i++) {
                sb.append("\n").append(elements[i]);
            }
        } else if (numStack == 2) {

            // Iterating through stack 2 items
            for (int i = topIndex1 + 1; i <= topIndex2; i++) {
                sb.append("\n").append(elements[i]);
            }
        } else {

            // Iterating through staack 3 items
            for (int i = topIndex2 + 1; i <= topIndex3; i++) {
                sb.append("\n").append(elements[i]);
            }
        }

        String newString = sb.toString();
        return newString;
    }
}