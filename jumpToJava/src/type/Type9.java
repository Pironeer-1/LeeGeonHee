package type;

public class Type9 {

    public static void main(String[] args) {
        int[] odds = {1,3,5,7,9};
        String[] weeks = new String[7];
        weeks[0] = "월";
        weeks[1] = "화";
        weeks[2] = "수";
        weeks[3] = "목";
        weeks[4] = "금";
        weeks[5] = "토";
        weeks[6] = "일";
        System.out.println(weeks[3]);

        for (int i =0 ; i < weeks.length; i++) {
            System.out.println(weeks[i]);
        }
    }
}
