package main.java;

/**
 * Created by Макс on 29.01.2018.
 */
public class Juggler implements Performer{
    private int beanBags = 3;
    public Juggler(){}
    public Juggler(int beanBags){
        this.beanBags = beanBags;
    }
    public void perform() {
        System.out.println("JUGGLING " + beanBags + " BEANBAGS");
    }
}
