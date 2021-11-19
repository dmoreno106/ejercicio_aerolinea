package org.izv.dmc.ejercicioaerolnea;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import java.nio.charset.StandardCharsets;

public class VentaBilletes extends AppCompatActivity {
    TextView tvPrecio;
    Button btCancelar,btConfirmar;
    Bundle bundle;
    private Activity activity;
    //para la semilla-> Granada-Madrid 15 11 2021
    //usar codigo Asci de cada letra
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.venta_activity);

        activity=this;
        tvPrecio=findViewById(R.id.tvPrecio);
        btCancelar=findViewById(R.id.btCancelar);
        btConfirmar=findViewById(R.id.btConfirmar);
         bundle=getIntent().getBundleExtra("bundle");

         btCancelar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 finish();
             }
         });


    btConfirmar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            AlertaDialogo dialogBuy = new AlertaDialogo();

            Intent intent=new Intent(activity,FacturaActivity.class);
            intent.putExtra("bundle",bundle);
            startActivity(intent);




        }
    });


    operacion(gastos());
    }
    public  int[] gastos(){
        int[] gastos=new int[8];
        gastos[0]=creaSemilla(bundle.getString("origen"));
        gastos[1]=creaSemilla(bundle.getString("destino"));
        gastos[2]=bundle.getInt("primeraClase");
        gastos[3]=bundle.getInt("mascota");
        gastos[4]=bundle.getInt("ventana");
        gastos[5]=bundle.getInt("movilidadReducida");
        gastos[6]=bundle.getInt("seguroAdicional");
        gastos[7]=bundle.getInt("viajePremium");
        return  gastos;
    }
    public  void operacion(int[] gastos){
        int total=0;

        for (int gasto:gastos) {

            total+=gasto;

        }
        tvPrecio.setText("PRECIO TOTAL: "+total);
    }



    public int creaSemilla(String cad){
         cad=cad.toLowerCase();
        int seed=0;

       for (int i=0;i<cad.length();i++){
           seed+=cad.getBytes(StandardCharsets.UTF_8)[i];
       }
       seed=seed/10;
        return seed;
    }
}
