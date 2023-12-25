package github.io.review.reflect;

public class Apple implements Fruit {
    public Apple() {}

    public Apple(String color) {
        System.out.println("Apple color is: " + color);
    }

    @Override
    public void eat() {
        System.out.println("Eat the apple，sweet! ");
    }
}