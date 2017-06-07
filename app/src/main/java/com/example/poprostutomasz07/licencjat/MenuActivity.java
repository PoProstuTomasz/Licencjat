package com.example.poprostutomasz07.licencjat;

import android.content.Intent;
import android.net.sip.SipAudioCall;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.thoughtworks.xstream.XStream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import Structure.Dane;
import Structure.DaneBaza;
import Structure.Statystyki;
import Structure.StrukturPytania;

import static Structure.Dane.pytania;

public class MenuActivity extends AppCompatActivity {

    private DatabaseReference postReference;
    private ValueEventListener mPostListener;
    private String mKey;

    private static final String TAG = "DaneBaza";

    public static final String EXTRA_POST_KEY = "danebaza_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().hide();
        pytania = new ArrayList<>();
        InputStream inputStream = this.getResources().openRawResource(R.raw.pytaniaandroid);

       // postKey = getIntent().getStringExtra(EXTRA_POST_KEY);
        mKey = getIntent().getStringExtra(Intent.EXTRA_KEY_EVENT);
        postReference = FirebaseDatabase.getInstance().getReference().child("choroby");

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();
             String readLine = null;
                while ((readLine = br.readLine()) != null) {
               builder.append(readLine);
            }
            String doc = builder.toString();
            XStream xstream = new XStream();
            xstream.alias("StrukturPytania", StrukturPytania.class);
            xstream.alias("entries", List.class);
            pytania = (ArrayList<StrukturPytania>) xstream.fromXML(doc);

            if(Dane.pytania!=null){
                if(Dane.odpowiedzi==null)
                {
                    Dane.odpowiedzi = new ArrayList<>();
                    for(int i=0; i<Dane.pytania.size(); i++){
                        Statystyki statystyki = new Statystyki(i);
                        statystyki.setPytanie(Dane.pytania.get(i).getPytanie());
                        statystyki.setIloscodp(Dane.pytania.get(i).getOdp().getIloscOdp());
                        Dane.odpowiedzi.add(i,statystyki);

                    }
                }
            }

            inputStream.close();

        } catch(FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku xml");
            e.printStackTrace();
        }  catch(IOException e) {
            System.out.println("Błąd!!!!");
            e.printStackTrace();
        }}


      /*  postReference.addChildEventListener(new ChildEventListener(){
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                postReference = FirebaseDatabase.getInstance().getReference().child("choroby").child("1").child("iloscA");
                Statystyki statystyki = new Statystyki(1);
                Integer daneBaza = dataSnapshot.getValue(Integer.class);
                statystyki.setIloscA(daneBaza);
                Dane.danebazowe.add(daneBaza);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }*/




  /*  @Override
    public void onStart(){
        super.onStart();

        ValueEventListener daneListener = new ValueEventListener() {
            //databaseChoroby.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                DaneBaza dane = dataSnapshot.getValue(DaneBaza.class);
                dane.getIloscA();
                //for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {

                    //Dane.odpowiedzi.add(Integer.parseInt(postSnapshot.getKey(), );
                //}
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                //Toast.makeText(MenuActivity.this, "Failed to load post.",
                // Toast.LENGTH_SHORT).show();
            }
        };
        postReference.addValueEventListener(daneListener);
        //databaseChoroby.addListenerForSingleValueEvent(daneListener);
    }*/





   /* @Override
    public void onStart(){
        super.onStart();

        ValueEventListener daneListener = new ValueEventListener() {
        //postReference.addValueEventListener(new ValueEventListener() {
            @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                DaneBaza dane = dataSnapshot.getValue(DaneBaza.class);
                    //Statystyki statystyki = new Statystyki(1);
                    //statystyki.setIloscA(dane.getIloscA());
                   // statystyki.setIloscB(dane.getIloscB());
                    //statystyki.setIloscC(dane.getIloscC());
                   // statystyki.setIloscD(dane.getIloscD());
                   // statystyki.setIloscOdpowiedzi(dane.getIloscOdpowiedzi());
                   // Dane.odpowiedzi.add(1,statystyki);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                 Toast.makeText(MenuActivity.this, "Failed to load post.",
                         Toast.LENGTH_SHORT).show();
           }
        };
        postReference.addValueEventListener(daneListener);
       // postReference.addListenerForSingleValueEvent(daneListener);
        }*/

    public void gotoAutor(View view) {
        Intent intent = new Intent (this, AutorActivity.class);
        startActivity(intent);
    }
    public void goToAplikacja(View view) {
        Intent intent = new Intent(this, AplikacjaActivity.class);
        startActivity(intent);
    }

    public void goToAnkieta(View view) {
        Intent intent = new Intent (this, AnkietaActivity.class);
        intent.putExtra("nrPytania",1);
        startActivity(intent);
    }

    public void goToStatystyki(View view) {
        Intent intent = new Intent(this, StatystykiActivity.class);
        startActivity(intent);
    }
}
