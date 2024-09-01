package chapter5;

class Animals {
    String name;

    void setName(String name) {
        this.name = name;
    }
}
class Dog extends Animals {
    void sleep() {
        System.out.println(this.name+" zzz");
    }
}
public class Chapter5_5 {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setName("poppy");
        System.out.println(dog.name);
        dog.sleep();
    }
}
