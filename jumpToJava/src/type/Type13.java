package type;

import java.util.Arrays;
import java.util.HashSet;

public class Type13 {

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>(Arrays.asList("H", "e", "l", "l", "o"));
        System.out.println(set);

        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3,4,5,6));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(4,5,6,7,8,9));

        HashSet<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println(intersection);

        HashSet<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println(union);

        HashSet<Integer> substract = new HashSet<>(set1);
        substract.removeAll(set2);
        System.out.println(substract);

        HashSet<String> set3 = new HashSet<>();
        set3.add("Jump");
        set3.add("To");
        set3.add("Java");
        System.out.println(set3);
    }
}
