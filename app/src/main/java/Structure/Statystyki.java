package Structure;


import java.util.ArrayList;
import java.util.List;

import FunkcjeStatystyczne.Prawdopodobienstwa;
import FunkcjeStatystyczne.SredniaDominantaMediana;

public class Statystyki {

    private  String pytanie;
    private int iloscOdpowiedzi;
    private int iloscodp;
    private int nrPytania;
    private int iloscA;
    private int iloscB;
    private int iloscC;
    private int iloscD;
    private boolean choryciesn;
    private boolean chorykanal;
    private boolean choryspoj;
    private boolean choryquer;
    private boolean choryzakleszcz;
    private int iloscChorychCiesn;
    private int iloscChorychKanal;
    private int iloscChorychSpoj;
    private int iloscChorychQuer;
    private int iloscChorychZakleszcz;

    private int iloscBciesn;

    private int iloscBkanal;

    private int iloscBspoj;

    private int iloscBquer;

    private int iloscBzakleszcz;

    // prawdopodobieństwo iloscA/iloscADanachoroba

    public Statystyki(int nrPytania){
        pytanie="";

        this.nrPytania = nrPytania;
       // this.iloscA=0;
        //this.iloscB=0;
       // this.iloscC=0;
       // this.iloscD=0;

       // this.iloscBciesn=0;

       // this.iloscBkanal=0;

       // this.iloscBspoj=0;

        //this.iloscBquer=0;

       // this.iloscBzakleszcz=0;


        this.choryciesn=false;
        this.chorykanal=false;
        this.choryspoj=false;
        this.choryquer=false;
        this.choryzakleszcz=false;

        //this.iloscChorychCiesn=0;
        //this.iloscChorychKanal=0;
        //this.iloscChorychSpoj=0;
        //this.iloscChorychQuer=0;
        //this.iloscChorychZakleszcz=0;
        //this.iloscOdpowiedzi=0;


    }


    public String getPytanie() {
        return pytanie;
    }

    public void setPytanie(String pytanie) {
        this.pytanie = pytanie;
    }

    public int getIloscodp() {
        return iloscodp;
    }

    public void setIloscodp(int iloscodp) {
        this.iloscodp = iloscodp;
    }

    public int getNrPytania() {
        return nrPytania;
    }

    public void setNrPytania(int nrPytania) {
        this.nrPytania = nrPytania;
    }

    public int getIloscA() {
        return iloscA;
    }

    public void setIloscA(int iloscA) {
        this.iloscA = iloscA;
    }

    public int getIloscB() {
        return iloscB;
    }

    public void setIloscB(int iloscB) {
        this.iloscB = iloscB;
    }

    public int getIloscD() {
        return iloscD;
    }

    public void setIloscD(int iloscD) {
        this.iloscD = iloscD;
    }

    public int getIloscC() {
        return iloscC;
    }

    public void setIloscC(int iloscC) {
        this.iloscC = iloscC;
    }


    public int getIloscBciesn() {
        return iloscBciesn;
    }

    public void setIloscBciesn(int iloscBciesn) {
        this.iloscBciesn = iloscBciesn;
    }



    public int getIloscBkanal() {
        return iloscBkanal;
    }

    public void setIloscBkanal(int iloscBkanal) {
        this.iloscBkanal = iloscBkanal;
    }



    public int getIloscBspoj() {
        return iloscBspoj;
    }

    public void setIloscBspoj(int iloscBspoj) {
        this.iloscBspoj = iloscBspoj;
    }



    public int getIloscBquer() {
        return iloscBquer;
    }

    public void setIloscBquer(int iloscBquer) {
        this.iloscBquer = iloscBquer;
    }



    public int getIloscBzakleszcz() {
        return iloscBzakleszcz;
    }

    public void setIloscBzakleszcz(int iloscBzakleszcz) {
        this.iloscBzakleszcz = iloscBzakleszcz;
    }


    public boolean isChoryciesn() {
        return choryciesn;
    }

    public void setChoryciesn(boolean choryciesn) {
        this.choryciesn = choryciesn;
    }

    public boolean isChorykanal() {
        return chorykanal;
    }

    public void setChorykanal(boolean chorykanal) {
        this.chorykanal = chorykanal;
    }

    public boolean isChoryspoj() {
        return choryspoj;
    }

    public void setChoryspoj(boolean choryspoj) {
        this.choryspoj = choryspoj;
    }

    public boolean isChoryquer() {
        return choryquer;
    }

    public void setChoryquer(boolean choryquer) {
        this.choryquer = choryquer;
    }

    public boolean isChoryzakleszcz() {
        return choryzakleszcz;
    }

    public void setChoryzakleszcz(boolean choryzakleszcz) {
        this.choryzakleszcz = choryzakleszcz;
    }

    public int getIloscChorychCiesn() {
        return iloscChorychCiesn;
    }

    public void setIloscChorychCiesn(int iloscChorychCiesn) {
        this.iloscChorychCiesn = iloscChorychCiesn;
    }

    public int getIloscChorychKanal() {
        return iloscChorychKanal;
    }

    public void setIloscChorychKanal(int iloscChorychKanal) {
        this.iloscChorychKanal = iloscChorychKanal;
    }

    public int getIloscChorychSpoj() {
        return iloscChorychSpoj;
    }

    public void setIloscChorychSpoj(int iloscChorychSpoj) {
        this.iloscChorychSpoj = iloscChorychSpoj;
    }

    public int getIloscChorychQuer() {
        return iloscChorychQuer;
    }

    public void setIloscChorychQuer(int iloscChorychQuer) {
        this.iloscChorychQuer = iloscChorychQuer;
    }

    public int getIloscChorychZakleszcz() {
        return iloscChorychZakleszcz;
    }

    public void setIloscChorychZakleszcz(int iloscChorychZakleszcz) {
        this.iloscChorychZakleszcz = iloscChorychZakleszcz;
    }

    public int getIloscOdpowiedzi() {
        return iloscOdpowiedzi;
    }

    public void setIloscOdpowiedzi(int iloscOdpowiedzi) {
        this.iloscOdpowiedzi = iloscOdpowiedzi;
    }



    public String toString() {
        SredniaDominantaMediana funkcja = new SredniaDominantaMediana();
        Prawdopodobienstwa funkcja2 = new Prawdopodobienstwa();
        String poczatek = "";
        if(iloscodp>=1) poczatek+="\n A=" + iloscA + "  - " + Dane.pytania.get(nrPytania).getOdp().getOdpA();
        if(iloscodp>=2) poczatek+="\n B=" + iloscB + "  - " + Dane.pytania.get(nrPytania).getOdp().getOdpB();
        if(iloscodp>=3) poczatek+="\n C=" + iloscC + "  - " + Dane.pytania.get(nrPytania).getOdp().getOdpC();
        if(iloscodp>=4) poczatek+="\n D=" + iloscD + "  - " + Dane.pytania.get(nrPytania).getOdp().getOdpD();

        poczatek+="\n";

        //if (nrPytania == 2 || nrPytania == 5 || nrPytania == 7 || nrPytania == 9 || nrPytania == 12)
           // poczatek+= " ilosc Chory cieśn: " + iloscChorychCiesn + " ilosc Chory kanał: " + iloscChorychKanal + "\n" + " ilosc Chory spoj  " + iloscChorychSpoj + " ilosc Chory quer:  " + iloscChorychQuer + " ilosc Chory zakleszcz:  " + iloscChorychZakleszcz;
        //poczatek+="\n";

        if(nrPytania == 2)
            poczatek+= "\nPrawdopodobieństwo wystąpienia zespołu cieśni nadgarstka: " + funkcja2.PrawdopodobienstwoCiesn(nrPytania,iloscChorychCiesn,iloscOdpowiedzi) + " %";
        if(nrPytania == 5)
            poczatek+= "\nPrawdopodobieństwo wystąpienia zespołu kanału łokciowego: " + funkcja2.PrawdopodobienstwoKanal(nrPytania,iloscChorychKanal,iloscOdpowiedzi) + " %";
        if(nrPytania == 7)
            poczatek+= "\nPrawdopodobieństwo wystąpienia zespołu de Quervaina: " + funkcja2.PrawdopodobienstwoQuer(nrPytania,iloscChorychQuer,iloscOdpowiedzi) + " %";
        if(nrPytania == 9)
            poczatek+= "\nPrawdopodobieństwo wystąpienia zakleszczającego zapalenia ścięgna: " + funkcja2.PrawdopodobienstwoZakleszcz(nrPytania,iloscChorychZakleszcz,iloscOdpowiedzi) + " %";
        if(nrPytania == 12)
            poczatek+= "\nPrawdopodobieństwo wystąpienia Zapalenia spojówek: " + funkcja2.PrawdopodobienstwoSpoj(nrPytania,iloscChorychSpoj,iloscOdpowiedzi) + " %";
        poczatek+="\n";

        if(nrPytania == 1 || nrPytania == 15) {
                poczatek+="\n";
                poczatek+="Srednia arytmetyczna: " + funkcja.Srednia(nrPytania, iloscA, iloscB, iloscC, iloscD);
                poczatek+="\n";

                poczatek+="Mediana: " + funkcja.Mediana(nrPytania, iloscA, iloscB, iloscC, iloscD) ;
                poczatek+="\n";

                poczatek+="Dominanta: " + funkcja.Dominanta(nrPytania, iloscA, iloscB, iloscC, iloscD) ;
                poczatek+="\n";


        }

        return poczatek;
    }
}
