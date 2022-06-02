package com.example.controle2mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AjouterEntreprise extends AppCompatActivity {

    EditText ers,eads,ecpt;
    Button btne,btna;
    MyDatabaseEntreprise dbe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_entreprise);

        dbe=new MyDatabaseEntreprise(this);
        setContentView(R.layout.activity_ajouter_entreprise);
        ers=findViewById(R.id.txtrc);
        eads=findViewById(R.id.txtads);
        ecpt=findViewById(R.id.txtcpt);
        btna=findViewById(R.id.btna);
        btne=findViewById(R.id.btne);
    }

    public void annuler(View view) {
        finish();
    }

    public void enregiste(View view) {

        if(ers.getText().toString().isEmpty()){
            Toast.makeText(this, "Raison_Sociale vide", Toast.LENGTH_SHORT).show();
            ers.requestFocus();
            return;
        }
        if(eads.getText().toString().isEmpty()){
            Toast.makeText(this, "adress vide", Toast.LENGTH_SHORT).show();
            eads.requestFocus();
            return;
        }
        if(ecpt.getText().toString().isEmpty()){
            Toast.makeText(this, "Capitale vide", Toast.LENGTH_SHORT).show();
            ecpt.requestFocus();
            return;
        }

        Entreprise e = new Entreprise();
        e.setId(1);
        e.setRaisonSociale(ers.getText().toString());
        e.setAdresse(eads.getText().toString());
        e.setCapitale(Double.parseDouble(ecpt.getText().toString()));


        if (MyDatabaseEntreprise.Add_Entreprise(dbe.getWritableDatabase(), e) == -1)
            Toast.makeText(this, "insertion echoue", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "insertion reussie", Toast.LENGTH_SHORT).show();

    }
}