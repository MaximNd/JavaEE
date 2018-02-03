package main.java;

/**
 * Created by Макс on 03.02.2018.
 */
public class Saxophone implements Instrument {
    public Saxophone(){}
    @Override
    public void play(){
        System.out.println("Saxophone: TOOT TOOT TOOT");
    }

}
