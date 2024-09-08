package type;

public class Type15 {

    public static void main(String[] args) {
        String num = "123";
        int n1 = Integer.parseInt(num);
        System.out.println(n1);

        int n2 = 345;
        String number = "" + n2;
        System.out.println(number);

        //String.valueOf(정수), Integeer.toString(정수) : 정수를 문자열로 바꾸어 리턴

        String num2 = "123.456";
        double d = Double.parseDouble(num2);
        System.out.println(d);

        int n3 = 123;
        double d2 = n3;
        System.out.println(d2); //여기서는 캐스팅이 필요없다 왜냐하면 정수를 실수로 바꾸는거기 때문에

        double d3 = 123.456;
        int n4 = (int) d3;
        System.out.println(n4);
    }
}
