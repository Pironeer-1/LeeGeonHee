package type;

public class Type6 {

    public static void main(String[] args) {
        String a = "Happy Java";

        String b = new String("Happy Java");
        // String은 리터럴 표기 방식을 사용할 수 있지만 원시 자료형은 아니다.

        System.out.println(a.equals(b));
        // ==은 2개의 자료형이 같은 객체인지를 판별할 때 사용하는 연산자이다.
        System.out.println(a.indexOf("Java"));

        System.out.println(a.contains("Java"));
        // 포함 여부를 리턴

        System.out.println(a.charAt(6));
        // 문자열에서 특정 위치의 문자를 리턴

        System.out.println(a.replaceAll("Java", "World"));
        // 특정 문자열을 다른 문자열로 바꿈

        System.out.println(a.substring(0,5));
        // 문자열안에서 특정 문자열을 뽑아낼때 사용하는데 시작위치 <= a < 끝위치
    }
}
