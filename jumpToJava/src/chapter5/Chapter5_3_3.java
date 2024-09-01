package chapter5;

public class Chapter5_3_3 {

    int a;
    void varTest(Chapter5_3_3 sample) {
        sample.a++;
    }

    public static void main(String[] args) {
        Chapter5_3_3 sample = new Chapter5_3_3();
        sample.a = 1;
        sample.varTest(sample);
        System.out.println(sample.a);
    }
}
