package Structure;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tomasz on 18.04.2017.
 */
@IgnoreExtraProperties
public class DaneBaza {
    //public String id;

    private int iloscOdpowiedzi;

    private int iloscA;
    private int iloscB;
    private int iloscC;
    private int iloscD;

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

    //public Map<String, Boolean> mapa = new HashMap<>();


    public DaneBaza() {
    }

    public DaneBaza( int iloscOdpowiedzi, int iloscA, int iloscB, int iloscC, int iloscD, int iloscChorychCiesn, int iloscChorychKanal, int iloscChorychSpoj, int iloscChorychQuer, int iloscChorychZakleszcz, int iloscBciesn, int iloscBkanal, int iloscBspoj, int iloscBquer, int iloscBzakleszcz) {
        //this.id = id;
        this.iloscOdpowiedzi = iloscOdpowiedzi;
        this.iloscA = iloscA;
        this.iloscB = iloscB;
        this.iloscC = iloscC;
        this.iloscD = iloscD;
        this.iloscChorychCiesn = iloscChorychCiesn;
        this.iloscChorychKanal = iloscChorychKanal;
        this.iloscChorychSpoj = iloscChorychSpoj;
        this.iloscChorychQuer = iloscChorychQuer;
        this.iloscChorychZakleszcz = iloscChorychZakleszcz;
        this.iloscBciesn = iloscBciesn;
        this.iloscBkanal = iloscBkanal;
        this.iloscBspoj = iloscBspoj;
        this.iloscBquer = iloscBquer;
        this.iloscBzakleszcz = iloscBzakleszcz;
    }

    public int getIloscOdpowiedzi() {
        return iloscOdpowiedzi;
    }

    public int getIloscA() {
        return iloscA;
    }

    public int getIloscB() {
        return iloscB;
    }

    public int getIloscC() {
        return iloscC;
    }

    public int getIloscD() {
        return iloscD;
    }

    public int getIloscChorychCiesn() {
        return iloscChorychCiesn;
    }

    public int getIloscChorychKanal() {
        return iloscChorychKanal;
    }

    public int getIloscChorychSpoj() {
        return iloscChorychSpoj;
    }

    public int getIloscChorychQuer() {
        return iloscChorychQuer;
    }

    public int getIloscChorychZakleszcz() {
        return iloscChorychZakleszcz;
    }

    public int getIloscBciesn() {
        return iloscBciesn;
    }

    public int getIloscBkanal() {
        return iloscBkanal;
    }

    public int getIloscBspoj() {
        return iloscBspoj;
    }

    public int getIloscBquer() {
        return iloscBquer;
    }

    public int getIloscBzakleszcz() {
        return iloscBzakleszcz;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("iloscA", iloscA);
        result.put("iloscB", iloscB);
        result.put("iloscC", iloscC);
        result.put("iloscD", iloscD);
        result.put("iloscBciesn", iloscBciesn);
        result.put("iloscBkanal", iloscBkanal);
        result.put("iloscBquer", iloscBquer);
        result.put("iloscBspoj", iloscBspoj);
        result.put("iloscBzakleszcz", iloscBzakleszcz);
        result.put("iloscChorychCiesn", iloscChorychCiesn);
        result.put("iloscChorychKanal", iloscChorychKanal);
        result.put("iloscChorychQuer", iloscChorychQuer);
        result.put("iloscChorychSpoj" , iloscChorychSpoj);
        result.put("iloscChorychZakleszcz", iloscChorychZakleszcz);
        result.put("iloscOdpowiedzi", iloscOdpowiedzi);

        return result;

    }
}
