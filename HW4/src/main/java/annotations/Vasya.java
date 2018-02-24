package annotations;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by Макс on 25.02.2018.
 */
public class Vasya implements Student {

    private int luck;

    public Vasya(int luck) {
        this.luck = luck;
    }

    public void startExam() {
        System.out.println("Vasya, just do it!!!");
    }

    public int endExam() {
        Random rand = new Random();
        final int max = 10;
        final int min = 1;
        int randomNum = rand.nextInt((max - min) + 1) + min;
        if (randomNum >= this.luck) {
            System.out.println("Vasya couldn't((((");
            return 2;
        }
        System.out.println("Vasya did it!!!");
        return 5;
    }
}
