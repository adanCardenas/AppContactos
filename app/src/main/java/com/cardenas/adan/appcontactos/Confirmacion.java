package com.cardenas.adan.appcontactos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.cardenas.adan.appcontactos.model.Contacto;

public class Confirmacion extends AppCompatActivity {

    private Contacto contacto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);
        Log.i("e","Dentro de la clase Confirmacion");

        Bundle parametros = getIntent().getExtras();
        String nombreInput              = parametros.get(getResources().getString(R.string.Formulario_Nombre)).toString();
        String fechaNacimientoInput     = parametros.get(getResources().getString(R.string.Formulario_FechaNacimiento)).toString();
        String telefonoInput            = parametros.get(getResources().getString(R.string.Formulario_Telefono)).toString();
        String correoElectronicoInput   = parametros.get(getResources().getString(R.string.Formulario_CorreoElectronico)).toString();
        String descripcionInput         = parametros.get(getResources().getString(R.string.Formulario_Descripcion)).toString();

        TextView nombre                 = (TextView) findViewById(R.id.S2_TextView_Nombre);
        TextView fechaNacimiento        = (TextView) findViewById(R.id.S2_TextView_FechaNacimiento);
        TextView telefono               = (TextView) findViewById(R.id.S2_TextView_Telefono);
        TextView correoElectronico      = (TextView) findViewById(R.id.S2_TextView_CorreoElectronico);
        TextView descripcion            = (TextView) findViewById(R.id.S2_TextView_Descripcion);

        Button botonEditar              = (Button) findViewById(R.id.S2_Button_Editar);

        Log.i("e","Nombre Completo: "+nombreInput+"\n"//
                + "Fecha de nacimiento: "+fechaNacimientoInput+"\n"//
                + "Telefono: "+telefonoInput+"\n"//
                + "Correo Electronico: "+correoElectronicoInput+"\n"//
                + "Descripción: "+descripcionInput+"\n"
        );
        nombre.setText(nombreInput);
        fechaNacimiento.setText(fechaNacimientoInput);
        telefono.setText(telefonoInput);
        correoElectronico.setText(correoElectronicoInput);
        descripcion.setText(descripcionInput);

        botonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
}
