package com.example.juanita.juanitahoyosejs4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edt_num;
    EditText edt_name;
    String genero;
    Button btn_add;
    Switch sw_genero;
    ImageView img_genero;

    ListView lv_contactos;
    ContactoAdapter customAdapter;
    Boolean estadoSwitch;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_name = findViewById(R.id.edt_name);
        edt_num = findViewById(R.id.edt_num);
        sw_genero = findViewById(R.id.sw_genero);
        btn_add = findViewById(R.id.btn_add);
        img_genero = findViewById(R.id.img_genero);

        lv_contactos = findViewById(R.id.lv_contactos);
        customAdapter = new ContactoAdapter(MainActivity.this);
        estadoSwitch = sw_genero.isChecked();
        lv_contactos.setAdapter(customAdapter);


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = edt_name.getText().toString();

                String numero = edt_num.getText().toString();


                if (estadoSwitch = true) {
                    genero = "mujer";
                } else {
                    genero = "hombre";
                }


                Contacto newContacto = new Contacto(nombre, numero, genero);
                customAdapter.agregarContacto(newContacto);


            }
        });
    }
}
