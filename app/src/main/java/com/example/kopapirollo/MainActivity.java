package com.example.kopapirollo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button ko,ollo,papir;
    ImageView jatekos,gep,gepElet1,gepElet2,gepElet3,jatekosElet1,jatekosElet2,jatekosElet3;
    TextView dontetlen;
    Random r = new Random();
    int teValaszod,dontetlenMero,gepValasza,gepEletero,jatekosEletero;
    private Object String;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        ko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jatekos.setImageResource(R.drawable.rock);
                teValaszod =1;
                valasz();
            }
        });
        papir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jatekos.setImageResource(R.drawable.paper);
                teValaszod =2;
                valasz();
            }
        });
        ollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jatekos.setImageResource(R.drawable.scissors);
                teValaszod =3;
                valasz();
            }
        });
    }

    private void init(){
        gepElet1 = findViewById(R.id.gepElet1);
        gepElet2 = findViewById(R.id.gepElet2);
        gepElet3 = findViewById(R.id.gepElet3);

        jatekosElet3 = findViewById(R.id.jatekosElet3);
        jatekosElet2 = findViewById(R.id.jatekosElet2);
        jatekosElet1 = findViewById(R.id.jatekosElet1);

        dontetlen = findViewById(R.id.dontetlenKorok);

        gep = findViewById(R.id.gepJele);

        jatekos = findViewById(R.id.jatekosJele);

        ko = findViewById(R.id.ko);
        papir = findViewById(R.id.papir);
        ollo = findViewById(R.id.ollo);

        gepEletero = 3;
        jatekosEletero =3;
    }


    private void valasz(){
        gepValasza = r.nextInt(3)+1;
        switch (gepValasza){
            case 1: gep.setImageResource(R.drawable.rock); break;
            case 2: gep.setImageResource(R.drawable.paper); break;
            case 3: gep.setImageResource(R.drawable.scissors); break;
        }

       if (teValaszod == gepValasza){
           dontetlenMero++;
           dontetlen.setText("Döntetlenek száma: "+dontetlenMero);
       }else if (teValaszod == 1 && gepValasza ==2){
            //gép
           jatekosEletero-=1;
           eleterok();
       } else  if(teValaszod == 1 && gepValasza ==3){
           //játékos
           gepEletero-=1;
           eleterok();
       } else if (teValaszod == 2 && gepValasza ==3){
           //gép
           jatekosEletero-=1;
           eleterok();
       } else  if(teValaszod == 2 && gepValasza ==1){
           //játékos
           gepEletero-=1;
           eleterok();
       }else if (teValaszod == 3 && gepValasza ==1){
           //gép
           jatekosEletero-=1;
           eleterok();
       } else  if(teValaszod == 3 && gepValasza ==2){
           //játékos
           gepEletero-=1;
           eleterok();
       }
    }


    private  void eleterok(){
        String nyertes = "";
        AlertDialog.Builder builder;

        builder = new AlertDialog.Builder(this);
        builder.setMessage(nyertes +"\nSzeretnéd ujrainditani a programot?")
                .setCancelable(false)
                .setPositiveButton("igen", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //reset();
                    }
                })
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });
        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle("AlertDialogExample");



        switch (jatekosEletero){
            case 2: jatekosElet3.setImageResource(R.drawable.heart1);break;
            case 1: jatekosElet2.setImageResource(R.drawable.heart1);break;
            case 0: jatekosElet1.setImageResource(R.drawable.heart1);break;
        }

        if (jatekosEletero == 0){
            alert.show();
        }

        switch (gepEletero) {
            case 2: gepElet3.setImageResource(R.drawable.heart1);break;
            case 1: gepElet2.setImageResource(R.drawable.heart1);break;
            case 0: gepElet1.setImageResource(R.drawable.heart1);break;
        }

        if (gepEletero == 0){
            alert.show();
        }
    }

    private  void reset(){
        gepElet3.setImageResource(R.drawable.heart2);
        gepElet2.setImageResource(R.drawable.heart2);
        gepElet1.setImageResource(R.drawable.heart2);

        jatekosElet3.setImageResource(R.drawable.heart2);
        jatekosElet2.setImageResource(R.drawable.heart2);
        jatekosElet1.setImageResource(R.drawable.heart2);

        dontetlen.setText("Döntetlenek száma: 0");

        dontetlenMero=0;

        gepEletero = 3;
        jatekosEletero =3;
    }
}
