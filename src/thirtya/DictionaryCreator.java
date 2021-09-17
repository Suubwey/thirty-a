package thirtya;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

public class DictionaryCreator {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(new File("C:\\temp_Jim\\PrideAndPrejudice.txt"));
        FileWriter writer = new FileWriter("C:\\temp_Jim\\Dictionary.out");
        TreeMap<String, Integer> dictionary = new TreeMap<>();
        int totalWordCount = 0;
        while (reader.hasNext()) {
            String[] currentLine = reader.nextLine().replaceAll("[^a-zA-Z ]","").split("\\s+");
            if (currentLine.length == 1 && currentLine[0].equals("")) {
                continue;
            }
            for (String word : currentLine) {
                if (word.length() >= 3 && !Character.isUpperCase(word.charAt(0))) {
                    totalWordCount++;
                    if (dictionary.containsKey(word)) {
                        dictionary.put(word, dictionary.get(word) + 1);
                    } else {
                        dictionary.put(word, 1);
                    }
                }
            }
        }
        for (Map.Entry<String, Integer> pair : dictionary.entrySet()) {
            writer.write(pair.getKey() + " = " + pair.getValue() + "\n");
        }
        writer.write("Total word count: " + totalWordCount);
        writer.close();
        reader.close();
    }
}
