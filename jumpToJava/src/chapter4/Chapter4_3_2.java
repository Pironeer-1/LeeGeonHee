package chapter4;

public class Chapter4_3_2 {

    public static void main(String[] args) {
        int a = 0;
        while (a < 10) {
            a++;
            if (a % 2 == 0) {
                continue;
            }
            System.out.println(a);
        }
    }
}
