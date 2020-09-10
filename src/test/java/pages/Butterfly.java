package pages;

public class Butterfly extends Bird {

    public String color;

    public Butterfly() {
        this.color = "white";
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void speak() {
        System.out.println(classAndName() + " " + color + " is silent");
    }
}
