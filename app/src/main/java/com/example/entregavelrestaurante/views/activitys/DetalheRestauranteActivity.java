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
    private List<Prato> prat = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_restaurante);
        getSupportActionBar().hide();

        initViews();


        if (getIntent() != null && getIntent().getExtras() != null) {
            RestauranteModelo restauranteModelo = getIntent().getExtras().getParcelable("RESTAURANTE");
            Drawable drawable = getResources().getDrawable(restauranteModelo.getFotoRest());
            logoRestaurante.setImageDrawable(drawable);
            nomeRestaurante.setText(restauranteModelo.getNomeRest());
        }


        recyclerView = findViewById(R.id.recyclerViewRestaurante);

        pratoAdapter = new PratoAdapter(lisPratos(),  this);

        recyclerView.setAdapter(pratoAdapter);

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

    }


    private void initViews() {
        logoRestaurante = findViewById(R.id.imageViewRestaurante);
        nomeRestaurante = findViewById(R.id.textViewRestaurante);
    }

    private List<Prato> lisPratos(){

        if (nomeRestaurante.getText().toString().equals("La Cascada Steake House")) {
            prat.add(new Prato("Hamburger", R.drawable.hamburger, "240g de hambúrguer de picanha no pão tipo brioche, pétalas de Bloomin’ Onion, a nossa incrível cebola empanada, smoked mayo, molho Flame, queijo tipo emmenthal e bacon."));
            prat.add(new Prato("Hamburger", R.drawable.hamburger, "240g de hambúrguer de picanha no pão tipo brioche, pétalas de Bloomin’ Onion, a nossa incrível cebola empanada, smoked mayo, molho Flame, queijo tipo emmenthal e bacon."));
            prat.add(new Prato("Hamburger", R.drawable.hamburger, "240g de hambúrguer de picanha no pão tipo brioche, pétalas de Bloomin’ Onion, a nossa incrível cebola empanada, smoked mayo, molho Flame, queijo tipo emmenthal e bacon."));

        } else if (nomeRestaurante.getText().toString().equals("Toscana Restaurant")){
            prat.add(new Prato("Sobre Mesa", R.drawable.sobremesa, "Nosso brownie exclusivo e quentinho com sorvete de baunilha e deliciosa calda de chocolate preparada diariamente no Outback. Finalizado com chantilly e raspas de chocolate. *Contém nozes ou derivado de nozes."));
            prat.add(new Prato("Sobre Mesa", R.drawable.sobremesa, "Nosso brownie exclusivo e quentinho com sorvete de baunilha e deliciosa calda de chocolate preparada diariamente no Outback. Finalizado com chantilly e raspas de chocolate. *Contém nozes ou derivado de nozes."));
            prat.add(new Prato("Sobre Mesa", R.drawable.sobremesa, "Nosso brownie exclusivo e quentinho com sorvete de baunilha e deliciosa calda de chocolate preparada diariamente no Outback. Finalizado com chantilly e raspas de chocolate. *Contém nozes ou derivado de nozes."));


        } else if (nomeRestaurante.getText().toString().equals("Restaurante requinte")) {
            prat.add(new Prato("Contra file", R.drawable.pratocomida, "Um steak especial: nosso clássico miolo de alcatra com sabor acentuado pelos temperos do Outback. Preparado na chapa no ponto que você preferir. *Produto de 225g não disponível nos restaurantes de Ribeirão Preto, Sorocaba e S. José do Rio Preto"));
            prat.add(new Prato("Contra file", R.drawable.pratocomida, "Um steak especial: nosso clássico miolo de alcatra com sabor acentuado pelos temperos do Outback. Preparado na chapa no ponto que você preferir. *Produto de 225g não disponível nos restaurantes de Ribeirão Preto, Sorocaba e S. José do Rio Preto"));
            prat.add(new Prato("Contra file", R.drawable.pratocomida, "Um steak especial: nosso clássico miolo de alcatra com sabor acentuado pelos temperos do Outback. Preparado na chapa no ponto que você preferir. *Produto de 225g não disponível nos restaurantes de Ribeirão Preto, Sorocaba e S. José do Rio Preto"));

        } else if (nomeRestaurante.getText().toString().equals("Bonafide Restaurant")) {
            prat.add(new Prato("Hamburger", R.drawable.hamburger, "240g de hambúrguer de picanha no pão tipo brioche, pétalas de Bloomin’ Onion, a nossa incrível cebola empanada, smoked mayo, molho Flame, queijo tipo emmenthal e bacon."));
            prat.add(new Prato("Sobre Mesa", R.drawable.sobremesa, "Nosso brownie exclusivo e quentinho com sorvete de baunilha e deliciosa calda de chocolate preparada diariamente no Outback. Finalizado com chantilly e raspas de chocolate. *Contém nozes ou derivado de nozes."));
            prat.add(new Prato("Contra file", R.drawable.pratocomida, "Um steak especial: nosso clássico miolo de alcatra com sabor acentuado pelos temperos do Outback. Preparado na chapa no ponto que você preferir. *Produto de 225g não disponível nos restaurantes de Ribeirão Preto, Sorocaba e S. José do Rio Preto"));
        }

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

