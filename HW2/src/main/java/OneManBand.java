package main.java;

import java.util.Collection;

/**
 * Created by Макс on 03.02.2018.
 */
public class OneManBand implements Performer{
    private Collection<Instrument> instruments;

    public OneManBand(){}
    public void perform(){
        for (Instrument instrument:instruments){
            instrument.play();
        }
    }

    public void setInstruments(Collection<Instrument> instruments){
        this.instruments = instruments;
    }

}
