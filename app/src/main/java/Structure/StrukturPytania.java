package Structure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomasz on 2017-03-17.
 */

public class StrukturPytania {

    Odpowiedz odp;
    int nrPytania;
    String pytanie;


    public StrukturPytania(){

    }
    public StrukturPytania(Odpowiedz odp, int nrPytania, String pytanie){
        this.odp = odp;

        this.nrPytania = nrPytania;
        this.pytanie = pytanie;

    }



    public Odpowiedz getOdp() {
        return odp;
    }

    public void setOdp(Odpowiedz odp) {
        this.odp = odp;
    }



    public String getPytanie() {
        return pytanie;
    }

    public void setPytanie(String pytanie) {
        this.pytanie = pytanie;
    }

    public int getNrPytania() {
        return nrPytania;
    }

    public void setNrPytania(int nrPytania) {
        this.nrPytania = nrPytania;
    }


}
