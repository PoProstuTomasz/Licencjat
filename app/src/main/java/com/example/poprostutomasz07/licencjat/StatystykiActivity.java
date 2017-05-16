package com.example.poprostutomasz07.licencjat;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import Structure.Dane;
import Structure.DaneBaza;
import Structure.Statystyki;

public class StatystykiActivity extends AppCompatActivity {

    private DatabaseReference postReference;
    private ArrayList<DaneBaza> mChoroby = new ArrayList<>();
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_statystyki);
        final int[] a = new int[1];

        postReference = FirebaseDatabase.getInstance().getReference().child("choroby");
       // mListView = (ListView) findViewById(R.id.listView);
       // final ArrayAdapter<DaneBaza> arrayAdapter = new ArrayAdapter<DaneBaza>(this,android.R.layout.simple_list_item_1,mChoroby);
        //mListView.setAdapter(arrayAdapter);
        //CzytaniezBazy();
        postReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                DaneBaza daneBaza = dataSnapshot.getValue(DaneBaza.class);
                a[0] = daneBaza.getIloscA();
                mChoroby.add(daneBaza);
               // arrayAdapter.notifyDataSetChanged();
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

        RadioGroup radio = new RadioGroup(this);

        FrameLayout item = (FrameLayout) this.findViewById(R.id.framelayoutstat);
        item.removeAllViews();

        TextView iloscAnkietowanych = (TextView) this.findViewById(R.id.testowy);
        iloscAnkietowanych.setText("Ankietowanych: " + Dane.odpowiedzi.get(0).getIloscOdpowiedzi());

        TextView iloscAnkietowanych3 = (TextView) this.findViewById(R.id.testowy2);
        iloscAnkietowanych3.setText("z bazy: " + a);


        TextView pytanie;
        TextView pytanieHeader;
        for (int i = 0; i < Dane.pytania.size(); i++) {
            pytanieHeader = new TextView(this);
            pytanie = new TextView(this);
            pytanieHeader.setText(Dane.odpowiedzi.get(i).getPytanie());
            pytanieHeader.setBackgroundColor(Color.parseColor("#0060a3"));
            pytanie.setText(Dane.odpowiedzi.get(i).toString());
            radio.addView(pytanieHeader);
            radio.addView(pytanie);
        }
        item.addView(radio);

    }




}
