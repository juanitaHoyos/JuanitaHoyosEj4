package com.example.juanita.juanitahoyosejs4;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactoAdapter extends BaseAdapter {
    ArrayList<Contacto> contactos;
    Activity activity;

    public ContactoAdapter(Activity activity){
        this.activity = activity;
        contactos= new ArrayList<>();

    }


    @Override
    public int getCount() {
        return contactos.size();
    }

    @Override
    public Object getItem(int i) {
        return contactos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= activity.getLayoutInflater();


        View renglon=inflater.inflate(R.layout.renglon, null,false);
        final ImageView img_genero=renglon.findViewById(R.id.img_genero);
        TextView tv_nombre=renglon.findViewById(R.id.tv_nombre);
        final TextView tv_num=renglon.findViewById(R.id.tv_numero);

        ImageButton btn_llamar= renglon.findViewById(R.id.btn_llamar);
        ImageButton btn_eliminar= renglon.findViewById(R.id.btn_eliminar);

        tv_nombre.setText(contactos.get(position).getNombre());
        tv_num.setText(contactos.get(position).getNumero());
        String gener=contactos.get(position).getGenero();

        if(gener.equals("mujer")){
            img_genero.setImageResource(R.drawable.she);

        }else {

            img_genero.setImageResource(R.drawable.he);
        }




        btn_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contactos.remove(position);
                notifyDataSetChanged();


            }
        });


        btn_llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final int Request_phone_call= 1;
                String celular= tv_num.getText().toString();
                Intent llamar = new Intent(Intent.ACTION_CALL);
                llamar.setData(Uri.parse("tel:"+celular));

                if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                    if(ContextCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CALL_PHONE}, Request_phone_call);
                    }else{
                        activity.startActivity(llamar);
                    }
                }


            }
        });
        return renglon;
    }

    public void agregarContacto(Contacto contacto){

        contactos.add(contacto);

        //ACTUALIZA
        notifyDataSetChanged();

    }
}
