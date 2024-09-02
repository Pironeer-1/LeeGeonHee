package chapter5;

interface Predator{
    String getFood();
}

interface Barkable {
    void bark();
}

interface BarkablePredator extends Predator, Barkable {
}

class Animal3 {
    String name;
    void setName(String name) {
        this.name = name;
    }
}

class Tiger extends Animal3 implements Predator, Barkable {
    public String getFood() {
        return "apple";
    }

    public void bark() {
        System.out.println("어흥");
    }
}

class Lion extends Animal3 implements Predator, Barkable {
    public String getFood() {
        return "banana";
    }

    public void bark() {
        System.out.println("으르렁");
    }
}

class ZooKeeper {
    void feed(Predator predator) {
        System.out.println("feed " + predator.getFood());
    }
}

class Bouncer {
    void barkAnimal(Barkable animal) {
//        if (animal instanceof Tiger) {
//            System.out.println("어흥");
//        } else if (animal instanceof Lion) {
//            System.out.println("으르렁");
//        }
        animal.bark();
    }
}
public class Chapter5_7 {

    public static void main(String[] args) {
        ZooKeeper zooKeeper = new ZooKeeper();
        Tiger tiger = new Tiger();
        Lion lion = new Lion();
//        zooKeeper.feed(tiger);
//        zooKeeper.feed(lion);
        Bouncer bouncer = new Bouncer();
        bouncer.barkAnimal(tiger);
        bouncer.barkAnimal(lion);
    }

}
