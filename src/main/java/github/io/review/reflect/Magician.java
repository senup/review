package github.io.review.reflect;

public class Magician {
    private String name;
    
    public Magician(String name) {
        this.name = name;
    }

    private String showMagic(String magicName, int times) {
        return "The magician " + this.name + " performed magic: " + magicName + " for " + times + " times.";
    }
}