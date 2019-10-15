package com.example.entregavelrestaurante.views.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.entregavelrestaurante.R;
import com.example.entregavelrestaurante.adapter.RestauranteAdapter;
import com.example.entregavelrestaurante.interfaces.RecycleOnClick;
import com.example.entregavelrestaurante.model.RestauranteModelo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecycleOnClick {
    private RecyclerView recyclerView;
    private RestauranteAdapter adapter;
    private List<RestauranteModelo> modeloList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewInicial);

        adapter = new RestauranteAdapter(lisRestaurantes(), this);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public List<RestauranteModelo>lisRestaurantes(){

        modeloList.add(new RestauranteModelo("La Cascada Steake House","Av. Lavandisca, 717 - Indianópolis, São Paulo","Fecha às 22:00",R.drawable.restquatro));
        modeloList.add(new RestauranteModelo("Toscana Restaurant","Av. Ibirapuera, 17 - moema, São Paulo","Fecha às 23:00",R.drawable.restdois));
        modeloList.add(new RestauranteModelo("Restaurante requinte","Av. Paulista, 1317 - Ciqueira Cezar, São Paulo","Fecha às 00:00",R.drawable.resttres));
        modeloList.add(new RestauranteModelo("Bonafide Restaurant","Av. Rio Bonito, 77 - Interlagos, São Paulo","Fecha às 22:30",R.drawable.restum));

        return modeloList;

    }


    @Override
    public void onClick(RestauranteModelo restauranteModelo) {
        Intent intent = new Intent (MainActivity.this, DetalheRestauranteActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("RESTAURANTE", restauranteModelo);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}