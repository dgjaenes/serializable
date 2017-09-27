package com.example.usuario.serializable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1= (Button)findViewById(R.id.boton1);
        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try(FileOutputStream out= this.openFileOutput("Usuario.dat", this.MODE_PRIVATE); ObjectOutputStream file= new ObjectOutputStream(out)) {


            EditText editname=(EditText)findViewById(R.id.text1);
            EditText editsurname=(EditText)findViewById(R.id.text2);

            Usuario user= new Usuario(editname.getText().toString(),editsurname.getText().toString());

            file.writeObject(user);
            Intent intent= new Intent(this, Destino.class);
            startActivity(intent);


        } catch (FileNotFoundException e) {
            Toast.makeText(this, "El fichero no existe", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(this, "Ha falado el ....", Toast.LENGTH_LONG).show();
        }
    }
}
