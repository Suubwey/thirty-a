package thirtya;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadingFiles {
    public static void main(String[] args) throws IOException {
        Scanner fileScanner = new Scanner(new File("C:\\temp_Jim\\NerdData.txt"));
        String currentLine;
        while (fileScanner.hasNext()) {
            currentLine = fileScanner.nextLine();
            if (currentLine.contains("The")) {
                System.out.println(currentLine);
            }
        }
        System.out.println("-------");
        fileScanner.close();
    }
}
