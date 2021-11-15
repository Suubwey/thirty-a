package thirtya;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Hash_SetUnion {
    public static void main(String[] args) {
        Set<String> s1 = new HashSet<>(Arrays.asList("Bill", "Larry", "Adolph", "Regina", "Susie"));
        Set<String> s2 = new HashSet<>(Arrays.asList("Larry", "Jack", "Alice", "June", "Benny", "Susie"));
        s1.addAll(s2);
        Iterator<String> iter1 = s1.iterator();
        while (iter1.hasNext()) {
            System.out.println(iter1.next());
        }
    }
}
