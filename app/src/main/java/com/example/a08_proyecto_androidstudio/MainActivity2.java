package com.example.a08_proyecto_androidstudio;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText nombre;
    Button ñ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        nombre = findViewById(R.id.editTextnombre);
        ñ = findViewById(R.id.buttonEnviar);
        String t=getIntent().getStringExtra("saludodevuelta");
        Toast.makeText(getApplicationContext(), t, Toast.LENGTH_SHORT).show();

    }

    public void cambiarventana(View vista){

        Intent intent=new Intent(this, MainActivity.class);
        intent.putExtra("nombre",nombre.getText().toString());
        startForResult.launch(intent);

    }


        ActivityResultLauncher<Intent> startForResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                        startForResult.launch(intent);
                    }
                });


}