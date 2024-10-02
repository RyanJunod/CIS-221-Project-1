// Ryan Junod
//CIS-221 -- Data Structures
// This class is a driver program for ThreeStacks.java. It has five test cases with thorough testing of all of its methods, making sure that everything works as
// it should. The user can load cases 1-5 and see their outputs.
// I did not copy code from other people or sources other than our CIS-221 textbook. I did not use any AI software to help write code.

import java.util.Scanner;

public class ThreeStacksUser {

    // Case 1: General testing. A few pushes and pops to each stack, demonstrating the top function, and then printing the stacks in string representation
    public void case1() {

        ThreeStacks<Integer> stack = new ThreeStacks<>();

        stack.push(5, 1);
        stack.push(4, 1);
        stack.push(3, 1);

        stack.push(7, 2);
        stack.push(8, 2);
        stack.push(9, 2);

        stack.pop(1);
        stack.pop(1);

        stack.push(90, 3);
        stack.push(89, 3);

        stack.pop(2);

        stack.pop(3);

        stack.push(77, 2);

        stack.push(99, 3);

        System.out.println("\nTop of each stack: ");

        System.out.println(stack.top(1));
        System.out.println(stack.top(2));
        System.out.println(stack.top(3));

        System.out.println(stack.toString(1));
        System.out.println(stack.toString(2));
        System.out.println(stack.toString(3));
    }





    // Case 2: Trying to pop on each stack while it is empty
    public void case2() {

        ThreeStacks<Integer> stack = new ThreeStacks<>();

        try {
            stack.pop(1);
        } catch (StackUnderflowException e) {
            System.out.println(e);
        }

        try {
            stack.pop(2);
        } catch (StackUnderflowException e) {
            System.out.println(e);
        }

        try {
            stack.pop(3);
        } catch (StackUnderflowException e) {
            System.out.println(e);
        }
    }





    // Case 3: Prints the top element of each stack when full, then causes a stack overflow
    public void case3() {

        ThreeStacks<Integer> stack = new ThreeStacks<>();

        try {
            stack.push(5, 1);
            stack.push(4, 1);
            stack.push(3, 1);

            stack.push(7, 2);
            stack.push(8, 2);
            stack.push(9, 2);

            stack.push(72, 3);
            stack.push(82, 3);
            stack.push(92, 3);
            stack.push(42, 3);

            System.out.println(stack.top(1));
            System.out.println(stack.top(2));
            System.out.println(stack.top(3));

            stack.push(52, 3);
        } catch(StackOverflowException e) {
            System.out.println(e);
        }

    }





    // Case 4: Checking to see if isEmpty() and isFull() work correctly
    public void case4() {

        ThreeStacks<Integer> stack = new ThreeStacks<>();

        try {
            System.out.println("Stack 1 top: " + stack.top(1));
        } catch (NullPointerException e) {
            System.out.println(e);
        }

        try {
            System.out.println("Stack 2 top: " + stack.top(2));
        } catch (NullPointerException e) {
            System.out.println(e);
        }

        try {
            System.out.println("Stack 3 top: " + stack.top(3));
        } catch (NullPointerException e) {
            System.out.println(e);
        }

        System.out.println();

        System.out.println("Stack 1 empty: " + stack.isEmpty(1));
        System.out.println("Stack 2 empty: " + stack.isEmpty(2));
        System.out.println("Stack 3 empty: " + stack.isEmpty(3));

        System.out.println();

        stack.push(5, 1);
        stack.push(4, 2);
        stack.push(3, 3);

        System.out.println("Stack 1 top: " + stack.top(1));
        System.out.println("Stack 2 top: " + stack.top(2));
        System.out.println("Stack 3 top: " + stack.top(3));

        System.out.println();

        System.out.println("Stack 1 empty: " + stack.isEmpty(1));
        System.out.println("Stack 2 empty: " + stack.isEmpty(2));
        System.out.println("Stack 3 empty: " + stack.isEmpty(3));

        System.out.println(stack.toString(1));
        System.out.println(stack.toString(2));
        System.out.println(stack.toString(3));

        System.out.println();

        System.out.println("Stack full: " + stack.isFull());

        stack.push(5, 1);
        stack.push(4, 2);
        stack.push(3, 3);
        stack.push(5, 1);
        stack.push(4, 2);
        stack.push(3, 3);
        stack.push(5, 1);

        System.out.println(stack.toString(1));
        System.out.println(stack.toString(2));
        System.out.println(stack.toString(3));

        System.out.println();

        System.out.println("Stack full: " + stack.isFull());

        stack.pop(1);
        stack.pop(2);
        stack.pop(3);

        System.out.println(stack.toString(1));
        System.out.println(stack.toString(2));
        System.out.println(stack.toString(3));
    }





    // Case 5: Filling the array up with two stacks, then shrinking one stack and adding to the third one
    public void case5() {

        ThreeStacks<Integer> stack = new ThreeStacks<>();

        stack.push(5, 1);
        stack.push(4, 2);

        stack.push(22, 1);
        stack.push(43, 2);

        stack.push(50, 1);
        stack.push(40, 2);

        System.out.println(stack.toString(1));
        System.out.println(stack.toString(2));
        System.out.println(stack.toString(3));

        stack.pop(1);
        stack.pop(1);
        stack.pop(1);

        stack.push(5, 3);
        stack.push(4, 3);
        stack.push(22, 3);
        stack.push(43, 3);
        stack.push(50, 3);
        stack.push(40, 3);

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println(stack.toString(1));
        System.out.println(stack.toString(2));
        System.out.println(stack.toString(3));
    }










    public static void main(String[] args) {
        ThreeStacksUser program = new ThreeStacksUser();

        Scanner scanner = new Scanner(System.in);

        String inputStr = new String();

        while (!inputStr.equals("Q")) {
            System.out.println("Input test case number to run (1-5). Input 'Q' to quit.");
            inputStr = scanner.next();

            if (inputStr.equals("1")) {
                program.case1();
            }
            else if (inputStr.equals("2")) {
                program.case2();
            }
            else if (inputStr.equals("3")) {
                program.case3();
            }
            else if (inputStr.equals("4")) {
                program.case4();
            }
            else if (inputStr.equals("5")) {
                program.case5();
            }
        }

        scanner.close();
    }

}
