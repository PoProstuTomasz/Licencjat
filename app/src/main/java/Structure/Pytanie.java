package Structure;

/**
 * Created by Tomasz on 2017-03-17.
 */

public class Pytanie {

    int nrPytania;
    String trescPytania;
    int prawidlowaOdp;

    Odpowiedz odp;

    public Pytanie(int nrPytania){
        this.nrPytania = nrPytania;
    }
    public Pytanie(){

    }


    public int getPrawidlowaOdp() {
        return prawidlowaOdp;
    }

    public void setPrawidlowaOdp(int prawidlowaOdp) {
        this.prawidlowaOdp = prawidlowaOdp;
    }

    public int getNrPytania() {
        return nrPytania;
    }

    public void setNrPytania(int nrPytania) {
        this.nrPytania = nrPytania;
    }

    public String getTrescPytania() {
        return trescPytania;
    }

    public void setTrescPytania(String trescPytania) {
        this.trescPytania = trescPytania;
    }
}
