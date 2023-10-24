package com.example.first_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public TextView remainingTriesTextView;
    public Button mybutton;
    public EditText myuser;
    public EditText mypassword;
    public int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialisation des composants
        remainingTriesTextView = findViewById(R.id.remainingTriesTextView);
        mybutton = findViewById(R.id.myButton);
        myuser = findViewById(R.id.editlogin);
        mypassword = findViewById(R.id.editpasse);

        // Définition du gestionnaire de clic pour le bouton
        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Vérification des champs vides
                if (myuser.getText().toString().isEmpty() || mypassword.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                } else {
                    // Vérification de l'authentification
                    if (myuser.getText().toString().equals("admin") && mypassword.getText().toString().equals("admin")) {
                        Toast.makeText(MainActivity.this, "Connexion en cours..", Toast.LENGTH_SHORT).show();
                    } else {
                        counter--;
                        if (counter > 0) {
                            remainingTriesTextView.setVisibility(View.VISIBLE);
                            remainingTriesTextView.setText("Il vous reste " + counter + " tentation" + (counter > 1 ? "s" : ""));
                        } else {
                            remainingTriesTextView.setVisibility(View.INVISIBLE);
                            mybutton.setEnabled(false);
                            mypassword.setEnabled(false);
                            myuser.setEnabled(false);
                        }
                        Toast.makeText(MainActivity.this, "Username ou Mot de passe incorrect..", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}



