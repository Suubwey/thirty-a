package thirtya;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentAverages_Out {
    public static void main(String[] args) throws IOException {
        Scanner fileScanner = new Scanner(new File("C:\\temp_Jim\\StudentScores.in"));
        String studentName = null;
        FileWriter writer = new  FileWriter(new File("C:\\temp_Jim\\StudentScores.out"));
        double average = 0;
        while (fileScanner.hasNext()) {
            studentName = fileScanner.next();
            int counter = -1, maxsum = 0;
            while (fileScanner.hasNextInt()) {
                counter++;
                maxsum += fileScanner.nextInt();
            }
            average = (double) maxsum / (counter + 1) + 0.5;
            String result = studentName + ", average = " + (int) average;
            System.out.println(result);
            writer.write(result + "\n");
        }
        fileScanner.close();
        writer.close();
    }
}
