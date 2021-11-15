package thirtya;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class ExamExemptionCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int gradeLines = input.nextInt();
        int detentionLines = input.nextInt();
        // The set to see which students qualify;
        TreeSet<String> stuSet = new TreeSet<>();
        // The set to make sure naughty students aren't added back onto the list.
        HashSet<String> naughtyList = new HashSet<>();

        // Processing the grades
        for (int i = 0; i < gradeLines; i++) {
            String name = input.next();
            input.next();
            int grade = input.nextInt();
            input.nextLine();
            // first check if they're already on the good students list, and remove them if their mark is bad.
            if (stuSet.contains(name)) {
                if (grade < 89) {
                    stuSet.remove(name);
                    naughtyList.add(name);
                }
            } else {
                // It won't let them get added even if they have a grade above 89 if they have previously had an 89
                if (grade >= 89 && !naughtyList.contains(name)) {
                    stuSet.add(name);
                }
            }
        }
        for (int i = 0; i < detentionLines; i++) {
            String name = input.next();
            input.nextLine();
            // straight up remove them if their name exists on the detention list, if their name is not on the good students list then the .remove() method won't do anything.
            stuSet.remove(name);
        }

        // print out all student names with iterator.
        Iterator<String> studentIterator = stuSet.iterator();
        while (studentIterator.hasNext()) {
            System.out.println(studentIterator.next());
        }
    }
}
