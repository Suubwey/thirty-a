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
        System.out.println(" 1. Bubble Sort\n 2. Insertion Sort\n 3. Selection Sort\n 4. Merge Sort\n 5. Quick Sort\n 6. Counting Sort");
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
                sortedArray = selectionSort(randomInts);
                break;
            case 4:
                sortedArray = mergeSortWrapper(randomInts);
                break;
            case 5:
                sortedArray = quickSortWrapper(randomInts);
                break;
            case 6:
                sortedArray = countingSort(randomInts);
                break;
            default:
                System.out.println("Error in selecting choice, exiting program...");
                System.exit(0);
                break;
        }
        long endTime = System.nanoTime();
        double timeElapsed = (endTime - startTime) / 1e9;
        System.out.println();
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

    public static void swap(int[] arrayToBeSwapped, int x, int y) {
        int swapNum = arrayToBeSwapped[x];
        arrayToBeSwapped[x] = arrayToBeSwapped[y];
        arrayToBeSwapped[y] = swapNum;
    }

    public static int[] bubbleSort(int[] input) {
        int completed = 0, swapNum;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < input.length - completed - 1; i++) {
                iterations++;
                if (input[i] > input[i + 1]) {
                    swap(input, i, i+1);
                    sorted = false;
                }
            }
            completed++;
        }
        return input;
    }

    public static int[] insertionSort(int[] input) {
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

    public static int[] selectionSort(int[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[minIndex]) {
                    minIndex = j;
                    iterations++;
                }
            }
            swap(input, i, minIndex);
            iterations++;
        }
        return input;
    }

    public static int[] mergeSortWrapper(int[] input) {
        mergeSort(input, input.length);
        return input;
    }

    public static void mergeSort(int[] input, int length) {
        if (input.length < 2) {
            return;
        }
        int mid = input.length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[input.length - mid];
        for (int i = 0; i < mid; i++) {
            leftArray[i] = input[i];
        }
        for (int i = mid; i < input.length; i++) {
            rightArray[i - mid] = input[i];
        }
        mergeSort(leftArray, mid);
        mergeSort(rightArray, input.length - mid);
        int i = 0, j = 0, k = 0;
        while (i < mid && j < input.length - mid) {
            iterations++;
            if (leftArray[i] <= rightArray[j]) {
                input[k++] = leftArray[i++];
            }
            else {
                input[k++] = rightArray[j++];
            }
        }
        while (i < mid) {
            input[k++] = leftArray[i++];
            iterations++;
        }
        while (j < input.length - mid) {
            iterations++;
            input[k++] = rightArray[j++];
        }
    }

    public static int[] quickSortWrapper(int[] input) {
        quickSort(input, 0, input.length-1);
        return input;
    }

    public static void quickSort(int[] input, int left, int right) {
        if (left < right) {
            int pivot = input[right];
            int i = left - 1;
            for (int j = left; j < right; j++) {
                if (input[j] <= pivot) {
                    i++;
                    iterations++;
                    swap(input, i, j);
                }
            }
            swap(input, i + 1, right);
            quickSort(input, left, i);
            quickSort(input, i + 2, right);
        }
    }

    public static int[] countingSort(int[] input) {
        int[] countArray = new int[10000];
        for (int i : input) {
            countArray[i]++;
            iterations++;
        }
        for (int i = 0; i < countArray.length - 1; i++) {
            countArray[i+1] = countArray[i+1] + countArray[i];
            iterations++;
        }
        int[] sorted = new int[input.length];
        for (int i : input) {
            sorted[countArray[i]-1] = i;
            countArray[i]--;
            iterations++;
        }
        return sorted;
    }
}
