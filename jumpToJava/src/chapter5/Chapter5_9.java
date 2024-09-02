package chapter5;

abstract class Predator extends Animal {
    abstract String getFood();

    void printFood() {
        System.out.printf("my food is %s\n", getFood());
    }
}
public class Chapter5_9 {

}
