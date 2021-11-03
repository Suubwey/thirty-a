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
            // the input is read with nextline instead of nextdouble because the user can also input equation symbols
            inputtedText = myScanner.nextLine();
            try {
                currentNumber = Double.parseDouble(inputtedText);
                operationStack.push(currentNumber);
            } catch (NumberFormatException notANumber) {
                if (inputtedText.charAt(0) == 'Q') {
                    result = operationStack.peek();
                    break;
                }
                double firstnum = 0, secondnum = 0, tempresultnum = 0;
                secondnum = operationStack.pop();
                firstnum = operationStack.pop();
                switch (inputtedText.charAt(0)) {
                    case '+':
                        tempresultnum = firstnum + secondnum;
                        break;
                    case '-':
                        tempresultnum = firstnum - secondnum;
                        break;
                    case '*':
                        tempresultnum = firstnum * secondnum;
                        break;
                    case '/':
                        tempresultnum = firstnum / secondnum;
                        break;
                }
                operationStack.push(tempresultnum);
            }
        }
        System.out.println(result);
    }
}
