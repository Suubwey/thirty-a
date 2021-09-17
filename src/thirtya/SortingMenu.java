package thirtya;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortingMenu {
    public static int iterations = 0;

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int[] randomInts = generateRandomIntegers();
        System.out.println("The numbers have been generated.");
        System.out.println("Please select a sorting algorithm:");
        System.out.println(" 1. Bubble Sort\n 2. Insertion Sort\n 3. Selection Sort\n 4. Merge Sort\n 5. Quick Sort\n 6. Heap Sort");
        int choice = userInput.nextInt();
        long startTime = System.nanoTime();
        int[] sortedArray = null;
        switch (choice) {
            case 1:
                sortedArray = bubbleSort(randomInts);
                break;
            case 2:
                sortedArray = insertionSort(randomInts);
                break;
            case 3:
//                sortedArray = selectionSort(randomInts);
                break;
            case 4:
//                sortedArray = mergeSort(randomInts);
                break;
            case 5:
//                sortedArray = quickSort(randomInts);
                break;
            case 6:
//                sortedArray = heapSort(randomInts);
                break;
            default:
                System.out.println("Error in selecting choice, exiting program...");
                System.exit(0);
                break;
        }
        long endTime = System.nanoTime();
        double timeElapsed = (endTime - startTime) / 1e9;
        System.out.println("");
        for (int num : sortedArray) {
            System.out.println(num);
        }
        System.out.println("Time Elapsed: " + timeElapsed + " seconds\nIterations: " + iterations);
    }

    public static int[] generateRandomIntegers() {
        int[] randomInts = new int[10000];
        Random generator = new Random();
        for (int i = 0; i < randomInts.length; i++) {
            randomInts[i] = generator.nextInt(10000);
        }
        return randomInts;
    }

    public static int[] bubbleSort(int[] input) {
        int completed = 0, tempNumForSwapping;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < input.length - completed - 1; i++) {
                iterations++;
                if (input[i] > input[i + 1]) {
                    tempNumForSwapping = input[i];
                    input[i] = input[i + 1];
                    input[i + 1] = tempNumForSwapping;
                    sorted = false;
                }
            }
            completed++;
        }
        return input;
    }

    public static int[] insertionSort(int[] input) {
        boolean sorted = false;
        for (int i = 1; i < input.length; i++) {
            int numberForMoving = input[i];
            int positionSelector = i-1;
            while (positionSelector >= 0 && input[positionSelector] > numberForMoving) {
                iterations++;
                input[positionSelector + 1] = input[positionSelector];
                positionSelector--;
            }
            input[positionSelector + 1] = numberForMoving;
        }
        return input;
    }
}
