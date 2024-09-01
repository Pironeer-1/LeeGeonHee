package chapter5;

class Calculator {
    int result = 0;

    int add(int num) {
        result += num;
        return result;
    }

    int sub(int num) {
        result -= num;
        return result;
    }
}
public class Chapter5_1 {

    public static void main(String[] args) {
        Calculator cal1 = new Calculator();
        Calculator cal2 = new Calculator();

        System.out.println(cal1.add(3));
        System.out.println(cal1.add(4));

        System.out.println(cal2.add(3));
        System.out.println(cal2.add(7));
    }
}
