package com.example.testoflagach;

import static android.view.View.INVISIBLE;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private int licznikklikniec = 0;
    private TextView textVievPytanie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textVievPytanie = findViewById(R.id.textVievPytanie);
    }

    public void prawdzOK(View view) {
        Toast.makeText(MainActivity.this, "ten kolor należy do flagi polski, nie klikaj go", Toast.LENGTH_SHORT).show();
    }

    public void prawdzUkr(View view) {
        view.setVisibility(INVISIBLE);
        licznikklikniec++;
        if(licznikklikniec == 4){
            // komunikat i zmiana wyglądu
            textVievPytanie.setText("Brawo,\n to jest flaga Polski!");
        }
    }
}