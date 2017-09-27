package com.example.usuario.serializable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Destino extends AppCompatActivity {

    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destino);

        ObjectInputStream item= null;
        try {
            FileInputStream in= openFileInput("Usuario.dat");
            item = new ObjectInputStream(in);
            usuario = (Usuario)item.readObject();
            TextView vtext=(TextView)findViewById(R.id.name);
            vtext.setText(usuario.getNombre()+" "+usuario.getApellido());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if (item!=null){
                    item.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
