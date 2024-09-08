package chapter5;

class Animal {
    String name;

    public void setName(String name) {
        this.name = name;
    }
}
public class Chapter5_2 {

    public static void main(String[] args) {
        Animal cat = new Animal();
        cat.setName("boby");

        Animal dog = new Animal();
        dog.setName("happy");
    }
}
