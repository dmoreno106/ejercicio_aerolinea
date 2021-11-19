package org.izv.dmc.ejercicioaerolnea;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;


import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;


public class AlertaDialogo extends DialogFragment {
private Activity activity;
Bundle bundle;
    public Dialog onCreateDialog(  Bundle savedInstance) {

        activity.getCallingActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
       // LayoutInflater intflater=getActivity().getLayoutInflater();
        builder.setTitle("Confirmar Reserva");
        builder.setMessage("Está a punto de Comprar el billete")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {


                        Intent intent=new Intent(activity,MainActivity.class);

                        startActivity(intent);
                        ;
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }

        });
        return builder.create();

    }

}
