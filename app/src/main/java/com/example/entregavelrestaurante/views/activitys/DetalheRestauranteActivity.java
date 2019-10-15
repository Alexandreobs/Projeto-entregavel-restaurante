package com.example.entregavelrestaurante.views.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.entregavelrestaurante.R;

import com.example.entregavelrestaurante.adapter.PratoAdapter;
import com.example.entregavelrestaurante.interfaces.RecyleOnClickPrato;
import com.example.entregavelrestaurante.model.Prato;
import com.example.entregavelrestaurante.model.RestauranteModelo;

import java.util.ArrayList;
import java.util.List;


public class DetalheRestauranteActivity extends AppCompatActivity implements RecyleOnClickPrato {
    private ImageView logoRestaurante;
    private TextView nomeRestaurante;

    private RecyclerView recyclerView;
    private PratoAdapter pratoAdapter;
    List<Prato> prat = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_restaurante);
        getSupportActionBar().hide();

        recyclerView = findViewById(R.id.recyclerViewRestaurante);

        pratoAdapter = new PratoAdapter(lisPratos(),  this);

        recyclerView.setAdapter(pratoAdapter);

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));


        initViews();

        if (getIntent() != null && getIntent().getExtras() != null) {
            RestauranteModelo restauranteModelo = getIntent().getExtras().getParcelable("RESTAURANTE");
            Drawable drawable = getResources().getDrawable(restauranteModelo.getFotoRest());
                logoRestaurante.setImageDrawable(drawable);
                nomeRestaurante.setText(restauranteModelo.getNomeRest());
        }

    }


    private void initViews() {
        logoRestaurante = findViewById(R.id.imageViewRestaurante);
        nomeRestaurante = findViewById(R.id.textViewRestaurante);
    }

    public List<Prato> lisPratos(){



        prat.add(new Prato("Hamburger",R.drawable.hamburger));
        prat.add(new Prato("Sobre Mesa",R.drawable.sobremesa));
        prat.add(new Prato("Hamburger",R.drawable.hamburger));
        prat.add(new Prato("Contra file",R.drawable.pratocomida));
        prat.add(new Prato("Hamburger",R.drawable.hamburger));
        prat.add(new Prato("Contra File",R.drawable.pratocomida));
        prat.add(new Prato("Sobre Mesa",R.drawable.sobremesa));
        prat.add(new Prato("Contra file",R.drawable.pratocomida));
        prat.add(new Prato("Hamburger",R.drawable.hamburger));
        prat.add(new Prato("Contra file",R.drawable.pratocomida));
        prat.add(new Prato("Sobre Mesa",R.drawable.sobremesa));
        prat.add(new Prato("Contra file",R.drawable.pratocomida));
        prat.add(new Prato("Sobre Mesa",R.drawable.sobremesa));
        prat.add(new Prato("Hamburger",R.drawable.hamburger));
        prat.add(new Prato("Sobre Mesa",R.drawable.sobremesa));
        prat.add(new Prato("Hamburger",R.drawable.hamburger));

        return prat;
    }


    @Override
    public void onClickDois(Prato prato) {
        Intent intent = new Intent (DetalheRestauranteActivity.this, DetalhePratoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("RESTAURANTE", prato);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}

