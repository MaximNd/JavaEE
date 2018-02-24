package xml;

import java.util.Random;

/**
 * Created by Макс on 25.02.2018.
 */
public class Petya implements Student2 {
    public void startExam() {
        System.out.println("Petya you can!");
    }

    public int endExam() {
        Random rand = new Random();
        final int max = 10;
        final int min = 1;
        int petyaTurn = rand.nextInt((max - min) + 1) + min;
        int examTurn = rand.nextInt((max - min) + 1) + min;

        if (examTurn >= petyaTurn) {
            System.out.println("Petya looser!!!!! Exam WIN!!!");
            return 2;
        }
        System.out.println("Petya WIN!!!");
        return 5;
    }
}
