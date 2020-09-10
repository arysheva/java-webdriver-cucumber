package pages;

public class Bird extends Animal {

    @Override
    public void speak() {
        System.out.println(classAndName() + " is singing");
    }

    public void fly()
    {
        System.out.println(classAndName() + " is flying!!!");
    }
}
