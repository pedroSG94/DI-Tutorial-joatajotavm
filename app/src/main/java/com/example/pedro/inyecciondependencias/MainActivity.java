package com.example.pedro.inyecciondependencias;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pedro.inyecciondependencias.di.App;
import com.example.pedro.inyecciondependencias.di.Empresa;
import com.example.pedro.inyecciondependencias.dijava.ConInyeccion;
import com.example.pedro.inyecciondependencias.dijava.Programador;
import com.example.pedro.inyecciondependencias.dijava.SinInyeccion;
import com.example.pedro.inyecciondependencias.otherviews.CustomAdapter;
import com.example.pedro.inyecciondependencias.otherviews.CustomDialog;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindColor;
import butterknife.BindDimen;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnLongClick;

public final class MainActivity extends AppCompatActivity{

    @BindView(R.id.button) protected Button button;
    @BindString(R.string.texto) String holaMundo;
    @BindString(R.string.texto2) String holaMundo2;
    @BindViews({R.id.button, R.id.button2, R.id.button3, R.id.button4})
    List<Button> buttons;
    @BindColor(R.color.yellow) int amarillo;
    @BindDimen(R.dimen.width_button) int dimen;
    @BindView(R.id.listView)
    ListView listView;
    @Named("jotajotavm") @Inject Programador programador;
    @Named("pedro") @Inject Programador programador2;
    @Named("none") @Inject Programador programador3;
    @Named("none") @Inject Programador programador4;
    @Inject Empresa empresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**indicar la activity que va a ser inyectada butter knife*/
        ButterKnife.bind(this);

        /**indicar la activity que va a ser inyectada dagger2*/
        ((App) getApplication()).getComponentTest().inject(this);

        ArrayList<String> list = new ArrayList<>();
        list.add("hola");
        list.add("jotajotavm");
        list.add("pedro");
        list.add("adios");

        buttons.get(0).setText("jotajotavm");
        buttons.get(3).setText(holaMundo);
        buttons.get(1).setBackgroundColor(amarillo);
        buttons.get(2).setWidth(dimen);
        CustomAdapter customAdapter = new CustomAdapter(this, R.layout.support_simple_spinner_dropdown_item, list);
        listView.setAdapter(customAdapter);

        /**ejemplo di en java*/
        ConInyeccion conInyeccion = new ConInyeccion(new Programador("jotajotavm"));
        SinInyeccion sinInyeccion = new SinInyeccion();
        ConInyeccion conInyeccion2 = new ConInyeccion(new Programador("pedro"));
    }

    @OnLongClick({R.id.button, R.id.button4, R.id.button2})
    public boolean onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                buttons.get(0).setBackgroundColor(amarillo);
                Toast.makeText(MainActivity.this, programador4.toString(), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.button2:
                CustomDialog dialog = new CustomDialog(MainActivity.this);
                dialog.show();
                return true;
            case R.id.button4:
                buttons.get(3).setText(holaMundo2);
                Toast.makeText(MainActivity.this, empresa.toString(), Toast.LENGTH_SHORT).show();
                return true;
            default:
                return true;
        }
    }
}
