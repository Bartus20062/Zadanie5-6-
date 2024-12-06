package com.example.sudety56;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
private Button polub;
private Button usun;
private Button zapisz;
private Button pokaz;
private EditText email;
private EditText haslo;
private EditText haslo2;
private TextView komunikat;
private int polubienia = 0;
private TextView likes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        polub = findViewById(R.id.button);
        usun = findViewById(R.id.button2);
        zapisz = findViewById(R.id.button3);
        pokaz = findViewById(R.id.button4);
        email = findViewById(R.id.email1);
        haslo = findViewById(R.id.haslo1);
        haslo2 = findViewById(R.id.haslo2);
        komunikat = findViewById(R.id.komunikat);
        likes = findViewById(R.id.likes);

        haslo.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        haslo2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        polub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                polubienia++;
                likes.setText(polubienia + "polubień");
            }
        });
        usun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(polubienia>0)
                polubienia--;
                likes.setText(polubienia + "polubień");
            }
        });
        zapisz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email1 = email.getText().toString().trim();
                String haslo1 = haslo.getText().toString().trim();
                String haslo3 = haslo2.getText().toString().trim();

                if(!email1.contains("@")){
                    komunikat.setText("Nieprawidłowy adres email!!");
                }
                else if(!haslo1.equals(haslo3)){
                    komunikat.setText("Hasła sie nie zgadzaja!!!");
                } else {
                komunikat.setText("Zarejestrowano "+ email1);
            }

        }});

    }
}