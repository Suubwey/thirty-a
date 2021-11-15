package thirtya;

import java.util.*;

public class hahafunny {
    public static void main(String[] args) {
        Set<String> ySkip = new HashSet<>();
        ArrayList<String> stuLst = new ArrayList<String>(Arrays.asList(
            "12 9",
            "Bob English 98",
            "Larry English 92",
            "Alice English 96",
            "Wilbur English 93",
            "Bob Math 91",
            "Larry Math 99",
            "Alice Math 99",
            "Wilbur Math 90",
            "Bob History 87",
            "Larry History 90",
            "Alice History 98",
            "Wilbur History 94",
            "Pete Jan 21",
            "Pete Jan 22",
            "John Feb 4",
            "Bob Fed 19",
            "Pete Mar 8",
            "Jack Mar 20",
            "Alice Mar 28",
            "Fred April 5",
            "Sally May 4"
        ));
        String temp = stuLst.get(0);
        Scanner scan = new Scanner(temp);
        int grLine = scan.nextInt();
        for (int c = 1; c <= grLine; c++) {
            Scanner lReader = new Scanner(stuLst.get(c));
            String name = lReader.next();
            lReader.next();
            if (lReader.nextInt() > 89) {
                ySkip.add(name);
            } else {
                ySkip.remove(name);
            }
            lReader.close();
        }
        for (int c = grLine + 1; c < stuLst.size(); c++) {
            Scanner lReader = new Scanner(stuLst.get(c));
            String name = lReader.next();
            ySkip.remove(name);
            lReader.close();
        }
        System.out.println(ySkip);
    }
}
