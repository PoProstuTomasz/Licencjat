package FunkcjeStatystyczne;

/**
 * Created by Tomasz on 2017-03-23.
 */

public class Prawdopodobienstwa {

    public String PrawdopodobienstwoCiesn( int nrPytania,  int iloscChorychCiesn, int iloscOdpowiedzi ){
        double wynik = 0;

            wynik = (double)iloscChorychCiesn/(double)iloscOdpowiedzi;
            wynik *= 100;

        return String.format("%.2f", wynik);
    }

    public String PrawdopodobienstwoKanal( int nrPytania,  int iloscChorychkanal, int iloscOdpowiedzi ){
        double wynik = 0;

        wynik = (double)iloscChorychkanal/(double)iloscOdpowiedzi;
        wynik *= 100;

        return String.format("%.2f", wynik);
    }
    public String PrawdopodobienstwoQuer( int nrPytania,  int iloscChorychquer, int iloscOdpowiedzi ){
        double wynik = 0;

        wynik = (double)iloscChorychquer/(double)iloscOdpowiedzi;
        wynik *= 100;

        return String.format("%.2f", wynik);
    }
    public String PrawdopodobienstwoZakleszcz( int nrPytania,  int iloscChorychzakleszcz, int iloscOdpowiedzi ){
        double wynik = 0;

        wynik = (double)iloscChorychzakleszcz/(double)iloscOdpowiedzi;
        wynik *= 100;

        return String.format("%.2f", wynik);
    }
    public String PrawdopodobienstwoSpoj( int nrPytania,  int iloscChorychspoj, int iloscOdpowiedzi ){
        double wynik = 0;

        wynik = (double)iloscChorychspoj/(double)iloscOdpowiedzi;
        wynik *= 100;

        return String.format("%.2f", wynik);
    }
}
