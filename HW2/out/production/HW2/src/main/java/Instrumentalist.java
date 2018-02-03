package main.java;

/**
 * Created by Макс on 03.02.2018.
 */
public class Instrumentalist implements Performer {
    private Instrument instrument;
    private String song;

    public Instrumentalist() {}

    public void perform() {
        System.out.print("Playing " + song + " : ");
        instrument.play();
    }

    public void setSong(String song) {
        this.song = song;
    }
    public String getSong() {
        return song;
    }
    public String screamSong() {
        return song;
    }

    public void setInstrument(Instrument instrument){
        this.instrument = instrument;
    }

}
