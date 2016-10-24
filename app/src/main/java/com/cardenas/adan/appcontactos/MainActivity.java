package com.cardenas.adan.appcontactos;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.cardenas.adan.appcontactos.model.Contacto;

public class MainActivity extends AppCompatActivity {
    private String formatoFechaEstandar = "dd/MM/yyyy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextInputEditText nombreCompleto      = (TextInputEditText)findViewById(R.id.S1_TextInputEditText_Nombre);
        final DatePicker fechaNacimiento            = (DatePicker) findViewById(R.id.S1_DatePicker_FechaNacimiento);
        final TextInputEditText telefono            = (TextInputEditText)findViewById(R.id.S1_TextInputEditText_Telefono);
        final TextInputEditText correoElectronico   = (TextInputEditText) findViewById(R.id.S1_TextInputEditText_CorreoElectronico);
        final TextInputEditText descripcion         = (TextInputEditText) findViewById(R.id.S1_TextInputEditText_Descripcion);

        final Button botonSiguiente = (Button)findViewById(R.id.S1_Button_Siguiente);

        botonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contacto contacto=new Contacto();
                contacto.setNombreCompleto(nombreCompleto.getText().toString());
                contacto.setFechaNacimeinto(parseFechaTexto(fechaNacimiento.getDayOfMonth(),fechaNacimiento.getMonth(),fechaNacimiento.getYear(),formatoFechaEstandar));
                contacto.setFechaNacimientoDate(parseFecha(fechaNacimiento.getDayOfMonth(),fechaNacimiento.getMonth(),fechaNacimiento.getYear()));
                contacto.setTelefono(telefono.getText().toString());
                contacto.setEmail(correoElectronico.getText().toString());
                contacto.setDescripción(descripcion.getText().toString());
                Log.i("e","Nombre Completo: "+contacto.getNombreCompleto()+"\n"//
                        + "Fecha de nacimiento: "+contacto.getFechaNacimeinto().toString()+"\n"//
                        + "Telefono: "+contacto.getTelefono().toString()+"\n"//
                        + "Correo Electronico: "+contacto.getEmail()+"\n"//
                        + "Descripción: "+contacto.getDescripción()+"\n"
                );
                Intent intent=new Intent(MainActivity.this,Confirmacion.class);
                intent.putExtra(getResources().getString(R.string.Formulario_Nombre),contacto.getNombreCompleto());
                intent.putExtra(getResources().getString(R.string.Formulario_FechaNacimiento),contacto.getFechaNacimeinto());
                intent.putExtra(getResources().getString(R.string.Formulario_Telefono),contacto.getTelefono());
                intent.putExtra(getResources().getString(R.string.Formulario_CorreoElectronico),contacto.getEmail());
                intent.putExtra(getResources().getString(R.string.Formulario_Descripcion),contacto.getDescripción());
                startActivity(intent);
            }
        });
    }

    Date parseFecha(int dia, int mes, int anio)
    {
        Calendar calendario = Calendar.getInstance();
        calendario.set(Calendar.YEAR, anio);
        calendario.set(Calendar.MONTH, mes);
        calendario.set(Calendar.DAY_OF_MONTH, dia);
        return calendario.getTime();
    }

    String parseFechaTexto(int dia, int mes,int anio,String formatoFecha){
        Date fecha;
        DateFormat formateador = new SimpleDateFormat(formatoFecha);
        Calendar calendario = Calendar.getInstance();
        calendario.set(Calendar.YEAR, anio);
        calendario.set(Calendar.MONTH, mes);
        calendario.set(Calendar.DAY_OF_MONTH, dia);
        fecha=calendario.getTime();
        return formateador.format(fecha);
    }
}
