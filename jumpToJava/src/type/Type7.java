package type;

public class Type7 {

    public static void main(String[] args) {
        String a = "Hello Java";

        System.out.println(a.toUpperCase());
        System.out.println(a.toLowerCase());

        String b = "a:b:c:d";
        String[] result = a.split(":");
        // 문자열 배열

        System.out.println(String.format("I eat %d apples.", 3));

        System.out.println(String.format("I eat %s apples.", "five"));

        //문자열 포맷 코드의 종류 { %s : 문자열} ,  %d : 정수},  %f : 부동소수}

        System.out.println(String.format("%10s", "hi"));

        System.out.println(String.format("%10.4f", 3.42134234));

        System.out.printf("I eat %d apples.", 3);

    }
}
