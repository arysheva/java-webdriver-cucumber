package classes_practice;

public class Cat extends Animal {

    public Cat(String name) {
        this.name = name;
    }

    public void speak() {
        System.out.println(classAndName() + " is meowing!");
    }

}