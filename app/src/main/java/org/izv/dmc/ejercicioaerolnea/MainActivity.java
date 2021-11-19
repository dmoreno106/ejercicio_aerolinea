package org.izv.dmc.ejercicioaerolnea;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import org.izv.dmc.ejercicioaerolnea.menu.AmigosDoc;
import org.izv.dmc.ejercicioaerolnea.menu.ConfiguracionPrivacidad;
import org.izv.dmc.ejercicioaerolnea.menu.MisViajes;
import org.izv.dmc.ejercicioaerolnea.menu.ValesRegalo;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    ImageButton btPremium,fechaSalida, fechaRegreso;
    Button btComprar;
    public Switch swMovilidad;
    EditText etOrigen, etDestino,etNombre,etApellido,etEmail,etDireccion,etTelefono;
    TextView tvFechaSalida,tvFechaRegreso;
    CheckBox cbPrimeraClase,cbMascota,cbVentana;
    Bundle bundle;
    RadioButton rbSi,rbNo;
    String extra ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bundle=new Bundle();

        btPremium = findViewById(R.id.ibPremium);
        btComprar = findViewById(R.id.btComprar);

        fechaSalida=findViewById(R.id.ibFechaSalida);
        fechaRegreso =findViewById(R.id.ibFechaRegreso);

        swMovilidad=findViewById(R.id.swMovilidad);

        etDestino =findViewById(R.id.etDestino);
        etOrigen =findViewById(R.id.etOrigen);
        etNombre=findViewById(R.id.etName);
        etApellido=findViewById(R.id.etApellidos);
        etEmail=findViewById(R.id.etEmail);
        etDireccion=findViewById(R.id.etDireccion);
        etTelefono=findViewById(R.id.etTelefono);

        tvFechaSalida=findViewById(R.id.tvFechaSalida);
        tvFechaRegreso=findViewById(R.id.tvFechaRegreso);

        rbSi=findViewById(R.id.rbSi);
        rbNo=findViewById(R.id.rbNo);

        cbPrimeraClase=findViewById(R.id.cbPrimeraClase);
        cbMascota=findViewById(R.id.cbMascota);
        cbVentana=findViewById(R.id.cbVentana);

        cbPrimeraClase.setOnCheckedChangeListener(this);
        cbMascota.setOnCheckedChangeListener(this);
        cbVentana.setOnCheckedChangeListener(this);

        fechaSalida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerFragment newFragment = new DatePickerFragment(tvFechaSalida);
                newFragment.show(getSupportFragmentManager(), "datepicker");
            }
        });
        fechaRegreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerFragment newFragment = new DatePickerFragment(tvFechaRegreso);
                newFragment.show(getSupportFragmentManager(), "datepicker");
            }
        });




        btPremium.setOnClickListener(view -> {
            if(etOrigen.getText().toString().isEmpty()|| etDestino.getText().toString().isEmpty()){
                Toast toastMessage =
                        Toast.makeText(getApplicationContext(),
                                "Error al comprar billete los campos Origen y Destino son obligatorios", Toast.LENGTH_SHORT);


                etOrigen.setBackgroundResource(R.drawable.shape2);
                etDestino.setBackgroundResource(R.drawable.shape2);
                toastMessage.show();
            }else {
                bundle.putInt("viajePremium",40);
                extra=extra+" Viaje Premium : Si \n";
                iniciaCompra();
            }


        });

        btComprar.setOnClickListener(view -> {
            if(etOrigen.getText().toString().isEmpty()|| etDestino.getText().toString().isEmpty()){
                Toast toastMessage =
                        Toast.makeText(getApplicationContext(),
                                "Error al comprar billete los campos Origen y Destino son obligatorios", Toast.LENGTH_SHORT);


                etOrigen.setBackgroundResource(R.drawable.shape2);
                etDestino.setBackgroundResource(R.drawable.shape2);
                toastMessage.show();
            }else {
                bundle.putInt("viajePremium",0);
                extra=extra+" Viaje Premium : No \n";
                iniciaCompra();
            }
        });

        if(swMovilidad.isActivated()){
            bundle.putInt("movilidad",40);
            extra=extra+" Movilidad Reducida: Si \n";
        }else{
            bundle.putInt("movilidad",0);
            extra=extra+" Movilidad Reducida: No \n";
        }


        rbSi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putInt("seguroAdicional",30);

                Snackbar snackbar= Snackbar.make(view,"Seguro adicional activado", Snackbar.LENGTH_SHORT);
                snackbar.setAction("Deshacer", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        rbNo.setChecked(true);
                        bundle.putInt("movilidad",0);
                    }
                });
                snackbar.show();
            }
        });

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.viajes) {
            Intent intent=new Intent(this, MisViajes.class);
            this.startActivity(intent);

            return true;
        }
        if(id==R.id.compañerosViaje){
            Intent intent=new Intent(this, AmigosDoc.class);
            this.startActivity(intent);
        }
        if(id==R.id.valesRegalo){
            Intent intent=new Intent(this, ValesRegalo.class);
            this.startActivity(intent);
        }
        if(id==R.id.configuracionPrivacidad){
            Intent intent=new Intent(this, ConfiguracionPrivacidad.class);
            this.startActivity(intent);
        }
        if(id==R.id.compañerosViaje){
            Intent intent=new Intent(this, AmigosDoc.class);
            this.startActivity(intent);
        }
        if(id==R.id.compañerosViaje){
            Intent intent=new Intent(this, AmigosDoc.class);
            this.startActivity(intent);
        }
        if(id==R.id.compañerosViaje){
            Intent intent=new Intent(this, AmigosDoc.class);
            this.startActivity(intent);
        }
        if(id==R.id.compañerosViaje){
            Intent intent=new Intent(this, AmigosDoc.class);
            this.startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    private void iniciaCompra() {

        String origen=String.valueOf(etOrigen.getText());
        String destino=String.valueOf(etDestino.getText());
        String nombre=String.valueOf(etNombre.getText());
        String apellidos=String.valueOf(etApellido.getText());
        String email=String.valueOf(etEmail.getText());
        String direccion=String.valueOf(etDireccion.getText());
        String telefono=String.valueOf(etTelefono.getText());
        String fechaSalida=String.valueOf(tvFechaSalida.getText());
        String fechaRegreso=String.valueOf(tvFechaRegreso.getText());

        bundle.putString("origen",origen);
        bundle.putString("destino",destino);
        bundle.putString("nombre",nombre);
        bundle.putString("apellidos",apellidos);
        bundle.putString("email",email);
        bundle.putString("direccion",direccion);
        bundle.putString("telefono",telefono);
        bundle.putString("fechasalida",fechaSalida);
        bundle.putString("fecharegreso",fechaRegreso);
        bundle.putString("extra",extra);



        Intent intent=new Intent(this,VentaBilletes.class);
        intent.putExtra("bundle",bundle);
        this.startActivity(intent);
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        switch (compoundButton.getId()){
            case R.id.cbPrimeraClase:
                if(isChecked){
                    bundle.putInt("primeraClase",50);
                    extra=extra+" primera clase: Si \n";
                }else{
                    bundle.putInt("primeraClase",0);
                    extra=extra+" primera clase: No \n";
                }
                break;
            case R.id.cbMascota:
                if(isChecked){
                    bundle.putInt("mascota",50);
                    extra=extra+" mascota: Si \n";
                }else{
                    bundle.putInt("mascota",0);
                    extra=extra+" mascota: No \n";
                }
                break;
            case R.id.cbVentana:
                if(isChecked){
                    bundle.putInt("ventana",50);
                    extra=extra+" Ventana: Si \n";
                }else{
                    bundle.putInt("ventana",0);
                    extra=extra+" Ventana: No \n";
                }
        }
    }
}

