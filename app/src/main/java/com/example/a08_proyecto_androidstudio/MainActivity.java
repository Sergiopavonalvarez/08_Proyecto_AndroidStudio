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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox dias;
    CheckBox tardes;
    CheckBox noches;
    RadioGroup radioGroup;
    RadioButton sr;
    RadioButton sra;
    RadioButton nm;
    EditText nombre;
    Button p;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dias=findViewById(R.id.checkBox_buenosdias);
        tardes=findViewById(R.id.checkBox_buenastardes);
        noches=findViewById(R.id.checkBox_buenasnoches);
        radioGroup=findViewById(R.id.radiogroup);
        sr=findViewById(R.id.radioButton_señor);
        sra=findViewById(R.id.radioButtonseñora);
        nm=findViewById(R.id.radioButtonna);
        nombre=findViewById(R.id.nombre);
        String nombre1=getIntent().getStringExtra("nombre");
        nombre.setText(nombre1);
        p=findViewById(R.id.button);



    }

    public void l(View vista){
        String saludo="";


        if(dias.isChecked()){
            saludo += "Buenos dias,";
        }if(tardes.isChecked()){
            saludo +=" buenas tardes, ";
        }if(noches.isChecked()){
            saludo +="buenas noches ";
        }if(p.isClickable()){
            String saludocompleto=saludo+obtenerNombre()+nombre.getText().toString();
            Intent intent=new Intent(this, MainActivity2.class);
            intent.putExtra("saludodevuelta",saludocompleto);
            startForResult.launch(intent);
            finish();

        }

    }

    public String obtenerNombre() {

        if (radioGroup.getCheckedRadioButtonId() != -1) {
            // Al menos un RadioButton está seleccionado
            RadioButton radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
            String textoSeleccionado = radioButton.getText().toString();
            return textoSeleccionado;
        } else {
            // Ningún RadioButton está seleccionado, maneja esto según tus necesidades
            return "";
        }
    }

    ActivityResultLauncher<Intent> startForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startForResult.launch(intent);
                }
            });
}