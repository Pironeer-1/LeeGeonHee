package type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Type11 {

    public static void main(String[] args) {
        ArrayList<String> pitches = new ArrayList<>(Arrays.asList("138", "129", "142"));
        String result = "";
        for (int i = 0 ; i < pitches.size() ; i++) {
            result += pitches.get(i);
            result += ",";
        }
        result = result.substring(0, result.length() - 1);
        System.out.println(result);

        /*
        String result = String.join(",", pitches);
        pitches.sort(Comparator.naturalOrder());
        System.out.println(result);

        */
    }
}
