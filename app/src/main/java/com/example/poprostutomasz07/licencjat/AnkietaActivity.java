package com.example.poprostutomasz07.licencjat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import Structure.Dane;
import Structure.DaneBaza;
import Structure.Statystyki;
import Structure.StrukturPytania;

public class AnkietaActivity extends AppCompatActivity {

    boolean a,b,c,d;
    int value;
    StrukturPytania pytanie;
    RadioGroup radio;
    DatabaseReference databaseChoroby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_ankieta);

        TextView tv = (TextView)findViewById(R.id.pytanie);
        Bundle extras = getIntent().getExtras();
        value = extras.getInt("nrPytania");
        if(tv != null){
            tv.setText(" " + (value-1));
        }
        pytanie = Dane.pytania.get(value-1);
        initRadioGroup();


        String id = Integer.toString(value);
        databaseChoroby = FirebaseDatabase.getInstance().getReference().child("choroby").child(id);

    }





    public void zeruj(){
        a=false;
        b=false;
        c=false;
        d=false;
        Statystyki statystyki = Dane.odpowiedzi.get(pytanie.getNrPytania());
        statystyki.setChoryciesn(false);
        statystyki.setChorykanal(false);
        statystyki.setChoryquer(false);
        statystyki.setChoryzakleszcz(false);
        statystyki.setChoryspoj(false);

    }

    public void initRadioGroup(){
        zeruj();
        StrukturPytania pytanie = Dane.pytania.get(value-1);

        FrameLayout item = (FrameLayout) this.findViewById(R.id.framelayout);
        item.removeAllViews();
        TextView tv = (TextView)findViewById(R.id.pytanie);
        tv.setText(pytanie.getPytanie() );
        radio = new RadioGroup(this);

        if(pytanie.getOdp().getOdpA() != null) {
            RadioButton radio1 = new android.support.v7.widget.AppCompatRadioButton(this) {
                @Override
                public void setChecked(boolean checked) {
                    a = checked;
                    super.setChecked(checked);
                }
            };
            radio1.setText(pytanie.getOdp().getOdpA());
            radio.addView(radio1);
        }

        if(pytanie.getOdp().getOdpB() != null) {
            RadioButton radio2 = new android.support.v7.widget.AppCompatRadioButton(this) {
                @Override
                public void setChecked(boolean checked) {
                    b = checked;
                    super.setChecked(checked);
                }
            };
            radio2.setText(pytanie.getOdp().getOdpB());
            radio.addView(radio2);
        }

        if(pytanie.getOdp().getOdpC() != null) {
            RadioButton radio3 = new android.support.v7.widget.AppCompatRadioButton(this) {
                @Override
                public void setChecked(boolean checked) {
                    c = checked;
                    super.setChecked(checked);
                }
            };
            radio3.setText(pytanie.getOdp().getOdpC());
            radio.addView(radio3);
        }

        if(pytanie.getOdp().getOdpD() != null) {
            RadioButton radio4 = new android.support.v7.widget.AppCompatRadioButton(this) {
                @Override
                public void setChecked(boolean checked) {
                    d = checked;
                    super.setChecked(checked);
                }
            };
            radio4.setText(pytanie.getOdp().getOdpD());
            radio.addView(radio4);
        }


        item.addView(radio);
    }


    public boolean CzyWykonano(){
        if( a == false && b==false && c==false && d==false ){
            return false;
        } else
            return true;
    }

    public void zapiszWynik() {

       Statystyki statystyki = Dane.odpowiedzi.get(pytanie.getNrPytania());
        if(a){
            statystyki.setIloscA(statystyki.getIloscA()+1);
        }
        if(b) {
            statystyki.setIloscB(statystyki.getIloscB()+1);
        }
        if(c){
            statystyki.setIloscC(statystyki.getIloscC()+1);
        }
        if(d){
            statystyki.setIloscD(statystyki.getIloscD()+1);
        }

    }

    public void czyChory() {

        Statystyki statystyki = Dane.odpowiedzi.get(pytanie.getNrPytania());
        int  x = (value -1);

        if(x == 2 && a ) {
                statystyki.setChoryciesn(true);
        }
        if(x == 5 && a ){
                statystyki.setChorykanal(true);
        }
        if(x == 7 && a){
                statystyki.setChoryquer(true);
       }
       if(x == 9 && a){
                statystyki.setChoryzakleszcz(true);
       }
        if(x == 12 && a){
                statystyki.setChoryspoj(true);
        }
    }


    public void ileOdpowiedzi(){
        Statystyki statystyki = Dane.odpowiedzi.get(pytanie.getNrPytania());
        statystyki.setIloscOdpowiedzi(statystyki.getIloscOdpowiedzi() + 1);
    }


        public void ileChorych(){
            Statystyki statystyki = Dane.odpowiedzi.get(pytanie.getNrPytania());
        if(statystyki.isChoryciesn()){
            statystyki.setIloscChorychCiesn(statystyki.getIloscChorychCiesn() + 1);
        }
        if(statystyki.isChorykanal()){
            statystyki.setIloscChorychKanal(statystyki.getIloscChorychKanal() + 1);
        }
        if(statystyki.isChoryspoj()){
            statystyki.setIloscChorychSpoj(statystyki.getIloscChorychSpoj() + 1);
        }
        if(statystyki.isChoryquer()){
            statystyki.setIloscChorychQuer(statystyki.getIloscChorychQuer() + 1 );
        }
        if(statystyki.isChoryzakleszcz()){
            statystyki.setIloscChorychZakleszcz(statystyki.getIloscChorychZakleszcz() + 1);
        }
        }

    public void wplywChory() {
        Statystyki statystyki = Dane.odpowiedzi.get(pytanie.getNrPytania());
        //Zespol ciesni nadgarstka

        if(statystyki.isChoryciesn() && b) {
            statystyki.setIloscBciesn(statystyki.getIloscBciesn()+1);
        }

        if(statystyki.isChorykanal() && b) {
            statystyki.setIloscBkanal(statystyki.getIloscBkanal()+1);
        }

        // Zapalenie spojowek

        if(statystyki.isChoryspoj() && b) {
            statystyki.setIloscBspoj(statystyki.getIloscBspoj()+1);
        }

        //zespół de quervaina

        if(statystyki.isChoryquer() && b) {
            statystyki.setIloscBquer(statystyki.getIloscBquer()+1);
        }

        //zakleszczające zapalenie ścięgna

        if(statystyki.isChoryzakleszcz() && b) {
            statystyki.setIloscBzakleszcz(statystyki.getIloscBzakleszcz()+1);
        }


    }

    public void addToDatabase(){

        Statystyki statystyki = Dane.odpowiedzi.get(pytanie.getNrPytania());
        int iloscOdpowiedzi = statystyki.getIloscOdpowiedzi();
         int iloscA = statystyki.getIloscA();
         int iloscB = statystyki.getIloscB();
         int iloscC = statystyki.getIloscC();
         int iloscD = statystyki.getIloscD();

         int iloscChorychCiesn = statystyki.getIloscChorychCiesn();
         int iloscChorychKanal = statystyki.getIloscChorychKanal();
         int iloscChorychSpoj = statystyki.getIloscChorychSpoj();
         int iloscChorychQuer = statystyki.getIloscChorychQuer();
         int iloscChorychZakleszcz = statystyki.getIloscChorychZakleszcz();

         int iloscBciesn = statystyki.getIloscBciesn();
         int iloscBkanal = statystyki.getIloscBkanal();
         int iloscBspoj = statystyki.getIloscBspoj();
         int iloscBquer = statystyki.getIloscBquer();
         int iloscBzakleszcz = statystyki.getIloscBzakleszcz();
         //String key = databaseChoroby.push().getKey();
        String id = Integer.toString(value);

        DaneBaza dane = new DaneBaza( iloscOdpowiedzi,iloscA,iloscB,iloscC,iloscD,iloscChorychCiesn,iloscChorychKanal,iloscChorychSpoj,iloscChorychQuer,iloscChorychZakleszcz,iloscBciesn,iloscBkanal,iloscBspoj,iloscBquer,iloscBzakleszcz);
        //Map<String, Object> postValues = dane.toMap();

        //Map<String, Object> chorobyUpdates = new HashMap<>();
        //chorobyUpdates.put( key, postValues);

            databaseChoroby.setValue(dane);
    }

    public void nastepne(View view){
        TextView tv = (TextView) findViewById(R.id.podpowiedz);
        boolean czyOdp = CzyWykonano();

        if(czyOdp) {
            tv.setVisibility(View.INVISIBLE);
            zapiszWynik();
            czyChory();
            ileOdpowiedzi();
            ileChorych();
            wplywChory();
            addToDatabase();
        if((value+1) > Dane.pytania.size()){

            Intent intent = new Intent (this,MenuActivity.class);
            startActivity(intent);
        }
        else{
            value += 1;
            Intent intent = new Intent(this, AnkietaActivity.class);
            intent.putExtra("nrPytania", value);
            startActivity(intent);

        }}else{
            tv.setVisibility(View.VISIBLE);
        }

    }

}
