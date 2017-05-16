package FunkcjeStatystyczne;


import android.util.Log;

public class SredniaDominantaMediana {

    public String Srednia(int nrPytania, int iloscA, int iloscB, int iloscC, int iloscD){
        String wynik = "0";
        if(nrPytania == 1){
            wynik = Srednia1(iloscA,iloscB,iloscC,iloscD);
        }
        if(nrPytania == 15){
            wynik = Srednia15(iloscA,iloscB,iloscC,iloscD);
        }
        return wynik;
    }

    public String Dominanta(int nrPytania, int iloscA, int iloscB, int iloscC, int iloscD){
        String wynik = "0";

        if(nrPytania == 1){
            wynik = Dominanta1(iloscA,iloscB,iloscC,iloscD);
        }
        if( nrPytania == 15){
            wynik = Dominanta15(iloscA,iloscB,iloscC,iloscD);
        }

        return  wynik;
    }
    public  String Mediana(int nrPytania, int iloscA,int iloscB, int iloscC, int iloscD){
        String wynik = "0";
        if(nrPytania == 1){
            wynik = Mediana1(iloscA,iloscB,iloscC,iloscD);
        }
        if (nrPytania == 15){
            wynik = Mediana15(iloscA,iloscB,iloscC,iloscD);
        }
        return wynik;
    }

    public double obliczSrednia(int[] tabSrodkow, int[] tabWynikow){
        double ni=0.0;
        double xini=0.0;

        for(int i=0; i<tabSrodkow.length; i++)
        {
            xini += tabSrodkow[i] * tabWynikow[i];
            ni += tabWynikow[i];
        }

        if(ni!=0)
            return xini/ni;
        return 0;
    }

    public double obliczMediana(int[][] tablicaPrzedzialow,int[] tablicaWynikow){

        double mediana=0;
        int tmp=0;
        double pozycjaMediany = 0;
        int[] wybranyPrzedzial = new int[]{0,0};
        double liczebnośćSkumulowana=0;
        int ni=0;

        for(int i=0; i<tablicaWynikow.length; i++){
            pozycjaMediany += tablicaWynikow[i];
        }

        if(pozycjaMediany==0) {
            return 0;
        }

        if(pozycjaMediany!=0)
            pozycjaMediany = (pozycjaMediany+1)/2;

        for(int i=0; i<tablicaWynikow.length; i++){

            tmp += tablicaWynikow[i];
            if(tmp>=pozycjaMediany) {
                wybranyPrzedzial = new int[]{tablicaPrzedzialow[i][0],tablicaPrzedzialow[i][1]};
                ni = tablicaWynikow[i];
                break;
            }
            liczebnośćSkumulowana = tmp;
        }

        double rozpietosc = wybranyPrzedzial[1]-wybranyPrzedzial[0];

        try {
            mediana = wybranyPrzedzial[0] + (pozycjaMediany - liczebnośćSkumulowana) * (rozpietosc / ni);
        }catch (Exception e)
        {
            mediana = 0;
            Log.e("Blad", "wyliczMediane: ");
            e.printStackTrace();
        }
        return mediana;
    }
    public double obliczDominante(int[][] tablicaPrzedzialow,int[] tablicaWynikow){

        int numerIndexuNajwiekszegoElementu=0;
        int tmp = tablicaWynikow[0];

        double dominanta;
        double xio=0;
        double nio=0;
        double niominus1=0.0;
        double nioplus1=0.0;
        double cio=0;

        for(int i=0; i<tablicaWynikow.length; i++){

            if(tablicaWynikow[i]>tmp)
            {
                tmp = tablicaWynikow[i];
                numerIndexuNajwiekszegoElementu = i;
                xio = tablicaPrzedzialow[i][0];
                nio = tablicaWynikow[i];
            }
        }

        if(tmp==0)
        {
            return 0;
        }

        try {
            niominus1 = tablicaWynikow[numerIndexuNajwiekszegoElementu - 1];
        }catch (Exception e)
        {
            niominus1=1;
        }
        try {
            nioplus1 = tablicaWynikow[numerIndexuNajwiekszegoElementu + 1];
        }catch (Exception e)
        {
            nioplus1=1;
        }

        cio = tablicaPrzedzialow[numerIndexuNajwiekszegoElementu][1] - tablicaPrzedzialow[numerIndexuNajwiekszegoElementu][0];

        try {
            dominanta = xio + ((nio - niominus1) / ((nio - niominus1) + (nio - nioplus1))) * cio;
        }catch (Exception e) {
            dominanta = 0;
            Log.e("Blad", "wyliczDominante: ");
            e.printStackTrace();
        }

        return dominanta;
    }
    private  String Srednia1(int iloscA, int iloscB, int iloscC, int iloscD){
        int srodekPrzedziałuA = 18;
        int srodekPrzedziałuB = 25;
        int srodekPrzedziałuC = 35;
        int srodekPrzedziałuD = 45;

        int[] tablicaSrodkowPrzedzialu = new int[]{srodekPrzedziałuA,srodekPrzedziałuB,srodekPrzedziałuC,srodekPrzedziałuD};
        int[] tablicaWynikow = new int[]{iloscA,iloscB,iloscC,iloscD};

        double wynik = obliczSrednia(tablicaSrodkowPrzedzialu, tablicaWynikow);

        return String.format("%.2f", wynik);
    }
    private  String Srednia15(int iloscA, int iloscB, int iloscC, int iloscD){
        int srodekPrzedziałuA = 3;
        int srodekPrzedziałuB = 5;
        int srodekPrzedziałuC = 7;
        int srodekPrzedziałuD = 9;

        int[] tablicaSrodkowPrzedzialu = new int[]{srodekPrzedziałuA,srodekPrzedziałuB,srodekPrzedziałuC,srodekPrzedziałuD};
        int[] tablicaWynikow = new int[]{iloscA,iloscB,iloscC,iloscD};

        double wynik = obliczSrednia(tablicaSrodkowPrzedzialu, tablicaWynikow);

        return String.format("%.2f", wynik);
    }
    private String Mediana1(int iloscA, int iloscB, int iloscC, int iloscD){
        double wynik=0;

        int[][] tablicaPrzedzialow= new int[][]{ {16,20},{20,30},{30,40},{40,50} };
        int[] tablicaWynikow = new int[]{iloscA,iloscB,iloscC,iloscD};

        wynik = obliczMediana(tablicaPrzedzialow,tablicaWynikow);

        return String.format("%.2f", wynik);
    }
    private String Mediana15(int iloscA, int iloscB, int iloscC, int iloscD){
        double wynik=0;

        int[][] tablicaPrzedzialow= new int[][]{ {2,4},{4,6},{6,80},{8,10}};
        int[] tablicaWynikow = new int[]{iloscA,iloscB,iloscC,iloscD};

        wynik = obliczMediana(tablicaPrzedzialow,tablicaWynikow);

        return String.format("%.2f", wynik);
    }

    private String Dominanta1(int iloscA,int iloscB,int iloscC,int iloscD){

        double wynik=0;

        int[][] tablicaPrzedzialow= new int[][]{ {16,20},{20,30},{30,40},{40,50} };
        int[] tablicaWynikow = new int[]{iloscA,iloscB,iloscC,iloscD};

        wynik = obliczDominante(tablicaPrzedzialow,tablicaWynikow);

        return String.format("%.2f", wynik);
    }
    private String Dominanta15(int iloscA,int iloscB,int iloscC,int iloscD){

        double wynik=0;

        int[][] tablicaPrzedzialow= new int[][]{ {2,4},{4,6},{6,8},{8,10} };
        int[] tablicaWynikow = new int[]{iloscA,iloscB,iloscC,iloscD};

        wynik = obliczDominante(tablicaPrzedzialow,tablicaWynikow);

        return String.format("%.2f", wynik);
    }

}
