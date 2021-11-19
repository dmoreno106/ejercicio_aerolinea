package org.izv.dmc.ejercicioaerolnea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FacturaActivity extends AppCompatActivity {
private TextView tvFactura;
private Button btInicio;
private  Bundle bundle;
private Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);
        activity=this;
        bundle=getIntent().getBundleExtra("bundle");
        tvFactura=findViewById(R.id.tvFactura);
        btInicio=findViewById(R.id.btAtras);


        String factura="----FACTURA---- " +
                " \nnombre: "+bundle.getString("nombre")+
                " \napellido: "+bundle.getString("apellidos")+
                " \norigen: "+bundle.getString("origen")+
                " \ndestino: "+bundle.getString("destino")+
                " \nemail: "+bundle.getString("email")+
                " \ndireccion: "+bundle.getString("dieccion")+
                " \ntelefono: "+bundle.getString("telefono")+"\n"+
                bundle.getString("extra");

        Log.v("xyzyx",factura);

        tvFactura.setText(factura);

        btInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                AlertaDialogo dialogBuy = new AlertaDialogo();




                dialogBuy.show(fragmentManager, "Dialog Alert");
            }
        });
    }
}