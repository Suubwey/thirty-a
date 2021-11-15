package StackAssignment;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        // initializing the inputs and the stack itself.
        StackLL operationStack = new StackLL();
        Scanner myScanner = new Scanner(System.in);
        String inputtedText;
        double currentNumber, result;

        // main program loop
        while (true) {
            System.out.print("Enter number, math operation(+,-,*, or /), or Q to quit: ");
            // the input is read with nextline instead of nextdouble because the user can also input equation symbols.
            inputtedText = myScanner.nextLine();
            try {
                // Attempt to parse the number, and will add it to the stack if it is one.
                currentNumber = Double.parseDouble(inputtedText);
                operationStack.push(currentNumber);
            } catch (NumberFormatException notANumber) {
                // checks to see if the letter "Q" has been entered, if so then get the number on the top of the stack and assigns it to result.
                if (inputtedText.charAt(0) == 'Q') {
                    result = operationStack.pop();
                    break;
                // check to see if any operators have been typed. if not it goes to the else statement
                } else if (inputtedText.matches("\\+|-|\\*|/")) {
                    double firstNum = 0, secondNum = 0, tempresultNum = 0;
                    // getting the numbers with .pop() methods to do the operation
                    secondNum = operationStack.pop();
                    firstNum = operationStack.pop();
                    // swtich statement to see which operation to do.
                    switch (inputtedText.charAt(0)) {
                        case '+':
                            tempresultNum = firstNum + secondNum;
                            break;
                        case '-':
                            tempresultNum = firstNum - secondNum;
                            break;
                        case '*':
                            tempresultNum = firstNum * secondNum;
                            break;
                        case '/':
                            tempresultNum = firstNum / secondNum;
                            break;
                    }
                    // puts the result onto the stack.
                    operationStack.push(tempresultNum);
                } else {
                    // invalid input message
                    System.out.println("Please enter a valid input.");
                }
            }
        }
        // the only way the program gets here is if Q has been pressed, which then it will print the result
        System.out.println(result);
    }
}
