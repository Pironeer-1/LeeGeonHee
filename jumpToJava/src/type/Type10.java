package type;

import java.util.ArrayList;

public class Type10 {

    public static void main(String[] args) {
        ArrayList<String> pitches = new ArrayList<>();
        pitches.add("138");
        pitches.add("129");
        pitches.add("142");

        pitches.add(0, "133");
        System.out.println(pitches);
        System.out.println(pitches.get(1));
        System.out.println(pitches.size());

        System.out.println(pitches.contains("142"));

        // remove(객체), remove(인덱스) 객체의 경우에는 객체에 해당하는 항목을 삭제하고 true,false를 리턴
        // 인덱스의 경우에는 인덱스에 해당하는 항목을 삭제한 뒤, 그 항목을 리턴한다.

    }
}
