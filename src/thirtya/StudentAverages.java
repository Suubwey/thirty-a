package thirtya;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class StudentAverages {
    public static void main(String[] args) throws IOException {
        Scanner fileScanner = new Scanner(new File("C:\\temp_Jim\\StudentScores.in"));
        String studentName = null;
        double average = 0;
        while (fileScanner.hasNext()) {
            studentName = fileScanner.next();
            int counter = -1, maxsum = 0;
            while (fileScanner.hasNextInt()) {
                counter++;
                maxsum += fileScanner.nextInt();
            }
            average = (double) maxsum / (counter + 1) + 0.5;
            System.out.println(studentName + ", average = " + (int) average);
        }
        fileScanner.close();
    }
}
